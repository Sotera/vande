package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Used internally for graph generation, and converted into the appropriate
 * format when serving as a response
 * 
 * @author PWG
 * 
 */
public class V_GenericGraph {

	public void setEdges(Collection<V_GenericEdge> edges) {
		this.edges = edges;
	}

	public void setNodes(Collection<V_GenericNode> nodes) {
		this.nodes = nodes;
	}

	private Collection<V_GenericEdge> edges = null;
	private int intStatus = 0;
	private Collection<V_GenericNode> nodes = null;
	private String strStatus = "OK";

	public V_GenericGraph() {
		nodes = new ArrayList<V_GenericNode>(3);
		edges = new ArrayList<V_GenericEdge>(3);
		// TODO Auto-generated constructor stub
	}

	public V_GenericGraph(final Collection<V_GenericNode> nodes,
			final Collection<V_GenericEdge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "V_GenericGraph ["
				+ (edges != null ? "edges=" + edges + ", " : "") + "intStatus="
				+ intStatus + ", "
				+ (nodes != null ? "nodes=" + nodes + ", " : "")
				+ (strStatus != null ? "strStatus=" + strStatus : "") + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + intStatus;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result
				+ ((strStatus == null) ? 0 : strStatus.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		V_GenericGraph other = (V_GenericGraph) obj;
		if (edges == null) {
			if (other.edges != null) {
				return false;
			}
		} else if (!edges.equals(other.edges)) {
			return false;
		}
		if (intStatus != other.intStatus) {
			return false;
		}
		if (nodes == null) {
			if (other.nodes != null) {
				return false;
			}
		} else if (!nodes.equals(other.nodes)) {
			return false;
		}
		if (strStatus == null) {
			if (other.strStatus != null) {
				return false;
			}
		} else if (!strStatus.equals(other.strStatus)) {
			return false;
		}
		return true;
	}

	public final Collection<V_GenericEdge> getEdges() {
		return edges;
	}

	public final int getIntStatus() {
		return intStatus;
	}

	public final Collection<V_GenericNode> getNodes() {
		return nodes;
	}

	public final String getStrStatus() {
		return strStatus;
	}

	public void setEdges(final List<V_GenericEdge> edges) {
		this.edges = edges;
	}

	public final void setIntStatus(final int intStatus) {
		this.intStatus = intStatus;
	}

	public final void setNodes(final List<V_GenericNode> nodes) {
		this.nodes = nodes;
	}

	public final void setStrStatus(final String strStatus) {
		this.strStatus = strStatus;
	}

	public final void addNode(final V_GenericNode a) {
		this.nodes.add(a);
	}

	public final void addEdge(final V_GenericEdge e) {
		this.edges.add(e);
	}

}
