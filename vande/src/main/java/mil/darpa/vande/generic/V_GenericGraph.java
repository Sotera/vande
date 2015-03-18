package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Used internally for graph generation, and converted into the appropriate
 * format when serving as a response
 * 
 * @author PWG
 * 
 */
public class V_GenericGraph {

	private Map<String, V_GenericEdge> edges = null;

	private int intStatus = 0;

	private Collection<V_LegendItem> legend = null;

	private Map<String, V_GenericNode> nodes = null;
	private int numEdges;
	private int numNodes;
	private String strStatus = "OK";
	private String userId = "None";
	private String username = "None";

	public V_GenericGraph() {
		nodes = new HashMap<String, V_GenericNode>(3);
		edges = new HashMap<String, V_GenericEdge>(3);
		legend = new ArrayList<V_LegendItem>();
	}

	public V_GenericGraph(final Map<String, V_GenericNode> nodes, final Map<String, V_GenericEdge> edges) {
		this.nodes = nodes;
		this.edges = edges;
		legend = new ArrayList<V_LegendItem>();
	}

	public final void addEdge(final V_GenericEdge e) {
		edges.put(e.getId(), e);
	}

	public final void addLegendItem(final String color, final String text) {
		final V_LegendItem li = new V_LegendItem(color, text);
		this.addLegendItem(li);
	}

	public final void addLegendItem(final V_LegendItem li) {
		if (!legend.contains(li)) {
			legend.add(li);
		}
		/*
		 * boolean found = false; for (V_LegendItem existing : legend) { if
		 * (existing.getColor() == li.getColor() && existing.getText() ==
		 * li.getText()) { found = true; break; } } if (!found) legend.add(li);
		 */
	}

	/* * * * * * * * * * * * * * * * * */
	/* GETTERS */
	/* * * * * * * * * * * * * * * * * */

	public final void addNode(final V_GenericNode a) {
		nodes.put(a.getId(), a);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final V_GenericGraph other = (V_GenericGraph) obj;
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
		if (legend == null) {
			if (other.legend != null) {
				return false;
			}
		} else if (!legend.equals(other.legend)) {
			return false;
		}

		return true;
	}

	public final Map<String, V_GenericEdge> getEdges() {
		return edges;
	}

	public final int getIntStatus() {
		return intStatus;
	}

	public final Collection<V_LegendItem> getLegend() {
		return legend;
	}

	public final Map<String, V_GenericNode> getNodes() {
		return nodes;
	}

	public int getNumEdges() {
		return numEdges;
	}

	public int getNumNodes() {
		return numNodes;
	}

	public final String getStrStatus() {
		return strStatus;
	}

	/* * * * * * * * * * * * * * * * * */
	/* SETTERS */
	/* * * * * * * * * * * * * * * * * */

	public String getUserId() {
		return userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
		result = (prime * result) + ((edges == null) ? 0 : edges.hashCode());
		result = (prime * result) + intStatus;
		result = (prime * result) + ((nodes == null) ? 0 : nodes.hashCode());
		result = (prime * result) + ((strStatus == null) ? 0 : strStatus.hashCode());
		result = (prime * result) + ((legend == null) ? 0 : legend.hashCode());
		return result;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(final Map<String, V_GenericEdge> edges) {
		this.edges = edges;
	}

	public final void setIntStatus(final int intStatus) {
		this.intStatus = intStatus;
	}

	public void setLegend(final Collection<V_LegendItem> legend) {
		this.legend = legend;
	}

	public void setNodes(final Map<String, V_GenericNode> nodes) {
		this.nodes = nodes;
	}

	/* * * * * * * * * * * * * * * * * */
	/* METHODS */
	/* * * * * * * * * * * * * * * * * */

	public void setNumEdges(final int numEdges) {
		this.numEdges = numEdges;
	}

	public void setNumNodes(final int numNodes) {
		this.numNodes = numNodes;
	}

	public final void setStrStatus(final String strStatus) {
		this.strStatus = strStatus;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {

		String legendStr = "[";
		for (int i = 0; i < legend.size(); i++) {
			legendStr += ((ArrayList<V_LegendItem>) legend).get(i).toString();
			// postfix each legend item with ',' unless we are at the last one
			legendStr += ((i < (legend.size() - 1)) ? "," : "");
		}
		legendStr += "]";

		return "V_GenericGraph [" + (edges != null ? "edges=" + edges + ", " : "")
				+ (nodes != null ? "nodes=" + nodes + ", " : "") + "intStatus=" + intStatus + ", " + "legend="
				+ legendStr + "," + (strStatus != null ? "strStatus=" + strStatus : "") + "]";
	}

}
