package mil.darpa.vande.generic;

import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A base class that can be extended for other types of nodes in the view layer.
 * 
 * @author PWG
 * 
 */
public class V_GenericNode extends V_Actor {

	protected static final Logger logger = LoggerFactory
			.getLogger(V_GenericNode.class);

	// from and to nodes
	protected SortedSet<V_GraphObjectData> dataSet = new TreeSet<V_GraphObjectData>();

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	protected int dataSource = 0; // TODO: set this value when we have more than

	@Override
	public String toString() {
		return "V_GenericNode [" + (key != null ? "key=" + key + ", " : "")
				+ (value != null ? "value=" + value + ", " : "")
				+ (id != null ? "id=" + id + ", " : "")
				+ (idType != null ? "idType=" + idType + ", " : "")
				+ (idVal != null ? "idVal=" + idVal + ", " : "")
				+ (label != null ? "label=" + label + ", " : "")
				+ (properties != null ? "properties=" + properties : "") + "]";
	}

	protected int degree = 0;

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	protected char entityType;
	protected String family;

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	private boolean isCluster = false;

	protected boolean isLeaf = true; // default, until children added

	protected boolean isOrigin = false; // true if it's the one searched for

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	private boolean isPlaceholder = false;

	protected boolean isUsed = false;
	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	protected String key; // used to locate in nodeList
	protected int nbrLinks = 0;
	private boolean scanned = false; // true when we have searched on this value

	protected boolean traversed = false;

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * Might just use idVal from superclass. --djue
	 */
	protected String value;

	public V_GenericNode() {
		super();
	}

	public V_GenericNode(final String id) {
		super(id);
	}

	/**
	 * Adds a key value pair to the dataSet list that appears in the keys
	 * section of graphml. If an entry with this attribute already exsists,
	 * append "_" to the attribute's name, except for labels, where we set the
	 * shortest version of the customer name.
	 * 
	 * @param attribute
	 *            String the name of the attribute
	 * @param value
	 *            String the value for the attribute
	 */
	public void addData(final String attribute, final String value) {
		// We can have two entries for an identifier name. But SnagL barfs
		// if it gets two entries for the same name. So we kludge the name
		// here
		if (attribute == null || attribute.length() == 0) {
			logger.error("Add Data with empty attribute name, returning without adding ");
			return;
		}

		if (value == null || value.length() == 0) {
			logger.error("Add Data for name " + attribute
					+ " with null value, returning without adding ");
			return;
		}

		// Now add the value
		boolean need_add = false;
		for (V_GraphObjectData d : dataSet) {
			if (d.getKey().equals(attribute)) {
				if (d.getKeyVal().equals(value)) {
					return; // Duplicate attr + value - ignore it
				} else {
					need_add = true; // Duplicate attr, new value
					break;
				}
			}
		}
		if (need_add) { // we have more than one value for the same attribute
			addData(attribute + "_", value); // recursive
			return;
		}

		// So the name doesn't exist in the data set

		dataSet.add(new V_GraphObjectData(attribute, value));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		V_GenericNode other = (V_GenericNode) obj;
		if (dataSet == null) {
			if (other.dataSet != null)
				return false;
		} else if (!dataSet.equals(other.dataSet))
			return false;
		if (dataSource != other.dataSource)
			return false;
		if (degree != other.degree)
			return false;
		if (entityType != other.entityType)
			return false;
		if (isCluster != other.isCluster)
			return false;
		if (isLeaf != other.isLeaf)
			return false;
		if (isOrigin != other.isOrigin)
			return false;
		if (isPlaceholder != other.isPlaceholder)
			return false;
		if (isUsed != other.isUsed)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (nbrLinks != other.nbrLinks)
			return false;
		if (scanned != other.scanned)
			return false;
		if (traversed != other.traversed)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * @return the dataSet
	 */

	public SortedSet<V_GraphObjectData> getDataSet() {
		return dataSet;
	}

	public int getDataSource() {
		return dataSource;
	}

	public String getDataValue(final String key) {
		for (V_GraphObjectData o : dataSet) {
			if (o.key.equals(key)) {
				return o.keyVal;
			}
		}
		return null;
	}

	public int getDegree() {
		return degree;
	}

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	public char getEntityType() {
		return entityType;
	}

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	public String getKey() {
		return key;
	}

	public int getNbrLinks() {
		return nbrLinks;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataSet == null) ? 0 : dataSet.hashCode());
		result = prime * result + dataSource;
		result = prime * result + degree;
		result = prime * result + entityType;
		result = prime * result + (isCluster ? 1231 : 1237);
		result = prime * result + (isLeaf ? 1231 : 1237);
		result = prime * result + (isOrigin ? 1231 : 1237);
		result = prime * result + (isPlaceholder ? 1231 : 1237);
		result = prime * result + (isUsed ? 1231 : 1237);
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + nbrLinks;
		result = prime * result + (scanned ? 1231 : 1237);
		result = prime * result + (traversed ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	public void incLinks() {
		++nbrLinks;
	}

	public boolean isCluster() {
		return isCluster;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public boolean isOrigin() {
		return isOrigin;
	}

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	public boolean isPlaceholder() {
		return isPlaceholder;
	}

	public boolean isScanned() {
		return scanned;
	}

	public boolean isTraversed() {
		return traversed;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void removeData(final String type) {
		Object l = null;

		for (V_GraphObjectData d : dataSet) {
			if (d.getKey().equals(type)) {
				l = d;
				break;
			}
		}
		if (l != null) {
			dataSet.remove(l);
		}
	}

	public void setCluster(final boolean isCluster) {
		this.isCluster = isCluster;
	}

	/**
	 * @param dataSet
	 *            the dataSet to set
	 */
	public final void setDataSet(final SortedSet<V_GraphObjectData> dataSet) {
		this.dataSet = dataSet;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
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
		if (value == null) {
			logger.error("Null value being set for key " + key);
		}
		// V_GraphObjectData d = new V_GraphObjectData(key, value);
		for (V_GraphObjectData o : dataSet) {
			if (o.key.equals(key)) {
				dataSet.remove(o);
				break;
			}
		}

		addData(key, value);
	}

	public void setDegree(final int degree) {
		this.degree = degree;
	}

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	public void setEntityType(final char entityType) {
		this.entityType = entityType;
	}

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	public void setKey(final String key) {
		this.key = key;
	}

	public void setLeaf(final boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public void setNbrLinks(final int nbrLinks) {
		this.nbrLinks = nbrLinks;
	}

	public void setOrigin(final boolean isOrigin) {
		this.isOrigin = isOrigin;
	}

	/*
	 * XXX: Added from legacy for compatibility; reassess the need for this.
	 * --djue
	 */
	public void setPlaceholder(final boolean isPlaceholder) {
		this.isPlaceholder = isPlaceholder;
	}

	public void setScanned(final boolean scanned) {
		this.scanned = scanned;
	}

	public void setTraversed(final boolean traversed) {
		this.traversed = traversed;
	}

	public void setUsed(final boolean isUsed) {
		this.isUsed = isUsed;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
