package mil.darpa.vande.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//import mil.darpa.vande.interactions.Interaction;
import mil.darpa.vande.interactions.TemporalGraphQuery;

/**
 * The current implementation of edgeList allows duplicate edges to be added.
 * This may fit the needs for interaction graphs, but really we should disallow
 * trouble causing duplicates by storing a map and forcing classes that add
 * edges to provide a unique key for the interaction/property edge --djue
 * 
 * Updated so that it does not expect genericEdge to contain the actual node
 * objects--just the ids
 * 
 * @author PWG
 * 
 */
public class V_EdgeList implements Cloneable {

	private Set<V_GenericEdge> edges = new HashSet<V_GenericEdge>();
	private V_GraphQuery query;
	private TemporalGraphQuery tquery = null;

	/**
	 * 
	 * @param q
	 */
	public V_EdgeList(final V_GraphQuery q) {
		this.query = q;
		if (q instanceof TemporalGraphQuery) {
			this.tquery = (TemporalGraphQuery) q;
		}
	}

	public final Set<V_GenericEdge> getEdges() {
		return edges;
	}

	public int size() {
		return this.edges.size();
	}
	
	/**
	 * 
	 * @param e
	 */
	public final void addEdge(V_GenericEdge e) {
		edges.add(e);
	}

	/**
	 * GraphQuery can contain minimum values for an edge and for all edges
	 * between any given pair. This method removes edges that don't qualify. We
	 * assume that the edges are aggregated already.
	 * 
	 * @param input
	 *            GraphQuery
	 * @return
	 */
	public final void filterMinEdge(final Set<V_GenericEdge> input) {
		if (tquery.getMinEdgeValue() == 0) {
			return;
		}

		Set<V_GenericEdge> results = new HashSet<V_GenericEdge>();
		for (V_GenericEdge e : edges) {
			if (e.getValue() >= tquery.getMinEdgeValue()) {
				results.add(e);
			} else {
				continue;
			}
		}
		edges = results;
	}

	/**
	 * Takes a set of edges and returns a set of edges where the total value
	 * between any two nodes is greater than the minValuePerpair in the query
	 * 
	 * @return
	 */
	public final void filterMinPair() {
		// TODO FIXME: handle directed versus non directed edges

		double v = tquery.getMinPairValue();
		if (v == 0) {
			return;
		}

		Map<String, Double> pairList = new HashMap<String, Double>();

		Set<V_GenericEdge> results = new HashSet<V_GenericEdge>();
		for (V_GenericEdge e : edges) {
			String s = e.getSourceId() + ":" + e.getTargetId();
			Double d = pairList.get(s);
			if (d == null) {
				pairList.put(s, e.getValue());
			} else {
				d += e.getValue();
			}
		}
		Iterator<Entry<String, Double>> iter = pairList.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Double> x = iter.next();
			if (x.getValue() < v) {
				String[] ids = x.getKey().split(":");
				for (V_GenericEdge e : edges) {
					if (e.sameNodes(ids[0], ids[1])) {
						results.add(e);
					}
				}
			}
		}
		edges = results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public final V_EdgeList clone() {
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		V_EdgeList list = new V_EdgeList(this.query);
		list.edges.addAll(edges);
		return list;
	}
	
	/**
	 * 
	 */
	@Override
	public final String toString() {
		return "V_EdgeList [" + (edges != null ? "edges=" + edges + ", " : "")
				+ (query != null ? "query=" + query + ", " : "")
				+ (tquery != null ? "tquery=" + tquery : "") + "]";
	}
}
