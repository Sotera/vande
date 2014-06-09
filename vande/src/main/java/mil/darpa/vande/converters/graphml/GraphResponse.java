package mil.darpa.vande.converters.graphml;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GraphResponse {

	public GraphmlContainer graphml = new GraphmlContainer();

	public GraphResponse() {

	}

	public GraphmlGraph getGraph() {
		return graphml.getGraph();
	}

	public GraphmlContainer getGraphml() {
		return graphml;
	}

}
