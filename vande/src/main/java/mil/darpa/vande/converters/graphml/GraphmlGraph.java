package mil.darpa.vande.converters.graphml;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;

public class GraphmlGraph {

	private List<GraphmlEdge> edges = new ArrayList<GraphmlEdge>();

	private List<GraphmlNode> nodes = new ArrayList<GraphmlNode>();

	private String nodeType = "Icon";

	/**
	 * 
	 * @param g
	 *            GenericGraph
	 * @param GQT_Style
	 *            true=use the colors from Graphics Query Tool
	 */
	public GraphmlGraph(final V_GenericGraph g, final boolean GQT_Style) {
		for (final V_GenericEdge e : g.getEdges().values()) {
			edges.add(new GraphmlEdge(e));
		}
		for (final V_GenericNode n : g.getNodes().values()) {
			final GraphmlNode node = new GraphmlNode(n);
			node.setColors(GQT_Style);
			nodes.add(new GraphmlNode(n));
		}

	}

	public void addEdge(final GraphmlEdge grEdge) {
		edges.add(grEdge);
	}

	public void addNode(final GraphmlNode node) {
		nodes.add(node);
	}

	/**
	 * @return the edges
	 */
	@XmlElementWrapper(name = "edges")
	@XmlElement(name = "edge")
	public final List<GraphmlEdge> getEdges() {
		return edges;
	}

	/**
	 * @return the nodes
	 */
	@XmlElementWrapper(name = "nodes")
	@XmlElement(name = "node")
	public final List<GraphmlNode> getNodes() {
		return nodes;
	}

	/**
	 * FIXME: This namespace doesn't exist anymore.
	 * 
	 * @return the nodeType
	 */
	@XmlAttribute(namespace = "http://graph.bericotechnologies.com/xmlns")
	public final String getNodeType() {
		return nodeType;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public final void setEdges(final List<GraphmlEdge> edges) {
		this.edges = edges;
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public final void setNodes(final List<GraphmlNode> nodes) {
		this.nodes = nodes;
	}

	/**
	 * 
	 * @param type
	 *            String - either "Icon" or "Text"
	 */
	public void setNodeType(final String type) {
		nodeType = type;
	}

	public String validate() {
		String err = "";
		final Set<String> idList = new HashSet<String>();
		for (final GraphmlNode g : nodes) {
			if (idList.contains(g.getId())) {
				err = " Duplicate node number " + g.getId();
				return err;
			}
			idList.add(g.getId());
		}
		/*
		 * TODO for (GraphmlEdge e : edges) { if
		 * (e.getSource().equals(e.getTarget())) // Note: do not use == or // !=
		 * to // compare strings. err = "Node with source and target the same";
		 * if (!idList.contains(e.getSource())) err =
		 * "Source node for edge is missing"; if
		 * (!idList.contains(e.getTarget())) err =
		 * "Target node for edge is missing";
		 * 
		 * }
		 */
		return err;
	}
}
