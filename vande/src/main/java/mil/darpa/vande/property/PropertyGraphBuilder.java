package mil.darpa.vande.property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mil.darpa.vande.generic.V_EdgeList;
import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphQuery;
import mil.darpa.vande.generic.V_NodeList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Heavily modified from the original legacy code, I've basically converted this
 * using bits and pieces from InteractionGraphBuilder, which is newer. It didn't
 * help that the new code was also filled with spaghetti. --djue
 * 
 * Moved out of legacy package because it might just work. --djue
 * 
 * @author PWG
 * 
 */

public class PropertyGraphBuilder implements V_PropertyCallback {


	
	static Logger logger = LoggerFactory.getLogger(PropertyGraphBuilder.class);

	static boolean oneEdgePerPair = false; // set true if graph vis doesn't
											// allow
	// edges between the same nodes in both directions.
	// TODO: this should be a configuration option

	// private boolean biPartite = false;

	// Set up some local structures so we don't have to keep passing them around
	private Map<String, V_GenericEdge> edgeMap = new HashMap<String, V_GenericEdge>();

	// private long endDate = 0;

	// private boolean GQTStyle = false;

	// This is called 'finder' in some newer code, it was called loader in
	// legacy code..
	// private PropertyFinder finder;

	// private int maxEdgesPerNode = 50; //
	//
	// private int maxNodes = 300; // MFM

	// private int minWeight = 0;

	private V_EdgeList edgeList;// copied over from newer code --djue

	private int maxNodes = 300;

	protected int maxEdgesPerNode = 50;

	//protected NodeFactory nodeFactory = new NodeFactory();

	protected V_NodeList nodeList = new V_NodeList();

	// private V_GraphQuery originalQuery;

	// private boolean showLeafNodes = true;
	// private boolean showNameNodes = true;
	// private long startDate = 0;

	public PropertyGraphBuilder() {
	}

	/**
	 * Constructor.
	 * 
	 * @param GQT_Style
	 *            boolean. True means show the nodes as text so as to resemble
	 *            the legacy Graph Query Tool
	 * @param i
	 */
	// public GraphBuilderDirected(final boolean GQT_Style) {
	// this.GQTStyle = GQT_Style;
	// }

	public Map<String, V_GenericEdge> getEdgeMap() {
		return edgeMap;
	}

	// @Override
	// public long getEndDate() {
	// return endDate;
	// }

	// @Override
	// public PropertyFinder getLoader() {
	// return finder;
	// }

	// public int getMaxEdgesPerNode() {
	// return maxEdgesPerNode;
	// }
	//
	// public int getMaxNodes() {
	// return maxNodes;
	// }

	// public int getMinWeight() {
	// return minWeight;
	// }

//	public NodeFactory getNodeFactory() {
//		return nodeFactory;
//	}

	public V_NodeList getNodeList() {
		return nodeList;
	}

	// public V_GraphQuery getOriginalQuery() {
	// return originalQuery;
	// }

	// ---------------------------------------------------------------------

	// @Override
	// public long getStartDate() {
	// return startDate;
	// }

	// public boolean isBiPartite() {
	// return biPartite;
	// }

	// public boolean isGQT_Style() {
	// return GQTStyle;
	// }

	// public boolean isShowLeafNodes() {
	// return showLeafNodes;
	// }
	//
	// public boolean isShowNameNodes() {
	// return showNameNodes;
	// }

