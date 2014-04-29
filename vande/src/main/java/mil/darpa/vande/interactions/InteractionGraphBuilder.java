package mil.darpa.vande.interactions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.InteractionFinder;
import mil.darpa.vande.TemporalGraphQuery;
import mil.darpa.vande.V_EdgeList;
import mil.darpa.vande.V_NodeList;
import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author PWG
 * 
 */
public class InteractionGraphBuilder implements InteractionCallback  {
	
	static Logger logger = LoggerFactory.getLogger(InteractionGraphBuilder.class);
	
	private V_NodeList nodeList;
	private V_EdgeList edgeList;
	
	private V_GraphQuery originalQuery;

	public InteractionGraphBuilder(V_GraphQuery q) {
		this.originalQuery = q;
	}

	public V_GenericGraph makeGraphResponse(TemporalGraphQuery q, InteractionFinder finder)
	{
		this.nodeList = new V_NodeList();
		this.edgeList = new V_EdgeList(q);
		
		int intStatus = 0;
		String strStatus="Graph Loaded";
		
		Set<String> scannedActors = new HashSet<String>();
		
		if (q.getMaxHops() <= 0) // guard against infinite recursion
			return new V_GenericGraph();
		
//		TimeReporter t = new TimeReporter("Calculate Graph", logger);

		List<String> idList = new ArrayList<String> ();
		idList.addAll(q.getSearchIds());

// First hop, based on the original query. Will call us back for each row
		
		finder.query(idList, originalQuery, this);
		
		for (String id:idList)
			scannedActors.add(id);

// Mark the original query nodes as "origin" so they can be shown
// in a different color
		
		for (V_GenericNode n : nodeList.getNodes()) {
			for (String s : idList)
				if (n.getId().equals(s))
					n.setOrigin(true);
		}

// Do the hops. Note that we don't know whether we have exceeded the max nodes
// until after each hop. So each time we don't exceed this number we save
// the state. Then if we exceed maxNodes we can return the last version that
// didn't exceed it.
		
		V_NodeList savNodeList = nodeList.clone();
		V_EdgeList savEdgeList= edgeList.clone();
		
		for (int hop = 2; hop <= q.getMaxHops(); ++hop) {
			oneHop(scannedActors,  q, finder);
			if (nodeList.getNodes().size() > q.getMaxNodes()) {
				nodeList = savNodeList;
				edgeList = savEdgeList;
				intStatus = 1; // will trigger the message.
				strStatus="Returning only " + hop + " hops, as maximum nodes you requested would be exceeded";
				break;
			}
			else {
				savNodeList = nodeList.clone();
				savEdgeList = edgeList.clone();
			}
		}
		
		completeEdges();

		nodeList.removeOrphans(edgeList);
		V_GenericGraph g = new V_GenericGraph(nodeList.getNodes(), edgeList.getEdges());
		g.setIntStatus(intStatus);
		g.setStrStatus(strStatus);
		return g;

	}

	private void oneHop(Set<String> scannedActors, TemporalGraphQuery q, InteractionFinder finder)
	{
		List<String> idList = new ArrayList<String> ();
		for (V_GenericNode n:nodeList.getNodes()) {
			String id = n.getId();
			if (!scannedActors.contains(id)) {
				// Make sure there aren't too many edges.
				long count = finder.countEdges(q, id);
				n.setNbrLinks((int) count);
				if (count > q.getMaxEdgesPerNode()) {
					n.setCluster(true);
				}
				else
					idList.add(id);
				scannedActors.add(id);
			}
		}
		finder.query(idList, originalQuery, this);
		
		
	}
	private void completeEdges() {
		for (V_GenericEdge e : edgeList.getEdges()) {
			e.setIdType("Aggregated Transactions");
			e.setIdVal(e.getSourceId() + " and " + e.getTargetId());
			e.setLabel(Integer.toString(e.getCount()));
			e.addData("Total value", Double.toString(e.getValue()));
			e.addData("Nbr Transactions", Integer.toString(e.getCount()));
		}
	}
	
	/**
	 * the interaction finder (client-specific) calls this method
	 * for each row in the source data search results. This methodology 
	 * allows the client to iterate through large data sets without the 
	 * need to store them in memory as would needed if the client cached 
	 * them all before returning the whole result set
	 * 
	 * @param ia Interaction.
	 */
	public void callBack(Interaction ia)
	{
		nodeList.addActor(ia.getSource()); // makes a node if not there already
		nodeList.addActor(ia.getTarget()); // makes a node if not there already
		if (edgeList.addInteraction(ia, nodeList.getNode(ia.getSourceId()), nodeList.getNode(ia.getTargetId()))) {
			nodeList.getNode(ia.getSourceId()).incLinks();
			nodeList.getNode(ia.getTargetId()).incLinks();			
		}
	}
}

