package mil.darpa.vande.converters.graphml;



import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GraphObjectData;

public class GraphmlEdge {
	
	@XmlAttribute private String source = "src";
	@XmlAttribute private String target = "target";
	@XmlAttribute private int degree = 0;
	@XmlAttribute private String label;
	@XmlAttribute private boolean directed = false;
	@XmlAttribute private int weight = 1;

	private Set<V_GraphObjectData> dataSet = new HashSet<V_GraphObjectData>();
	
	public GraphmlEdge(V_GenericEdge e)
	{
		this.source=e.getSourceId();
		this.target=e.getTargetId();
		this.degree=e.getDegree();
		this.label=e.getLabel();
		this.directed=e.isDirected();
		this.weight=e.getWeight();
		this.dataSet.addAll(e.getDataSet());
	}

	@XmlElement(name = "data")
	public final Set<V_GraphObjectData> getDataSet() {
		return dataSet;
	}

}