	/**
	 * Make an edge between two nodes if one doesn't already exist
	 * 
	 * @param src
	 *            GRNode source
	 * @param target
	 *            GRNode target
	 * @param degree
	 *            int degree
	 */

//	private void makeEdge(final V_GenericNode src, final V_GenericNode target,
//			final int degree, final int wt, final Number value,
//			final List<Object> edgeAttrs) { // MFM
//
//		// Check for a duplicate edge
//		String fromkey = src.getId() + ":" + target.getId();
//		V_GenericEdge e = edgeMap.get(fromkey);
//		if (e != null) { // duplicate edge
//			e.setCount(e.getCount() + 1); // MFM TODO: REVISIT THIS
//			return;
//		}
//
//		if (oneEdgePerPair) {
//			// check for the reverse edge
//			String tokey = target.getId() + ":" + src.getId();
//			e = edgeMap.get(tokey);
//			if (e != null) {
//				e.setDirected(false); // bidirectional
//				return;
//			}
//		}
//		// make a new edge
//		// logger.trace("Making edge with key " + fromkey); // MFM commented out
//		// trace
//
//		// FIXME: I had to add a lable because of the new constructor --djue
//		e = new V_GenericEdge(src, target, degree, wt, true, "label");
//		e.setWeight(value.intValue());
//		for (Object p : edgeAttrs) {
//			// XXX:This may fail, this unsafe type conversion happened because
//			// we aren't done refactoring.
//			e.addData(((IdProperty) p).getIdName(),
//					((IdProperty) p).getIdValue());
//		}
//		edgeMap.put(fromkey, e);
//
//		// edge exists. Make in non-directed if reverse of this one
//	}

	// Taken from new code
	private void completeEdges() {
		for (V_GenericEdge e : edgeList.getEdges()) {
			e.setIdType("Aggregated Transactions");
			e.setIdVal(e.getSourceId() + " and " + e.getTargetId());
			e.setLabel(Integer.toString(e.getCount()));
			e.addData("Total value", Double.toString(e.getValue()));
			e.addData("Nbr Transactions", Integer.toString(e.getCount()));
		}
	}

	// This is the legacy version --djue
	// @Override
	// public V_GenericGraph makeGraphResponse(final String type,
	// final String[] values, final int maxDegree, final String nodeType)
	// throws Exception {
	//
	// nodeFactory = new NodeFactory();
	// nodeList = new V_NodeList();
	// edgeMap = new HashMap<String, V_GenericEdge>();
	//
	// // aka max hops --djue
	// if (maxDegree <= 0) {
	// return new V_GenericGraph();
	// }
	//
	// nodeFactory.reset();
	//
	// // in newer code this is called scannedActors and it's just Strings
	// Set<DirectableObject> rowList = new HashSet<DirectableObject>();
	//
	// rowList.addAll(finder.pairQuery(originalQuery));
	//
	// // FIXME: again with the damn side effects
	// makeNodes(rowList, 1);
	//
	// for (V_GenericNode n : nodeList.getNodes()) {
	// for (String s : values) {
	// // if (n.getValue().equals(s)) { //legacy--djue
	// if (n.getId().equals(s)) {
	// n.setOrigin(true);
	// }
	// }
	// }
	//
	// // Traversals
	//
	// int degree = 2;
	// int count = 0;
	// for (degree = 2; degree < maxDegree; ++degree) {
	// //this is called oneHop in the new code --djue
	// rowList = oneHopLegacy(degree);
	// count = makeNodes(rowList, degree);
	// logger.debug("After traverse for degree " + degree
	// + " Node count is " + count);
	// if (count > maxNodes) {
	// logger.debug("Too many nodes: will truncate");
	// // truncate(degree);
	// break;
	// }
	// }
	//
	// // temp fix for too many nodes, until truncate is working
	// if (count > maxNodes) {
	// logger.debug("About to recurse");
	// return makeGraphResponse(type, values, maxDegree - 1, nodeType); //
	// recurse
	// }
	// // end temp fix
	// // We have either reached the maxdegrees or maxnodes
	//
	// // t.logAsCompleted();
	//
	// List<V_GenericNode> nodes = new ArrayList<V_GenericNode>();
	// for (V_GenericNode n : nodeList.getNodes()) {
	// // TODO: color should depend on the implementation
	// // String color = NodeColors.getNodeColor(true, n.isOrigin(),
	// // n.isLeaf(), nodeType, 0);
	// // n.setBackgroundColor(color); //this is a legacy thing --djue
	// nodes.add(n);
	// }
	//
	// List<V_GenericEdge> edges = new ArrayList<V_GenericEdge>();
	// edges.addAll(edgeMap.values());
	// V_GenericGraph g = new V_GenericGraph(nodes, edges);
	// return g;
	// }

