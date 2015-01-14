package mil.darpa.vande.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V_NodeList implements Cloneable {

	private Map<String, V_GenericNode> nodes = new HashMap<String, V_GenericNode>(
			4);

	private final Logger logger = LoggerFactory.getLogger(V_NodeList.class);

	public void add(final V_NodeList otherNodeList) {
		nodes.putAll(otherNodeList.nodes);
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
		final String id = a.getId();
		if (!nodes.containsKey(id)) {
			final V_GenericNode n = new V_GenericNode(id);
			n.setLabel(a.getLabel());
			n.setIdType(a.getIdType());
			n.setIdVal(a.getIdVal());
			if (a.getProperties() != null) {
				for (final V_IdProperty p : a.getProperties()) {
					n.addData(p.getIdName(), p.getIdValue());
				}

			}
			nodes.put(id, n);
		}
	}

	public void addNode(final V_GenericNode n) {
		if ((n != null) && (n.getId() != null) && !n.getId().isEmpty()) {
			nodes.put(n.getId(), n);
		}
	}

	public void clear() {
		nodes.clear();
	}

	@Override
	public V_NodeList clone() {
		try {
			super.clone();
		} catch (final CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final V_NodeList l = new V_NodeList();
		l.nodes.putAll(nodes);
		return l;

	}

	/**
	 * Gets the node from the map based on it's ID
	 * 
	 * @param id
	 * @return
	 */
	public V_GenericNode getNode(final String id) {
		return nodes.get(id);
	}

	public Collection<V_GenericNode> getNodes() {
		return nodes.values();
	}

	/**
	 * What is the compelling reason for this? We would not have added any nodes
	 * to the list unless an edge was possible.
	 * 
	 * @param elist
	 */
	@Deprecated
	public void removeOrphans(final V_EdgeList elist) {
		final Map<String, V_GenericNode> newnodes = new HashMap<String, V_GenericNode>();
		logger.debug("Node list size before cleaning: " + nodes.size());
		for (final V_GenericEdge e : elist.getEdges()) {
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

	@Override
	public String toString() {
		return "V_NodeList [" + (nodes != null ? "nodes=" + nodes : "") + "]";
	}
}
