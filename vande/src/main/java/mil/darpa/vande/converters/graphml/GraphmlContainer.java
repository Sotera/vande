package mil.darpa.vande.converters.graphml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "graphml")
public class GraphmlContainer {

	//@XmlElement(name = "graph")
	private GraphmlGraph graph;

	//@XmlElement(name = "key")
	private List<GraphmlKey> keys = new ArrayList<GraphmlKey>();

	public List<GraphmlKey> getKey() {
		return keys;
	}

	public void setKey(List<GraphmlKey> keys) {
		this.keys = keys;
	}

	GraphmlGraph getGraph() {
		return graph;
	}

	/**
 * 
 */
	public GraphmlContainer() {
		// Note: individual graph implementations should add their own initial
		// keys
		addNodeKey("label", "label");
		addNodeKey("node-prop-DisplayValue", "node-prop-DisplayValue");
		addNodeKey("node-prop-ImageSource", "node-prop-ImageSource");
	}

	/**
	 * 
	 * @param graph
	 */
	public GraphmlContainer(final GraphmlGraph graph) {
		this.graph = graph;
		addNodeKey("label", "label");
		addNodeKey("node-prop-DisplayValue", "node-prop-DisplayValue");
		addNodeKey("node-prop-ImageSource", "node-prop-ImageSource");
	}

	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void addNodeKey(final String name, final String value) {
		keys.add(new GraphmlKey(name, "node", value, "string"));
	}

	/**
	 * 
	 * @param graph
	 */
	public void setGraph(final GraphmlGraph graph) {
		this.graph = graph;
	}
}