	// This is the legacy version --djue
	// @Override
	// public V_GenericGraph makeGraphResponse(final String type,
	// final String[] values, final int maxDegree, final String nodeType,final
	// V_GraphQuery q,
	// final PropertyFinder finder)
	// throws Exception {
	//
	// nodeFactory = new NodeFactory();
	// nodeList = new V_NodeList();
	// edgeMap = new HashMap<String, V_GenericEdge>();
	//
	// // aka max hops --djue
	// if (maxDegree <= 0) {
	// return new V_GenericGraph();
	// }
	//
	// nodeFactory.reset();
	//
	// // in newer code this is called scannedActors and it's just Strings
	// Set<DirectableObject> rowList = new HashSet<DirectableObject>();
	//
	// rowList.addAll(finder.pairQuery(originalQuery));
	//
	// // FIXME: again with the damn side effects
	// makeNodes(rowList, 1);
	//
	// for (V_GenericNode n : nodeList.getNodes()) {
	// for (String s : values) {
	// // if (n.getValue().equals(s)) { //legacy--djue
	// if (n.getId().equals(s)) {
	// n.setOrigin(true);
	// }
	// }
	// }
	//
	// // Traversals
	//
	// int degree = 2;
	// int count = 0;
	// for (degree = 2; degree < maxDegree; ++degree) {
	// // this is called oneHop in the new code --djue
	// rowList = oneHopLegacy(degree);
	// count = makeNodes(rowList, degree);
	// logger.debug("After traverse for degree " + degree
	// + " Node count is " + count);
	// if (count > maxNodes) {
	// logger.debug("Too many nodes: will truncate");
	// // truncate(degree);
	// break;
	// }
	// }
	//
	// // temp fix for too many nodes, until truncate is working
	// if (count > maxNodes) {
	// logger.debug("About to recurse");
	// return makeGraphResponse(type, values, maxDegree - 1, nodeType);
	// // recurse
	// }
	// // end temp fix
	// // We have either reached the maxdegrees or maxnodes
	//
	// // t.logAsCompleted();
	//
	// List<V_GenericNode> nodes = new ArrayList<V_GenericNode>();
	// for (V_GenericNode n : nodeList.getNodes()) {
	// // TODO: color should depend on the implementation
	// // String color = NodeColors.getNodeColor(true, n.isOrigin(),
	// // n.isLeaf(), nodeType, 0);
	// // n.setBackgroundColor(color); //this is a legacy thing --djue
	// nodes.add(n);
	// }
	//
	// List<V_GenericEdge> edges = new ArrayList<V_GenericEdge>();
	// edges.addAll(edgeMap.values());
	// V_GenericGraph g = new V_GenericGraph(nodes, edges);
	// return g;
	// }

