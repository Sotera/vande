package mil.darpa.vande.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import mil.darpa.vande.interactions.Interaction;
import mil.darpa.vande.interactions.TemporalGraphQuery;

/**
 * The current implementation of edgeList allows duplicate edges to be added.
 * This may fit the needs for interaction graphs, but really we should disallow
 * trouble causing duplicates by storing a map and forcing classes that add
 * edges to provide a unique key for the interaction/property edge --djue
 * 
 * Updated so that it does not expect genericEdge to contain the actual node objects--just the ids
 * 
 * @author PWG
 * 
 */
public class V_EdgeList implements Cloneable{

	private Set<V_GenericEdge> edges = new HashSet<V_GenericEdge>();
	private V_GraphQuery query;
	private TemporalGraphQuery tquery = null;

	public V_EdgeList(final V_GraphQuery q) {
		this.query = q;
		if (q instanceof TemporalGraphQuery) {
			this.tquery = (TemporalGraphQuery) q;
		}
	}

	/**
	 * Evaluates the interaction against the query, and if valid assigns it to
	 * an edge (using temporal bucketing if requested in the query)
	 * 
	 * @param ia
	 *            Interaction
	 * @param sourceNode
	 *            GenericNode
	 * @param targetNode
	 *            GenericNode
	 */
	public boolean addInteraction(final Interaction ia,
			final V_GenericNode sourceNode, final V_GenericNode targetNode) {

		if (ia.getValue() < tquery.getMinTransValue()) {
			return false;
		}
//
//		checkGlobal(ia, sourceNode, targetNode);
//
//		if (tquery.isByYear()) {
//			checkYearly(ia, sourceNode, targetNode);
//		}
//
//		if (tquery.isByMonth()) {
//			checkMonthly(ia, sourceNode, targetNode);
//		}
//
//		if (tquery.isByDay()) {
//			checkDaily(ia, sourceNode, targetNode);
//		}

		return true;
	}

	@Override
	public String toString() {
		return "V_EdgeList [" + (edges != null ? "edges=" + edges + ", " : "")
				+ (query != null ? "query=" + query + ", " : "")
				+ (tquery != null ? "tquery=" + tquery : "") + "]";
	}

	/**
	 * This is stupid, get this aggregation logic out of here. --djue
	 * 
	 * @param ia
	 * @param sourceNode
	 * @param targetNode
	 */
//	private void checkDaily(final Interaction ia,
//			final V_GenericNode sourceNode, final V_GenericNode targetNode) {
//		boolean found = false;
//
//		// First, add it to the full aggregation edge
//
//		for (V_GenericEdge e : edges) {
//			if (e.matchesInteraction(ia, true, true, true)) {
//				e.aggregate(1, ia.getValue());
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			V_GenericEdge e = makeEdge(ia, sourceNode, targetNode);
//			e.setDay(ia.getDay());
//			e.setMonth(ia.getMonth());
//			e.setYear(ia.getYear());
//			edges.add(e);
//		}
//	}

	/**
	 * This is stupid, get this aggregation logic out of here. --djue
	 * 
	 * @param ia
	 * @param sourceNode
	 * @param targetNode
	 */
//	private void checkGlobal(final Interaction ia,
//			final V_GenericNode sourceNode, final V_GenericNode targetNode) {
//		boolean found = false;
//
//		// First, add it to the full aggregation edge
//
//		for (V_GenericEdge e : edges) {
//			if (e.matchesInteraction(ia, false, false, false)) {
//				e.aggregate(1, ia.getValue());
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			V_GenericEdge e = makeEdge(ia, sourceNode, targetNode);
//			e.setDay(-1);
//			e.setMonth(-1);
//			e.setYear(-1);
//			edges.add(e);
//		}
//	}

	/**
	 * This is stupid, get this aggregation logic out of here. --djue
	 * 
	 * @param ia
	 * @param sourceNode
	 * @param targetNode
	 */
//	private void checkMonthly(final Interaction ia,
//			final V_GenericNode sourceNode, final V_GenericNode targetNode) {
//		boolean found = false;
//
//		// First, add it to the full aggregation edge
//
//		for (V_GenericEdge e : edges) {
//			if (e.matchesInteraction(ia, false, true, true)) {
//				e.aggregate(1, ia.getValue());
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			V_GenericEdge e = makeEdge(ia, sourceNode, targetNode);
//			e.setDay(-1);
//			e.setMonth(ia.getMonth());
//			e.setYear(ia.getYear());
//			edges.add(e);
//		}
//	}

	/**
	 * This is stupid, get this aggregation logic out of here. --djue
	 * 
	 * @param ia
	 * @param sourceNode
	 * @param targetNode
	 */
//	private void checkYearly(final Interaction ia,
//			final V_GenericNode sourceNode, final V_GenericNode targetNode) {
//		boolean found = false;
//
//		// First, add it to the full aggregation edge
//
//		for (V_GenericEdge e : edges) {
//			if (e.matchesInteraction(ia, false, false, true)) {
//				e.aggregate(1, ia.getValue());
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			V_GenericEdge e = makeEdge(ia, sourceNode, targetNode);
//			e.setDay(-1);
//			e.setMonth(-1);
//			e.setYear(ia.getYear());
//			edges.add(e);
//		}
//	}

	/**
	 * Why?? --djue
	 */
	public V_EdgeList clone() {
		V_EdgeList list = new V_EdgeList(this.query);
		list.edges.addAll(edges);
		return list;
	}

	/**
	 * GraphQuery can contain minimum values for an edge and for all edges
	 * between any given pair. This method removes edges that don't qualify. We
	 * assume that the edges are aggregated already.
	 * 
	 * @param q
	 *            GraphQuery
	 * @return
	 */
	public void filterMinEdge(final Set<V_GenericEdge> input) {
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
	 * @param input
	 *            Set<GenericEdge>
	 * @param q
	 *            GraphQuery
	 * @returns Set<GenericEdge>
	 */
	public void filterMinPair() {
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

		for (String s : pairList.keySet()) {
			if (pairList.get(s) < v) {
				String[] ids = s.split(":");
				for (V_GenericEdge e : edges) {
					if (e.sameNodes(ids[0], ids[1])) {
						results.add(e);
					}
				}

			}
		}
		edges = results;
	}

	/**
	 * Add a new edge to a set of edges, aggregating the value if it already
	 * exists. Effectively buckets into time periods also because if month is
	 * different for example it makes a new edge for that month
	 * 
	 * @param transaction
	 *            GenericEdge corresponding to a single row from a data set to
	 *            aggregate
	 */
	public Set<V_GenericEdge> getEdges() {
		return edges;
	}

	private V_GenericEdge makeEdge(final Interaction ia,
			final V_GenericNode sourceNode, final V_GenericNode targetNode) {
		V_GenericEdge e = new V_GenericEdge();
		e.setSourceId(ia.getSourceId());
		e.setTargetId(ia.getTargetId());

//		e.setSourceNode(sourceNode);
//		e.setTargetNode(targetNode);
		e.setValue(ia.getValue());
		e.setDirected(query.isDirected());
		e.setCount(1);
		e.addInteractionProperties(ia);

		// TODO: setLabel? Perhaps this should be in ia, as the choice of
		// what to use for the label should be customer-specific

		return e;
	}

	public void addEdge(V_GenericEdge e) {
		edges.add(e);
	}

}
