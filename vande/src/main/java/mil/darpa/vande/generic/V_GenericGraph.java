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
		return "V_GenericGraph [edges=" + edges + ", intStatus=" + intStatus
				+ ", nodes=" + nodes + ", strStatus=" + strStatus + "]";
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		V_GenericGraph other = (V_GenericGraph) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (intStatus != other.intStatus)
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		if (strStatus == null) {
			if (other.strStatus != null)
				return false;
		} else if (!strStatus.equals(other.strStatus))
			return false;
		return true;
	}

	public Collection<V_GenericEdge> getEdges() {
		return edges;
	}

	public int getIntStatus() {
		return intStatus;
	}

	public Collection<V_GenericNode> getNodes() {
		return nodes;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setEdges(final List<V_GenericEdge> edges) {
		this.edges = edges;
	}

	public void setIntStatus(final int intStatus) {
		this.intStatus = intStatus;
	}

	public void setNodes(final List<V_GenericNode> nodes) {
		this.nodes = nodes;
	}

	public void setStrStatus(final String strStatus) {
		this.strStatus = strStatus;
	}

	public void addNode(V_GenericNode a) {
		this.nodes.add(a);
	}

	public void addEdge(V_GenericEdge e) {
		this.edges.add(e);
	}

	
}
