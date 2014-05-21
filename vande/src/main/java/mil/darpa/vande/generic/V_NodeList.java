package mil.darpa.vande.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class V_NodeList {

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

	public void addNode(final V_GenericNode n) {
		nodes.put(n.getId(), n);
	}

	public V_NodeList clone() {
		V_NodeList l = new V_NodeList();
		l.nodes.putAll(nodes);
		return l;

	}

	/**
	 * XXX:Remove usage of this, put logic elsewhere. Taken from legacy code.
	 * This constructs a special key using a prefix of the character you supply
	 * plus a colon (:).
	 * 
	 * @param entityType
	 * @param value
	 * @return
	 */
	public V_GenericNode getNode(final char entityType, final String value) {
		return nodes.get(entityType + ":" + value);
	}

	public V_GenericNode getNode(final String id) {
		return nodes.get(id);
	}

	public Collection<V_GenericNode> getNodes() {
		return nodes.values();
	}

	/**
	 * XXX:Remove usage of this, put logic elsewhere.
	 * 
	 * @param type
	 * @param degree
	 * @return
	 */
	@Deprecated
	public Set<String> getUnscannedValues(final char type, final int degree) {
		Set<String> results = new HashSet<String>();
		for (V_GenericNode n : nodes.values()) {
			if (n.getEntityType() != type) {
				continue;
			}
			if (n.isTraversed()) {
				continue;
			}
			if (n.isPlaceholder()) {
				continue;
			}
			if (degree != 0 && n.getDegree() >= degree) {
				continue;
			}
			// Note we don't have a value field anymore
			// results.add(n.getValue());
			// try using the id val instead.
			results.add(n.getIdVal());
		}
		return results;
	}

	/**
	 * XXX:Remove usage of this, put logic elsewhere.
	 * 
	 * @param node
	 * @return
	 */
	@Deprecated
	public boolean hasNode(final V_GenericNode node) {
		return nodes.containsKey(node.getKey());
	}

	public void removeOrphans(final V_EdgeList elist) {
		Map<String, V_GenericNode> newnodes = new HashMap<String, V_GenericNode>();

		for (V_GenericEdge e : elist.getEdges()) {
			newnodes.put(e.getSourceId(), e.getSourceNode());
			newnodes.put(e.getTargetId(), e.getTargetNode());
		}

		nodes = newnodes;
	}

	/**
	 * XXX:Remove usage of this, put logic elsewhere.
	 * 
	 * @param type
	 */
	@Deprecated
	public void setAllScanned(final char type) {
		for (V_GenericNode n : nodes.values()) {
			if (n.getEntityType() == type) {
				n.setTraversed(true);
			}
		}

	}

	/**
	 * XXX:Remove usage of this, put logic elsewhere.
	 * 
	 * This seems to essentially remove any nodes that are unused,
	 * non-identifiers.
	 */
//	@Deprecated
//	public void removeUnused() {
//		Map<String, V_GenericNode> map = new HashMap<String, V_GenericNode>();
//		for (V_GenericNode n : nodes.values()) {
//			if (map.containsKey(n.getKey())) {
//				continue;
//			}
//			if ((n.getEntityType() != EntityRefNode.ENTITY_IDENTIFIER)
//					|| n.isUsed()) {
//				map.put(n.getKey(), n);
//			}
//		}
//		nodes = map;
//	}

	public int size() {
		return nodes.size();
	}
}