	/**
	 * Make nodes and edges for all items in the set of rows from the data table
	 * if not already present
	 * 
	 * @param rowList
	 *            Set<DirectableObject>
	 * @param degree
	 *            int current degree of the graph
	 * @return int the number of nodes currently in the graph
	 */
//	private int makeNodes(final Set<DirectableObject> rowList, final int degree) {
//		V_GenericNode senderNode = null;
//		V_GenericNode receiverNode = null;
//		List<Object> attrs;
//
//		logger.debug("Scanning " + rowList.size() + " DB Rows");
//
//		for (DirectableObject e : rowList) {
//			String sender = e.getSrc();
//			String receiver = e.getDest();
//			int wt = e.getWeight(); // MFM added
//			Number val = e.getValue();
//
//			senderNode = nodeList.getNode(sender);
//			if (senderNode == null) {
//				senderNode = nodeFactory.makeDirectedNode(sender, degree);
//				attrs = e.getSrcAttributes();
//				for (Object idp : attrs) {
//					// XXX:This may fail, this unsafe type conversion happened
//					// because we aren't done refactoring.
//					String idName = ((IdProperty) idp).getIdName();
//					String idValue = ((IdProperty) idp).getIdValue();
//					if (idValue != null && idValue.length() > 0) {
//						senderNode.addData(idName, idValue);
//					}
//				}
//				nodeList.addNode(senderNode);
//			}
//
//			receiverNode = nodeList.getNode(receiver);
//			if (receiverNode == null) {
//				receiverNode = nodeFactory.makeDirectedNode(receiver, degree);
//				nodeList.addNode(receiverNode);
//				attrs = e.getDestAttributes();
//				for (Object idp : attrs) {
//					// XXX:This may fail, this unsafe type conversion happened
//					// because we aren't done refactoring.
//					String idName = ((IdProperty) idp).getIdName();
//					String idValue = ((IdProperty) idp).getIdValue();
//					if (idValue != null && idValue.length() > 0) {
//						receiverNode.addData(idName, idValue);
//					}
//				}
//			}
//
//			makeEdge(senderNode, receiverNode, degree, wt, val,
//					e.getEdgeAttributes());
//
//		} // Each row
//
//		return nodeList.size();
//
//	}

	// @Override
	// public void setBiPartite(final boolean biPartite) {
	// logger.trace("Setting biPartite to " + biPartite);
	// this.biPartite = biPartite;
	// }

	public void setEdgeMap(final Map<String, V_GenericEdge> edgeMap) {
		this.edgeMap = edgeMap;
	}

	// @Override
	// public void setEndDate(final long endDate) {
	// this.endDate = endDate;
	// }

	// public void setGQT_Style(final boolean gQT_Style) {
	// GQTStyle = gQT_Style;
	// }

	// @Override
	// public void setMaxEdgesPerNode(final int maxEdgesPerNode) {
	// this.maxEdgesPerNode = maxEdgesPerNode;
	// }
	//
	// @Override
	// public void setMaxNodes(final int maxNodes) {
	// this.maxNodes = maxNodes;
	// }

	// @Override
	// public void setMinWeight(final int weight) {
	// this.minWeight = weight;
	// }
//
//	public void setNodeFactory(final NodeFactory nodeFactory) {
//		this.nodeFactory = nodeFactory;
//	}

	public void setNodeList(final V_NodeList nodeList) {
		this.nodeList = nodeList;
	}

	// public void setOriginalQuery(final V_GraphQuery originalQuery) {
	// this.originalQuery = originalQuery;
	// }

	// @Override
	// public void setQuery(final V_GraphQuery q) {
	// this.originalQuery = q;
	// }

	// @Override
	// public void setShowLeafNodes(final boolean showLeafNodes) {
	// this.showLeafNodes = showLeafNodes;
	// }

	// @Override
	// public void setShowNameNodes(final boolean showNameNodes) {
	// this.showNameNodes = showNameNodes;
	// }

	// @Override
	// public void setStartDate(final long startDate) {
	// this.startDate = startDate;
	// }

	// @Override
	// public void setStyle(final boolean style) {
	// this.GQTStyle = style;
	// }

