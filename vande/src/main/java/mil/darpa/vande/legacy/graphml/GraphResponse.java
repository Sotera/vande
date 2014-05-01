package mil.darpa.vande.legacy.graphml;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Deprecated
public class GraphResponse {

	public GraphmlContainer graphml = new GraphmlContainer();

	public GraphResponse() {

	}

	public GraphmlContainer getGraphml() {
		return graphml;
	}

	public GraphmlGraph getGraph() {
		return graphml.graph;
	}

}
