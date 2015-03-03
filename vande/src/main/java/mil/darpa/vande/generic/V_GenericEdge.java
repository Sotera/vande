package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Updated so that it does not retain the actual node objects, just their ids.
 * 
 * @author PWG
 * 
 */

public class V_GenericEdge {
	// TODO: Add color and styling ability.
	// TODO: Respect directionality boolean in js code
	private String color = "#23A4FF";
	private int count = 1;
	private Set<V_GraphObjectData> dataSet = new TreeSet<V_GraphObjectData>();
	private int day = -1;
	private int degree = 0;
	private boolean directed = false;
	private ArrayList<V_GenericEdge> edges;
	private boolean edited = false;
	private boolean expanded = false;
	private String idType = "";
	private String idVal = "";
	private String label;
	private String lineStyle = "solid";
	private int month = -1;
	private String sourceId = "src";
	private String targetId = "target";
	private double value = 0; // to be a serialized amount to hold aggregated
	private int weight = 1; // Consider allowing double or Number
	private int year = -1;

	public V_GenericEdge() {
		this.edges = new ArrayList<V_GenericEdge>();
	}

	public V_GenericEdge(final V_GenericNode src_node, final V_GenericNode target_node) {
		this.edges = new ArrayList<V_GenericEdge>();
		this.sourceId = src_node.getId();
		this.targetId = target_node.getId();
	}

	/**
	 * TODO: Taken from legacy code. Determine if still needed.
	 * 
	 * @param srcNode
	 * @param target_node
	 * @param degree
	 */
	public V_GenericEdge(final V_GenericNode srcNode, final V_GenericNode targetNode, final int degree) {
		this.edges = new ArrayList<V_GenericEdge>();
		this.sourceId = srcNode.getId();
		this.targetId = targetNode.getId();
		this.degree = degree;
		this.count = degree;
	}

	/**
	 * Non-temporal constructor
	 * 
	 * @param srcNode
	 *            Generic Node
	 * @param targetNode
	 *            Generic Node
	 * @param degree
	 *            int
	 * @param weight
	 *            int
	 * @param directed
	 *            boolean
	 * @param label
	 *            String
	 */
	public V_GenericEdge(final V_GenericNode srcNode,
			final V_GenericNode targetNode, final int degree, final int weight,
			final boolean directed, final String label) {
		this.edges = new ArrayList<V_GenericEdge>();
		this.sourceId = srcNode.getId();
		this.targetId = targetNode.getId();
		this.degree = degree;
		this.weight = weight;
		this.directed = directed;
		this.label = label;
	}

