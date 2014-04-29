package mil.darpa.vande.generic;

import java.util.HashSet;
import java.util.Set;

import mil.darpa.vande.interactions.Interaction;

/**
 * 
 * @author PWG
 * 
 */

public class V_GenericEdge {

	private V_GenericNode sourceNode;
	private V_GenericNode targetNode;

	private String sourceId = "src";
	private String targetId = "target";
	private String idType = "";
	private String idVal = "";
	private int degree = 0;
	private String label;
	private boolean directed = false;
	private int count = 1;
	private double value = 0; // to be a serialized amount to hold aggregated
								// values
								// for the total interactions between the nodes
	// For edges that represent temporal aggregations of links
	private int year = -1;
	private int month = -1;
	private int day = -1;

	private int weight = 1;

	private Set<V_GraphObjectData> dataSet = new HashSet<V_GraphObjectData>();

	public V_GenericEdge() {

	}

	/**
	 * Non-temporal constructor
	 * 
	 * @param src_node
	 *            Generic Node
	 * @param target_node
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
	public V_GenericEdge(V_GenericNode src_node, V_GenericNode target_node,
			int degree, int weight, boolean directed, String label) {
		this.sourceId = src_node.getId();
		this.targetId = target_node.getId();
		this.sourceNode = src_node;
		this.targetNode = target_node;
		this.degree = degree;
		this.weight = weight;
		this.directed = directed;
		this.label = label;
	}

	/**
	 * Constructor with temporal aspect
	 * 
	 * @param src_node
	 *            Generic Node
	 * @param target_node
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
	public V_GenericEdge(V_GenericNode src_node, V_GenericNode target_node,
			int degree, int weight, boolean directed, String label, int day,
			int month, int year) {
		this.sourceId = src_node.getId();
		this.targetId = target_node.getId();
		this.sourceNode = src_node;
		this.targetNode = target_node;
		this.degree = degree;
		this.weight = weight;
		this.directed = directed;
		this.label = label;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void addInteractionProperties(Interaction ia) {
		if (ia.getProperties() != null) {
			for (V_IdProperty p : ia.getProperties()) {
				addData(p.idName, p.idValue);
			}
		}
	}

	public void addData(String name, String value) {
		dataSet.add(new V_GraphObjectData(name, value));
	}

	public void aggregate(int count, double value) {
		this.count += count;
		this.value += value;
	}

	/**
	 * @return the dataSet
	 */
	public final Set<V_GraphObjectData> getDataSet() {
		return dataSet;
	}

	/**
	 * @return the degree
	 */
	public final int getDegree() {
		return degree;
	}

	public String getLabel() {
		return label;
	}

	public final String getSourceId() {
		return sourceId;
	}

	/**
	 * @return the sourceNode
	 */
	public final V_GenericNode getSourceNode() {
		return sourceNode;
	}

	public final String getTargetId() {
		return targetId;
	}

	/**
	 * @return the targetNode
	 */
	public final V_GenericNode getTargetNode() {
		return targetNode;
	}

	/**
	 * Sometimes Gephi will not read in the edge weights if the column is named
	 * weight rather than Weight
	 * 
	 * @return
	 */

	public int getWeight() {
		return weight;
	}

	public int getCount() {
		return count;
	}

	public void removeData(String type) {
		Object l = null;

		for (V_GraphObjectData d : dataSet) {
			if (d.key.equals(type)) {
				l = d;
				break;
			}
		}
		if (l != null)
			dataSet.remove(l);
	}

	/**
	 * @param dataSet
	 *            the dataSet to set
	 */
	public final void setDataSet(Set<V_GraphObjectData> dataSet) {
		this.dataSet = dataSet;
	}

	/**
	 * @param degree
	 *            the degree to set
	 */
	public final void setDegree(int degree) {
		this.degree = degree;
	}

	public void setLabel(String label) {

		this.label = label;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public final void setSourceId(String source) {
		this.sourceId = source;
	}

	/**
	 * @param sourceNode
	 *            the sourceNode to set
	 */

	public final void setSourceNode(V_GenericNode sourceNode) {
		this.sourceNode = sourceNode;
	}

	/**
	 * @param target
	 *            the target to set
	 */

	public final void setTargetId(String target) {
		this.targetId = target;
	}

	/**
	 * @param targetNode
	 *            the targetNode to set
	 */
	public final void setTargetNode(V_GenericNode targetNode) {
		this.targetNode = targetNode;
	}

	/**
	 * Set the number of occurrences of this specific from-to pair
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return ("Edge from " + sourceNode + " to " + targetNode);
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public String getDataValue(String key) {
		for (V_GraphObjectData o : dataSet) {
			if (o.key.equals(key))
				return o.keyVal;
		}
		return null;
	}

	/**
	 * Change the existing value of an attribute or add a new one. <BR>
	 * Different from addData which handles dupes by appending an underscore to
	 * the key
	 * 
	 * @param key
	 * @param value
	 */
	public void setDataValue(String key, String value) {

		for (V_GraphObjectData o : dataSet) {
			if (o.key.equals(key)) {
				dataSet.remove(o);
				break;
			}
		}

		addData(key, value);
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double amount) {
		this.value = amount;
	}

	public void setIntValue(String s) {
		int val = 0;
		try {
			val = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}
		;
		this.value = new Integer(val);
	}

	public void setDoubleValue(double v) {
		this.value = new Double(v);
	}

	public void setDoubleValue(String s) {
		double val = 0D;
		try {
			val = Double.parseDouble(s);
		} catch (NumberFormatException e) {
		}
		;
		this.value = new Double(val);
	}

	public void setIntValue(int v) {
		this.value = new Integer(v);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof V_GenericEdge))
			return false;
		V_GenericEdge e = (V_GenericEdge) o;
		if (!e.getSourceId().equals(sourceId))
			return false;
		if (!e.getTargetId().equals(targetId))
			return false;
		if (e.getYear() != year)
			return false;
		if (e.getMonth() != month)
			return false;
		if (e.getDay() != day)
			return false;

		return true;

	}

	public boolean sameNodes(String s, String t) {
		if (s.equals(sourceId) && t.equals(targetId))
			return true;
		else if (directed)
			return false;
		else
			return t.equals(sourceId) && s.equals(targetId);
	}

	public boolean matches(String s, String t, int day, int month, int year) {
		return (sameNodes(s, t) && this.day == day && this.month == month && this.year == year);
	}

	/**
	 * 
	 * @param ia
	 *            Interaction
	 * @param matchDay
	 *            boolean
	 * @param matchMonth
	 *            boolean
	 * @param matchYear
	 *            boolean
	 * @return boolean true if the interaction matches this edge
	 */
	public boolean matchesInteraction(Interaction ia, boolean matchDay,
			boolean matchMonth, boolean matchYear) {
		if (matchDay) {
			matchMonth = true;
			matchYear = true;
		}
		if (matchMonth)
			matchYear = true;

		if (!sameNodes(ia.getSourceId(), ia.getTargetId()))
			return false;
		if (matchDay && this.day != ia.day)
			return false;
		if (matchMonth && this.month != ia.month)
			return false;
		if (matchYear && this.year != ia.year)
			return false;
		return true;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdVal() {
		return idVal;
	}

	public void setIdVal(String idVal) {
		this.idVal = idVal;
	}
}
