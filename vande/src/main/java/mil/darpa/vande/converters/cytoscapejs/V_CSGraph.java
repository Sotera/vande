package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;

@XmlRootElement(name = "csgraph")
public class V_CSGraph {

	private List<CSEdge> edges = new ArrayList<CSEdge>();

	private int intStatus = 0;

	private List<CSNode> nodes = new ArrayList<CSNode>();
	private String strStatus = "OK";

	public V_CSGraph() {

	}

	public V_CSGraph(final V_GenericGraph g, final boolean gqtStyle) {
		for (V_GenericEdge e : g.getEdges()) {
			edges.add(new CSEdge(e));
		}

		for (V_GenericNode n : g.getNodes()) {
			nodes.add(new CSNode(n));
		}

		intStatus = g.getIntStatus();
		strStatus = g.getStrStatus();

	}

	public void addEdge(final CSEdge grEdge) {
		edges.add(grEdge);
	}

	public void addNode(final CSNode node) {
		nodes.add(node);
	}

	/* (non-Javadoc)
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
		V_CSGraph other = (V_CSGraph) obj;
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

	/**
	 * @return the edges
	 */
	@XmlElement
	public List<CSEdge> getEdges() {
		return edges;
	}

	public int getIntStatus() {
		return intStatus;
	}

	/**
	 * @return the nodes
	 */
	@XmlElement
	public final List<CSNode> getNodes() {
		return nodes;
	}

	public String getStrStatus() {
		return strStatus;
	}

	/* (non-Javadoc)
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

	/**
	 * @param edges
	 *            the edges to set
	 */
	public final void setEdges(final List<CSEdge> edges) {
		this.edges = edges;
	}

	public void setIntStatus(final int intStatus) {
		this.intStatus = intStatus;
	}

	public void setNodes(final List<CSNode> nodes) {
		this.nodes = nodes;
	}

	public void setStrStatus(final String strStatus) {
		this.strStatus = strStatus;
	}

	@Override
	public String toString() {
		return "V_CSGraph [edges=" + edges + ", intStatus=" + intStatus
				+ ", nodes=" + nodes + ", strStatus=" + strStatus + "]";
	}
}