	/**
	 * Constructor with temporal aspect
	 * 
	 * @param srcNode
	 *            Generic Node
	 * @param targetNode
	 *            Generic Node
	 * @param degree
	 *            int
	 * @param weight
	 *            int
	 * @param directed
	 *            boolean
	 * @param label
	 *            String
	 * @param day
	 *            int
	 * @param month
	 * @param year
	 *            int
	 */
	public V_GenericEdge(final V_GenericNode srcNode,
			final V_GenericNode targetNode, final int degree, final int weight,
			final boolean directed, final String label, final int day,
			final int month, final int year) {
		this.edges = new ArrayList<V_GenericEdge>();
		this.sourceId = srcNode.getId();
		this.targetId = targetNode.getId();
		this.degree = degree;
		this.weight = weight;
		this.directed = directed;
		this.label = label;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/* * * * * * * * * * * * * * * * * */
	/*             GETTERS             */
	/* * * * * * * * * * * * * * * * * */
	
	public String getColor() {
		return color;
	}
	
	public int getCount() {
		return count;
	}
	
	public final Set<V_GraphObjectData> getDataSet() {
		return dataSet;
	}
	
	public String getDataValue(final String key) {
		for (V_GraphObjectData o : dataSet) {
			if (o.key.equals(key)) {
				return o.keyVal;
			}
		}
		return null;
	}
	
	public int getDay() {
		return day;
	}

	/**
	 * XXX:Only used by the graphml flavor of edges, not sure if needed --djue
	 * 
	 * @return the degree
	 */
	public final int getDegree() {
		return degree;
	}

	public boolean isDirected() {
		return directed;
	}

	public ArrayList<V_GenericEdge> getEdges() {
		return this.edges;
	}
	
	public boolean isEdited() {
		return edited;
	}

	public final boolean isExpanded() {
		return expanded;
	}
	
	public String getIdType() {
		return idType;
	}

	public String getIdVal() {
		return idVal;
	}
	
	public String getLabel() {
		return label;
	}

	public String getLineStyle() {
		return lineStyle;
	}
	
	public int getMonth() {
		return month;
	}

	public final String getSourceId() {
		return sourceId;
	}

	public final String getTargetId() {
		return targetId;
	}

	public double getValue() {
		return value;
	}

	/**
	 * Sometimes Gephi will not read in the edge weights if the column is named
	 * weight rather than Weight
	 * 
	 * @return
	 */
	public final int getWeight() {
		return weight;
	}

	public final int getYear() {
		return year;
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             SETTERS             */
	/* * * * * * * * * * * * * * * * * */
	
	public void setColor(String color) {
		// TODO: verify string input is color or hex value
		this.color = color;
	}
	
	/**
	 * Set the number of occurrences of this specific from-to pair
	 * 
	 * @param count
	 */
	public void setCount(final int count) {
		this.count = count;
	}

	/**
	 * @param dataSet
	 *            the dataSet to set
	 */
	public final void setDataSet(final Set<V_GraphObjectData> dataSet) {
		this.dataSet = dataSet;
	}

	/**
	 * Change the existing value of an attribute or add a new one. <BR>
	 * Different from addData which handles dupes by appending an underscore to
	 * the key
	 * 
	 * @param key
	 * @param value
	 */
	public void setDataValue(final String key, final String value) {

		for (V_GraphObjectData o : dataSet) {
			if (o.key.equals(key)) {
				dataSet.remove(o);
				break;
			}
		}

		addData(key, value);
	}

	public void setDay(final int day) {
		this.day = day;
	}

	/**
	 * XXX:This seems unused.
	 * 
	 * @param degree
	 *            the degree to set
	 */
	public final void setDegree(final int degree) {
		this.degree = degree;
	}

	public void setDirected(final boolean directed) {
		this.directed = directed;
	}
	
	public void setEdited(final boolean isEdited) {
		this.edited = isEdited;
	}

	public void setExpanded(final boolean isExpanded) {
		this.expanded = isExpanded;
	}
	
	public void setIdType(final String idType) {
		this.idType = idType;
	}

	public void setIdVal(final String idVal) {
		this.idVal = idVal;
	}

	public void setLabel(final String label) {
		this.label = label;
	}
	
	/**
	 * Note: V_GenericEdge can accept <i>any</i> kind of style string. 
	 * It is up to the graph converter to make sure the 
	 * V_GenericEdge's line style is compatible with that 
	 * graph's expected style types.
	 * @param style "dotted", "dashed", "solid", etc.
	 */
	public void setLineStyle(String style) {
		this.lineStyle = style;
	}
	
	public void setMonth(final int month) {
		this.month = month;
	}
	
	public final void setSourceId(final String source) {
		this.sourceId = source;
	}

	public final void setTargetId(final String target) {
		this.targetId = target;
	}
	
	public void setValue(final double amount) {
		this.value = amount;
	}
	
	public void setDoubleValue(final double v) {
		this.value = v;
	}

	public void setDoubleValue(final String s) {
		double val = 0D;
		try {
			val = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			// TODO: error handling
		}

		this.value = val;
	}
	
	public void setWeight(final int weight) {
		this.weight = weight;
	}

	public void setYear(final int year) {
		this.year = year;
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             METHODS             */
	/* * * * * * * * * * * * * * * * * */
	
	public void addData(final String name, final String value) {
		if (null != name && !name.isEmpty()) {
			// null values are ok, but not null keys.
			dataSet.add(new V_GraphObjectData(name, value));
		}
	}
	
	public boolean addEdge(V_GenericEdge e) {
		int prevSize = this.edges.size();
		if (e.sourceId.equals(this.sourceId) && e.targetId.equals(this.targetId)) {
			this.edges.add(e);
		}
		return prevSize < this.edges.size();
	}
	
	public boolean matches(final String s, final String t, final int day,
			final int month, final int year) {
		return (sameNodes(s, t) && this.day == day && this.month == month && this.year == year);
	}
	
	public void removeData(final String type) {
		Object l = null;

		for (V_GraphObjectData d : dataSet) {
			if (d.key.equals(type)) {
				l = d;
				break;
			}
		}
		if (l != null) {
			dataSet.remove(l);
		}
	}

	/**
	 * Checks the parameters against the ids of the nodes for this edge, to see
	 * if they deal with the same nodes.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean sameNodes(final String s, final String t) {
		// See if it is an exact match.
		if (s.equals(sourceId) && t.equals(targetId)) {
			return true;
		} else if (directed) {
			// if the order mattered, return false because it wasn't an exact
			// match.
			return false;
		} else {
			// try the other order
			return t.equals(sourceId) && s.equals(targetId);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
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
		V_GenericEdge other = (V_GenericEdge) obj;
		if (count != other.count) {
			return false;
		}
		if (dataSet == null) {
			if (other.dataSet != null) {
				return false;
			}
		} else if (!dataSet.equals(other.dataSet)) {
			return false;
		}
		if (day != other.day) {
			return false;
		}
		if (degree != other.degree) {
			return false;
		}
		if (directed != other.directed) {
			return false;
		}
		if (color != other.color) {
			return false;
		}
		if (edited != other.edited) {
			return false;
		}
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (idType == null) {
			if (other.idType != null) {
				return false;
			}
		} else if (!idType.equals(other.idType)) {
			return false;
		}
		if (idVal == null) {
			if (other.idVal != null) {
				return false;
			}
		} else if (!idVal.equals(other.idVal)) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (month != other.month) {
			return false;
		}
		if (sourceId == null) {
			if (other.sourceId != null) {
				return false;
			}
		} else if (!sourceId.equals(other.sourceId)) {
			return false;
		}
		if (targetId == null) {
			if (other.targetId != null) {
				return false;
			}
		} else if (!targetId.equals(other.targetId)) {
			return false;
		}
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value)) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		if (year != other.year) {
			return false;
		}
		return true;
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
		long temp = Double.doubleToLongBits(value);
		
		result = prime * result + count;
		result = prime * result + ((dataSet == null) ? 0 : dataSet.hashCode());
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		result = prime * result + degree;
		result = prime * result + (directed ? 1231 : 1237);
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((idVal == null) ? 0 : idVal.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((targetId == null) ? 0 : targetId.hashCode());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + weight;
		
		return result;
	}

	@Override
	public String toString() {
		return "V_GenericEdge ["
				+ (idVal != null ? "idVal=" + idVal + ", " : "")
				+ (label != null ? "label=" + label + ", " : "")
				+ (color != null ? "color=" + color + ", " : "")
				+ (sourceId != null ? "sourceId=" + sourceId + ", " : "")
				+ (targetId != null ? "targetId=" + targetId : "") + "]";
	}
}
