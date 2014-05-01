package mil.darpa.vande;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mil.darpa.vande.generic.V_Actor;
import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_IdProperty;

public class V_NodeList {
	
	private Map<String, V_GenericNode> nodes = new HashMap<String, V_GenericNode>();
	public int size(){
		return nodes.size();
	}
	public void addNode(V_GenericNode n)
	{
		nodes.put(n.getId(), n);
	}
	
	public V_GenericNode getNode(String id)
	{
		return nodes.get(id);
	}
	public Collection<V_GenericNode> getNodes()
	{
		return nodes.values();
	}
	/**
	 * Make a new node for the Actor if one doesn't already exist, and adds it to the list
	 * @param a Actor
	 */
	public void addActor(V_Actor a)
	{
		String id = a.getId();
		if (!nodes.containsKey(id)) {
			V_GenericNode n = new V_GenericNode(id);
			n.setLabel(a.getLabel());
			n.setIdType(a.getIdType());
			n.setIdVal(a.getIdVal());
			if (a.getProperties() != null) {
				for (V_IdProperty p:a.getProperties()) {
					n.addData(p.idName, p.idValue);
				}
				
			}
			nodes.put(id,  n);
		}
	}
	public void removeOrphans(V_EdgeList elist) {
		Map<String, V_GenericNode> newnodes = new HashMap<String, V_GenericNode>();

		for (V_GenericEdge e:elist.edges) {
			newnodes.put(e.getSourceId(), e.getSourceNode());
			newnodes.put(e.getTargetId(), e.getTargetNode());
		}
		
		nodes = newnodes;
	}

	public V_NodeList clone()
	{
		V_NodeList l = new V_NodeList();
		l.nodes.putAll(nodes);
		return l;
		
	}

}
