package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Used internally for graph generation, and converted into the 
 * appropriate format when serving as a response
 * @author PWG
 *
 */
public class V_GenericGraph {

	private Collection<V_GenericNode> nodes = null;
	private Collection<V_GenericEdge> edges = null;
	private int intStatus = 0;
	private String strStatus="OK";
	
	public V_GenericGraph(Collection<V_GenericNode> nodes, Collection<V_GenericEdge> edges )
	{
		this.nodes=nodes;
		this.edges=edges;
	}
	
	public V_GenericGraph() {
		nodes=new ArrayList<V_GenericNode>();
		edges= new ArrayList<V_GenericEdge>();
		// TODO Auto-generated constructor stub
	}

	public Collection<V_GenericNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<V_GenericNode> nodes) {
		this.nodes = nodes;
	}
	public Collection<V_GenericEdge> getEdges() {
		return edges;
	}
	public void setEdges(List<V_GenericEdge> edges) {
		this.edges = edges;
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
