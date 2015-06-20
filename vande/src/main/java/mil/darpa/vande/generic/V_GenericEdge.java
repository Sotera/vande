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
	private String id;
	private String color = "#23A4FF";

	private int count = 1;

	private Set<V_GraphObjectData> dataSet = new TreeSet<V_GraphObjectData>();
	private int day = -1;
	private int degree = 0;
	private boolean directed = false;
	private final ArrayList<V_GenericEdge> edges;
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
		edges = new ArrayList<V_GenericEdge>();
	}

	/**
	 * Constructor for when you don't have the actual nodes, just their ids.
	 * 
	 * @param edgeId
	 * @param sourceId
	 * @param targetId
	 */
	public V_GenericEdge(final String edgeId, final String sourceId, final String targetId) {
		id = edgeId;
		edges = new ArrayList<V_GenericEdge>();
		this.sourceId = sourceId;
		this.targetId = targetId;
	}

	public V_GenericEdge(final String edgeId, final V_GenericNode src_node, final V_GenericNode target_node) {
		id = edgeId;
		edges = new ArrayList<V_GenericEdge>();
		sourceId = src_node.getId();
		targetId = target_node.getId();
	}

	public void addData(final String name, final String value) {
		if ((null != name) && !name.isEmpty()) {
			// null values are ok, but not null keys.
			dataSet.add(new V_GraphObjectData(name, value));
		}
	}

	public boolean addEdge(final V_GenericEdge e) {
		final int prevSize = edges.size();
		if (e.sourceId.equals(sourceId) && e.targetId.equals(targetId)) {
			edges.add(e);
		}
		return prevSize < edges.size();
	}

	/* * * * * * * * * * * * * * * * * */
	/* GETTERS */
	/* * * * * * * * * * * * * * * * * */

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
		final V_GenericEdge other = (V_GenericEdge) obj;
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
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
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
		for (final V_GraphObjectData o : dataSet) {
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

	public ArrayList<V_GenericEdge> getEdges() {
		return edges;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		final long temp = Double.doubleToLongBits(value);

		result = (prime * result) + count;
		result = (prime * result) + ((dataSet == null) ? 0 : dataSet.hashCode());
		result = (prime * result) + day;
		result = (prime * result) + month;
		result = (prime * result) + year;
		result = (prime * result) + degree;
		result = (prime * result) + (directed ? 1231 : 1237);
		result = (prime * result) + ((color == null) ? 0 : color.hashCode());
		result = (prime * result) + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = (prime * result) + ((idType == null) ? 0 : idType.hashCode());
		result = (prime * result) + ((idVal == null) ? 0 : idVal.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = (prime * result) + ((targetId == null) ? 0 : targetId.hashCode());
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + weight;

		return result;
	}

	/* * * * * * * * * * * * * * * * * */
	/* SETTERS */
	/* * * * * * * * * * * * * * * * * */

	public boolean isDirected() {
		return directed;
	}

	public boolean isEdited() {
		return edited;
	}

	public final boolean isExpanded() {
		return expanded;
	}

	public boolean matches(final String s, final String t, final int day, final int month, final int year) {
		return (sameNodes(s, t) && (this.day == day) && (this.month == month) && (this.year == year));
	}

	public void removeData(final String type) {
		Object l = null;

		for (final V_GraphObjectData d : dataSet) {
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

	public void setColor(final String color) {
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

		for (final V_GraphObjectData o : dataSet) {
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

	public void setDoubleValue(final double v) {
		value = v;
	}

	public void setDoubleValue(final String s) {
		double val = 0D;
		try {
			val = Double.parseDouble(s);
		} catch (final NumberFormatException e) {
			// TODO: error handling
		}

		value = val;
	}

	public void setEdited(final boolean isEdited) {
		edited = isEdited;
	}

	public void setExpanded(final boolean isExpanded) {
		expanded = isExpanded;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id) {
		this.id = id;
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

	/* * * * * * * * * * * * * * * * * */
	/* METHODS */
	/* * * * * * * * * * * * * * * * * */

	/**
	 * Note: V_GenericEdge can accept <i>any</i> kind of style string. It is up
	 * to the graph converter to make sure the V_GenericEdge's line style is
	 * compatible with that graph's expected style types.
	 * 
	 * @param style
	 *            "dotted", "dashed", "solid", etc.
	 */
	public void setLineStyle(final String style) {
		lineStyle = style;
	}

	public void setMonth(final int month) {
		this.month = month;
	}

	public final void setSourceId(final String source) {
		sourceId = source;
	}

	public final void setTargetId(final String target) {
		targetId = target;
	}

	public void setValue(final double amount) {
		value = amount;
	}

	public void setWeight(final int weight) {
		this.weight = weight;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "V_GenericEdge [" + (idVal != null ? "idVal=" + idVal + ", " : "")
				+ (label != null ? "label=" + label + ", " : "") + (color != null ? "color=" + color + ", " : "")
				+ (sourceId != null ? "sourceId=" + sourceId + ", " : "")
				+ (targetId != null ? "targetId=" + targetId : "") + "]";
	}
}
