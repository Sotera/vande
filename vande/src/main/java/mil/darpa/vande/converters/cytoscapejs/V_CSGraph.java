package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_LegendItem;

@XmlRootElement(name = "csgraph")
public class V_CSGraph {

	private List<CSEdge> edges = new ArrayList<CSEdge>();
	private int intStatus = 0;
	private List<V_LegendItem> legend = new ArrayList<V_LegendItem>();
	private List<CSNode> nodes = new ArrayList<CSNode>();
	private int numEdges;
	private int numNodes;
	private HashMap<String, CSPosition> positionMapping = null;
	private String strStatus = "OK";
	private String userId = "None";
	private String username = "None";

	public V_CSGraph() {

	}

	public V_CSGraph(final V_GenericGraph g, final boolean gqtStyle) {
		if (g == null) {
			intStatus = 1;
			strStatus = "Failed to create a CS graph because no valid Generic Graph was supplied.";
		} else {
			for (final V_GenericEdge e : g.getEdges().values()) {
				edges.add(new CSEdge(e));
			}

			for (final V_GenericNode n : g.getNodes().values()) {
				nodes.add(new CSNode(n));
			}

			for (final V_LegendItem li : g.getLegend()) {
				// TODO convert generic legend item to cytoscape legend item?
				legend.add(li);
			}

			intStatus = g.getIntStatus();
			strStatus = g.getStrStatus();
			username = g.getUsername();
			userId = g.getUserId();
			numEdges = edges.size();
			numNodes = nodes.size();
			createPositionMapping();
		}
	}

	/* * * * * * * * * * * * * * * * * */
	/* GETTERS */
	/* * * * * * * * * * * * * * * * * */

	public void addEdge(final CSEdge grEdge) {
		edges.add(grEdge);
	}

	public void addNode(final CSNode node) {
		nodes.add(node);
	}

	public void createPositionMapping() {
		positionMapping = new HashMap<String, CSPosition>();
		for (final CSNode node : nodes) {
			final String id = node.getData().getId();
			final CSPosition pos = node.getPosition();
			if (pos != null) {
				positionMapping.put(id, pos);
			}
		}
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
		final V_CSGraph other = (V_CSGraph) obj;
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

	@XmlElement
	public List<CSEdge> getEdges() {
		return edges;
	}

	public int getIntStatus() {
		return intStatus;
	}

	@XmlElement
	public final List<V_LegendItem> getLegend() {
		return legend;
	}

	@XmlElement
	public final List<CSNode> getNodes() {
		return nodes;
	}

	public int getNumEdges() {
		return numEdges;
	}

	/* * * * * * * * * * * * * * * * * */
	/* SETTERS */
	/* * * * * * * * * * * * * * * * * */

	public int getNumNodes() {
		return numNodes;
	}

	public HashMap<String, CSPosition> getPositionMapping() {
		return positionMapping;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
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

	public final void setEdges(final List<CSEdge> edges) {
		this.edges = edges;
	}

	public void setIntStatus(final int intStatus) {
		this.intStatus = intStatus;
	}

	public void setLegend(final List<V_LegendItem> legend) {
		this.legend = legend;
	}

	public void setNodes(final List<CSNode> nodes) {
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

	public void setStrStatus(final String strStatus) {
		this.strStatus = strStatus;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public void setUserName(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		// TODO legend.toString();
		return "V_CSGraph [" + "edges=" + edges + ", " + "intStatus=" + intStatus + ", " + "nodes=" + nodes + ", "
				+ "strStatus=" + strStatus + "]";
	}
}
