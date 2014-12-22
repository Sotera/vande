package mil.darpa.vande.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V_NodeList implements Cloneable {

	private Map<String, V_GenericNode> nodes = new HashMap<String, V_GenericNode>(
			4);

	public void add(V_NodeList otherNodeList) {
		this.nodes.putAll(otherNodeList.nodes);
	}

	/**
	 * Make a new node for the Actor if one doesn't already exist, and adds it
	 * to the list
	 * 
	 * 
	 * @param a
	 *            Actor
	 */
	public void addActor(final V_Actor a) {
		String id = a.getId();
		if (!nodes.containsKey(id)) {
			V_GenericNode n = new V_GenericNode(id);
			n.setLabel(a.getLabel());
			n.setIdType(a.getIdType());
			n.setIdVal(a.getIdVal());
			if (a.getProperties() != null) {
				for (V_IdProperty p : a.getProperties()) {
					n.addData(p.getIdName(), p.getIdValue());
				}

			}
			nodes.put(id, n);
		}
	}

	@Override
	public String toString() {
		return "V_NodeList [" + (nodes != null ? "nodes=" + nodes : "") + "]";
	}

	public void addNode(final V_GenericNode n) {
		if (n != null && n.getId() != null && !n.getId().isEmpty()) {
			nodes.put(n.getId(), n);
		}
	}

	public V_NodeList clone() {
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		V_NodeList l = new V_NodeList();
		l.nodes.putAll(nodes);
		return l;

	}

	public V_GenericNode getNode(final String id) {
		return nodes.get(id);
	}

	public Collection<V_GenericNode> getNodes() {
		return nodes.values();
	}

	private Logger logger = LoggerFactory.getLogger(V_NodeList.class);

	/**
	 * What is the compelling reason for this? We would not have added any nodes
	 * to the list unless an edge was possible.
	 * 
	 * @param elist
	 */
	@Deprecated
	public void removeOrphans(final V_EdgeList elist) {
		Map<String, V_GenericNode> newnodes = new HashMap<String, V_GenericNode>();
		logger.debug("Node list size before cleaning: " + nodes.size());
		for (V_GenericEdge e : elist.getEdges()) {
			// newnodes.put(e.getSourceId(), e.getSourceNode());
			// newnodes.put(e.getTargetId(), e.getTargetNode());
			newnodes.put(e.getSourceId(), nodes.get(e.getSourceId()));
			newnodes.put(e.getTargetId(), nodes.get(e.getTargetId()));
		}
		logger.debug("Node list size after cleaning: " + newnodes.size());
		nodes = newnodes;
	}

	public int size() {
		return nodes.size();
	}

	public void clear() {
		nodes.clear();
	}
}
