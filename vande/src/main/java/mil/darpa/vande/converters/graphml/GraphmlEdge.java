package mil.darpa.vande.converters.graphml;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GraphObjectData;

public class GraphmlEdge {

	private Set<V_GraphObjectData> dataSet = new HashSet<V_GraphObjectData>();
	@XmlAttribute
	private int degree = 0;
	@XmlAttribute
	private boolean directed = false;
	@XmlAttribute
	private String label;
	@XmlAttribute
	private String source = "src";
	@XmlAttribute
	private String target = "target";

	@XmlAttribute
	private int weight = 1;

	public GraphmlEdge() {
		// TODO Auto-generated constructor stub
	}

	public GraphmlEdge(final V_GenericEdge e) {
		this.source = e.getSourceId();
		this.target = e.getTargetId();
		this.degree = e.getDegree();
		this.label = e.getLabel();
		this.directed = e.isDirected();
		this.weight = e.getWeight();
		this.dataSet.addAll(e.getDataSet());
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
		GraphmlEdge other = (GraphmlEdge) obj;
		if (dataSet == null) {
			if (other.dataSet != null) {
				return false;
			}
		} else if (!dataSet.equals(other.dataSet)) {
			return false;
		}
		if (degree != other.degree) {
			return false;
		}
		if (directed != other.directed) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (source == null) {
			if (other.source != null) {
				return false;
			}
		} else if (!source.equals(other.source)) {
			return false;
		}
		if (target == null) {
			if (other.target != null) {
				return false;
			}
		} else if (!target.equals(other.target)) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		return true;
	}

	@XmlElement(name = "data")
	public final Set<V_GraphObjectData> getDataSet() {
		return dataSet;
	}

	public final int getDegree() {
		return degree;
	}

	public final String getLabel() {
		return label;
	}

	public final String getSource() {
		return source;
	}

	public final String getTarget() {
		return target;
	}

	public final int getWeight() {
		return weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSet == null) ? 0 : dataSet.hashCode());
		result = prime * result + degree;
		result = prime * result + (directed ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + weight;
		return result;
	}

	boolean isDirected() {
		return directed;
	}

	void setDataSet(Set<V_GraphObjectData> dataSet) {
		this.dataSet = dataSet;
	}

	void setDegree(int degree) {
		this.degree = degree;
	}

	void setDirected(boolean directed) {
		this.directed = directed;
	}

	void setLabel(String label) {
		this.label = label;
	}

	void setSource(String source) {
		this.source = source;
	}

	void setTarget(String target) {
		this.target = target;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "GraphmlEdge [dataSet=" + dataSet + ", degree=" + degree
				+ ", directed=" + directed + ", label=" + label + ", source="
				+ source + ", target=" + target + ", weight=" + weight + "]";
	}

}
