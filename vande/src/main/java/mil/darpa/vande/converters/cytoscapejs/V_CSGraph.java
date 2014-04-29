package mil.darpa.vande.converters.cytoscapejs;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;

@XmlRootElement(name="csgraph")
public class V_CSGraph {

	private List<CSEdge> edges = new ArrayList<CSEdge>();

	private List<CSNode> nodes = new ArrayList<CSNode>();

	private int intStatus = 0;
	private String strStatus="OK";

	public V_CSGraph()
	{
		
	}
	public V_CSGraph(V_GenericGraph g, boolean GQT_Style)
	{
		for (V_GenericEdge e:g.getEdges())
			edges.add(new CSEdge(e));
		
		for (V_GenericNode n:g.getNodes()) {
			nodes.add(new CSNode(n));
		}
		
		intStatus = g.getIntStatus();
		strStatus = g.getStrStatus();
		
	}

	/**
	 * @return the edges
	 */
	@XmlElement
	public List<CSEdge> getEdges() {
		return edges;
	}

	/**
	 * @return the nodes
	 */
	@XmlElement
	public final List<CSNode> getNodes() {
		return nodes;
	}

	public void addNode(CSNode node) {
		nodes.add(node);
	}
	/**
	 * @param edges
	 *            the edges to set
	 */
	public final void setEdges(List<CSEdge> edges) {
		this.edges = edges;
	}

	public void addEdge(CSEdge grEdge) {
		edges.add(grEdge);
	}
	public int getIntStatus() {
		return intStatus;
	}
	public void setIntStatus(int intStatus) {
		this.intStatus = intStatus;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
}