	/**
	 * Look through our current nodes for any that have not been scanned
	 * 
	 * @param degree
	 *            int
	 * @throws Exception
	 */
	// private Set<DirectableObject> oneHopLegacy(final int degree) throws
	// Exception {
	//
	// Set<DirectableObject> rowSet = new HashSet<DirectableObject>();
	// Set<String> itemsToScan;
	//
	// itemsToScan = nodeList.getUnscannedValues('N', degree);
	//
	// // logger.trace("Traversing. There are " + nodeList.countNodes() +
	// // " nodes so far of which " + itemsToScan.size() + " are unscanned");
	// // MFM commented out
	//
	// if (itemsToScan.size() > 0) {
	// // TODO: optimize by searching using "in"
	// for (String v : itemsToScan) {
	//
	// if (v != null && v.length() > 0) {
	//
	// List<? extends DirectableObject> destns = finder
	// .getDestFor(v, originalQuery);
	// List<? extends DirectableObject> sources = finder
	// .getSrcFor(v, originalQuery);
	//
	// if (destns.size() + sources.size() <= maxEdgesPerNode) {
	// rowSet.addAll(destns);
	// rowSet.addAll(sources);
	// } else {
	// List<? extends DirectableObject> tempSet;
	// if (destns.size() > 0) {
	// tempSet = destns;
	// } else { // placeholder
	// tempSet = sources;
	// Iterator<? extends DirectableObject> it = tempSet
	// .iterator();
	// // XXX:What is going on here? You are iterating but
	// // not using the variable r.
	// DirectableObject r = it.next();
	// V_DirectedNode idNode = nodeFactory
	// .makeDirectedNode(v, degree);
	// idNode.setPlaceholder(true);
	// nodeList.addNode(idNode);
	// }
	// }
	// } // END MFM TEST
	// }
	// nodeList.setAllScanned('N');
	// }
	// logger.debug("After traverse rowSet size is " + rowSet.size()
	// + " and nodelist size is " + nodeList.size());
	//
	// return rowSet;
	// }
	// private Set<DirectableObject> oneHopLegacy(final int degree)
	// throws Exception {
	//
	// Set<DirectableObject> rowSet = new HashSet<DirectableObject>();
	// Set<String> itemsToScan;
	//
	// itemsToScan = nodeList.getUnscannedValues('N', degree);
	//
	// // logger.trace("Traversing. There are " + nodeList.countNodes() +
	// // " nodes so far of which " + itemsToScan.size() + " are unscanned");
	// // MFM commented out
	//
	// if (itemsToScan.size() > 0) {
	// // TODO: optimize by searching using "in"
	// for (String v : itemsToScan) {
	//
	// if (v != null && v.length() > 0) {
	//
	// List<? extends DirectableObject> destns = finder
	// .getDestFor(v, originalQuery);
	// List<? extends DirectableObject> sources = finder
	// .getSrcFor(v, originalQuery);
	//
	// if (destns.size() + sources.size() <= maxEdgesPerNode) {
	// rowSet.addAll(destns);
	// rowSet.addAll(sources);
	// } else {
	// List<? extends DirectableObject> tempSet;
	// if (destns.size() > 0) {
	// tempSet = destns;
	// } else { // placeholder
	// tempSet = sources;
	// Iterator<? extends DirectableObject> it = tempSet
	// .iterator();
	// // XXX:What is going on here? You are iterating but
	// // not using the variable r.
	// DirectableObject r = it.next();
	// V_DirectedNode idNode = nodeFactory
	// .makeDirectedNode(v, degree);
	// idNode.setPlaceholder(true);
	// nodeList.addNode(idNode);
	// }
	// }
	// } // END MFM TEST
	// }
	// nodeList.setAllScanned('N');
	// }
	// logger.debug("After traverse rowSet size is " + rowSet.size()
	// + " and nodelist size is " + nodeList.size());
	//
	// return rowSet;
	// }

	/**
	 * Taken from modern code.
	 * 
	 * @param scannedActors
	 * @param q
	 * @param finder
	 */
	private void oneHop(final Set<String> scannedActors, final V_GraphQuery q,
			final PropertyFinder finder) {
		List<String> idList = new ArrayList<String>();
		// Iterate over each node
		for (V_GenericNode n : nodeList.getNodes()) {
			String id = n.getId();
			// if we haven't scanned
			if (!scannedActors.contains(id)) {
				// Make sure there aren't too many edges.
				long count = finder.countEdges(q, id);
				n.setNbrLinks((int) count);
				if (count > q.getMaxEdgesPerNode()) {
					n.setCluster(true);
				} else {
					idList.add(id);
				}
				scannedActors.add(id);
			}
		}
		if (idList.size() > 0) {
			finder.query(idList, q, this);
		}
	}

	@Override
	public void callBack(V_GenericGraph subgraph) {
		for (V_GenericNode x : subgraph.getNodes()) {
			nodeList.addNode(x);
		}
		for (V_GenericEdge x : subgraph.getEdges()) {
			edgeList.addEdge(x);
		}
		// Create the edges between the nodes
		// first we need to pull out which of the nodes are which (customer no,
		// acno, identifier)
		// then create links between them.
		
		

		// nodeList.addActor(ia.getSource()); // makes a node if not there
		// already
		// nodeList.addActor(ia.getTarget()); // makes a node if not there
		// already
//		if (edgeList.addInteraction(ia, nodeList.getNode(ia.getSourceId()),
//				nodeList.getNode(ia.getTargetId()))) {
//			nodeList.getNode(ia.getSourceId()).incLinks();
//			nodeList.getNode(ia.getTargetId()).incLinks();
//		}
	}

	/**
	 * This is the version copied from InteractionGraphBuilder. --djue
	 * @param q
	 * @param finder
	 * @return
	 * @throws Exception
	 */
	public V_GenericGraph makeGraphResponse(final V_GraphQuery q,
			final PropertyFinder finder) throws Exception {
		if (q.getMaxHops() <= 0) {
			return new V_GenericGraph();
		}

//		nodeFactory = new NodeFactory();
//		nodeFactory.reset();
		nodeList = new V_NodeList();
		// edgeMap = new HashMap<String, V_GenericEdge>();
		this.edgeList = new V_EdgeList(q);

		int intStatus = 0;
		String strStatus = "Graph Loaded";

		char nodeType;
		Set<String> scannedActors = new HashSet<String>();
		List<String> idList = new ArrayList<String>();
		idList.addAll(q.getSearchIds());

		// First hop, based on the original query. Will call us back for each
		// row

		// FIXME: This call uses side effects.
		finder.query(idList, q, this);

		for (String id : idList) {
			scannedActors.add(id);
		}

		// Mark the original query nodes as "origin" so they can be shown
		// in a different color

		for (V_GenericNode n : nodeList.getNodes()) {
			for (String s : idList) {
				if (s.equals(n.getId())) {
					n.setOrigin(true);
				}
			}
		}

		// Do the hops. Note that we don't know whether we have exceeded the max
		// nodes
		// until after each hop. So each time we don't exceed this number we
		// save
		// the state. Then if we exceed maxNodes we can return the last version
		// that
		// didn't exceed it.

		V_NodeList savNodeList = nodeList.clone();
		V_EdgeList savEdgeList = edgeList.clone();

		// aka traversals from legacy--djue
		// FIXME: No reason to use prefix increment here
		for (int hop = 2; hop <= q.getMaxHops(); ++hop) {
			// this was called traverse() in the legacy code. --djue
			oneHop(scannedActors, q, finder);
			if (nodeList.getNodes().size() > q.getMaxNodes()) {
				nodeList = savNodeList;
				edgeList = savEdgeList;
				intStatus = 1; // will trigger the message.
				strStatus = "Returning only "
						+ hop
						+ " hops, as maximum nodes you requested would be exceeded";
				break;
			} else {
				savNodeList = nodeList.clone();
				savEdgeList = edgeList.clone();
			}
		}

		completeEdges();

		nodeList.removeOrphans(edgeList);
		V_GenericGraph g = new V_GenericGraph(nodeList.getNodes(),
				edgeList.getEdges());
		g.setIntStatus(intStatus);
		g.setStrStatus(strStatus);
		return g;

	}

	// Set<KbbEntityref200> rowList = new HashSet<KbbEntityref200>();
	//
	// EntityRefQuery q2 = new EntityRefQuery();
	// q2.setMaxResult(300000); // MFM added
	//
	// if (q.getType().startsWith("customer")) {
	// for (String v : q.getSearchIds()) {
	// q2.getAttributeList().add(
	// new EntitySearchTuple<String>(
	// G_SearchType.COMPARE_EQUALS,
	// G_CanonicalPropertyType.CUSTOMER_NUMBER, v));
	// }
	// nodeType = EntityRefNode.ENTITY_CUSTOMER;
	// }
	//
	// else if (q.getType().startsWith("account")) {
	// for (String v : q.getSearchIds()) {
	// q2.getAttributeList().add(
	// new EntitySearchTuple<String>(
	// G_SearchType.COMPARE_EQUALS,
	// G_CanonicalPropertyType.ACCOUNT, v));
	// }
	// nodeType = EntityRefNode.ENTITY_ACCOUNT;
	// } else if (q.getType().startsWith("id")) {
	// for (String v : q.getSearchIds()) {
	// q2.getAttributeList().add(
	// new EntitySearchTuple<String>(
	// G_SearchType.COMPARE_EQUALS,
	// G_CanonicalPropertyType.ID, v));
	// }
	// nodeType = EntityRefNode.ENTITY_IDENTIFIER;
	// } else {
	// for (String v : q.getSearchIds()) {
	// q2.getAttributeList().add(
	// new EntitySearchTuple<String>(
	// G_SearchType.COMPARE_EQUALS,
	// G_CanonicalPropertyType.ANY, v));
	// }
	// nodeType = EntityRefNode.ENTITY_IDENTIFIER;
	// }
	// rowList.addAll(dao.rowSearch(q2));
	//
	// makeNodes(rowList, 1);
	// for (EntityRefNode n : getNodesByType(nodeType)) {
	// n.setOrigin(true);
	// }
	//
	// // Traversals
	//
	// int degree = 2;
	// int count = 0;
	// for (degree = 2; degree < q.getMaxHops(); ++degree) {
	// rowList = traverse(degree);
	// count = makeNodes(rowList, degree);
	// logger.debug("After traverse for degree " + degree
	// + " Node count is " + count);
	// if (count > maxNodes) {
	// logger.debug("Too many nodes: will truncate");
	// // truncate(degree);
	// break;
	// }
	// }
	//
	// // temp fix for too many nodes, until truncate is working
	// if (count > maxNodes) {
	// logger.debug("About to recurse");
	// q.setMaxHops(q.getMaxHops()-1);
	// //return makeGraphResponse(type, values, maxDegree - 1, ""); // recurse
	// return makeGraphResponse(q,finder); // recurse
	// }
	// // end temp fix
	//
	// rowList = finishCustomers(degree);
	// makeNodes(rowList, degree); // for the finish customers
	//
	// // We have either reached the maxdegrees or maxnodes
	// // We have a node for every identifier, account and customer that was
	// // scanned
	// // We have edges between every customer node and every account node
	// // We have edges beteen every customer node and every identifier node
	//
	// // We don't want to show identifier nodes where either (a) there are
	// // more than
	// // maxNodes edges (placeholder) or (b) there is only one edge.
	//
	// removeLeafNodes();
	// removeOrphanEdges();
	//
	// t.logAsCompleted();
	// List<V_GenericNode> nodes = new ArrayList<V_GenericNode>();
	// nodes.addAll(nodeList.getNodes());
	//
	// List<V_GenericEdge> edges = new ArrayList<V_GenericEdge>();
	// edges.addAll(edgeMap.values());
	// return new V_GenericGraph(nodes, edges);
	// }

//	public List<EntityRefNode> getNodesByType(char type) {
//		List<EntityRefNode> results = new ArrayList<EntityRefNode>();
//		for (V_GenericNode n : nodeList.getNodes()) {
//			if (((EntityRefNode) n).getEntityType() == type)
//				results.add((EntityRefNode) n);
//		}
//		return results;
//	}
}
