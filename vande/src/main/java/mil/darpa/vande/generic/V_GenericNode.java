package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.List;
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
public class V_GenericNode {

	private static final Logger logger = LoggerFactory.getLogger(V_GenericNode.class);

	/**
	 * Why not just use a map? And is it really critical that it be sorted?
	 * 
	 * from and to nodes
	 */
	private SortedSet<V_GraphObjectData> dataSet = new TreeSet<V_GraphObjectData>();
	private SortedSet<V_GraphObjectData> mediaSet = new TreeSet<V_GraphObjectData>();

	/* fields from deprecated V_Actor */
	private boolean edited = false;
	private String id;
	private String idType;
	private String idVal;
	private String label;

	private String color;
	private int degree = 0;
	private boolean isCluster = false;
	private boolean isUsed = false;
	private double minScore = 0.0d;
	private int nbrLinks = 0;
	private double priority = 0.0d;
	private boolean scanned = false; // true when we have searched on this value
	private int size = 16;
	private boolean traversed = false;
	private String imgUrl;
	private String pie = null;
	private Double p1 = 0.0d;
	private Double p2 = 0.0d;
	private Double p3 = 0.0d;

	private Double p4 = 0.0d;

	/** default, until children added */
	private boolean isLeaf = true;

	/** true if it's the one searched for */
	private boolean isOrigin = false;

	/** Used to be called family. */
	private String nodeType;

	public V_GenericNode() {

	}

	public V_GenericNode(final String id) {
		this.id = id;
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
		if ((attribute == null) || (attribute.length() == 0)) {
			// logger.error("Add Data with empty attribute name, returning without adding ");
			return;
		}

		if ((value == null) || (value.length() == 0)) {
			// logger.error("Add Data for name '" + attribute
			// + "' with null value, returning without adding ");
			return;
		}

		// Now add the value
		boolean need_add = false;
		for (final V_GraphObjectData d : dataSet) {
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

	/**
	 * 
	 * @param type
	 * @param sourceURL
	 */
	public void addMedia(final String type, final String sourceURL) {
		if ((type == null) || (type.length() == 0)) {
			return;
		}

		if ((sourceURL == null) || (sourceURL.length() == 0)) {
			return;
		}

		mediaSet.add(new V_GraphObjectData(type, sourceURL));
	}

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
		final V_GenericNode other = (V_GenericNode) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		if (edited != other.edited) {
			return false;
		}
		if (dataSet == null) {
			if (other.dataSet != null) {
				return false;
			}
		} else if (!dataSet.equals(other.dataSet)) {
			return false;
		}
		if (mediaSet == null) {
			if (other.mediaSet != null) {
				return false;
			}
		} else if (!mediaSet.equals(other.mediaSet)) {
			return false;
		}
		if (nodeType == null) {
			if (other.nodeType != null) {
				return false;
			}
		} else if (!nodeType.equals(other.nodeType)) {
			return false;
		}
		if (isCluster != other.isCluster) {
			return false;
		}
		if (isLeaf != other.isLeaf) {
			return false;
		}
		if (isOrigin != other.isOrigin) {
			return false;
		}
		if (isUsed != other.isUsed) {
			return false;
		}
		if (nbrLinks != other.nbrLinks) {
			return false;
		}
		if (scanned != other.scanned) {
			return false;
		}
		if (traversed != other.traversed) {
			return false;
		}
		return true;
	}

	public List<V_GraphObjectData> getAllMediaForType(final String type) {
		final List<V_GraphObjectData> retList = new ArrayList<V_GraphObjectData>();
		for (final V_GraphObjectData o : mediaSet) {
			if (o.key.equals(type)) {
				retList.add(o);
			}
		}
		return retList;
	}

	public final String getColor() {
		return color;
	}

	public SortedSet<V_GraphObjectData> getDataSet() {
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

	public int getDegree() {
		return degree;
	}

	public String getId() {
		return id;
	}

	public final String getIdType() {
		return idType;
	}

	/* * * * * * * * * * * * * * * * * */
	/* GETTERS */
	/* * * * * * * * * * * * * * * * * */

	public final String getIdVal() {
		return idVal;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public final String getLabel() {
		return label;
	}

	public SortedSet<V_GraphObjectData> getMediaSet() {
		return mediaSet;
	}

	public double getMinScore() {
		return minScore;
	}

	public int getNbrLinks() {
		return nbrLinks;
	}

	/**
	 * We use the family to determine what to search on, so be careful what you
	 * set it to!
	 * 
	 * @return
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * @return the p1
	 */
	public Double getP1() {
		return p1;
	}

	/**
	 * @return the p2
	 */
	public Double getP2() {
		return p2;
	}

	/**
	 * @return the p3
	 */
	public Double getP3() {
		return p3;
	}

	/**
	 * @return the p4
	 */
	public Double getP4() {
		return p4;
	}

	/**
	 * @return the pie
	 */
	public String getPie() {
		return pie;
	}

	public double getPriority() {
		return priority;
	}

	public int getSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((idType == null) ? 0 : idType.hashCode());
		result = (prime * result) + ((idVal == null) ? 0 : idVal.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + ((dataSet == null) ? 0 : dataSet.hashCode());
		result = (prime * result) + degree;
		result = (prime * result) + ((nodeType == null) ? 0 : nodeType.hashCode());
		result = (prime * result) + (isCluster ? 1231 : 1237);
		result = (prime * result) + (isLeaf ? 1231 : 1237);
		result = (prime * result) + (isOrigin ? 1231 : 1237);
		result = (prime * result) + (isUsed ? 1231 : 1237);
		result = (prime * result) + nbrLinks;
		result = (prime * result) + (scanned ? 1231 : 1237);
		result = (prime * result) + (traversed ? 1231 : 1237);
		return result;
	}

	@Deprecated
	public void incLinks() {
		nbrLinks++;
	}

	public void inheritPropertiesOf(final V_GenericNode a) {
		dataSet.addAll(a.getDataSet());
		// mediaSet.addAll(a.getMediaSet());
	}

	public void inheritPropertiesOfExcept(final V_GenericNode a, final ArrayList<String> skipTypes) {
		for (final V_GraphObjectData kva : a.getDataSet()) {
			if (!skipTypes.contains(kva.getKey())) {
				// dataSet.addAll(a.getDataSet());
				dataSet.add(kva);
				// break;
			}
		}
	}

	public boolean isCluster() {
		return isCluster;
	}

	public final boolean isEdited() {
		return edited;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public boolean isOrigin() {
		return isOrigin;
	}

	public boolean isScanned() {
		return scanned;
	}

	/* * * * * * * * * * * * * * * * * */
	/* SETTERS */
	/* * * * * * * * * * * * * * * * * */

	public boolean isTraversed() {
		return traversed;
	}

	public boolean isUsed() {
		return isUsed;
	}

	/**
	 * 
	 * @param type
	 *            will be compared to the key of the object data
	 */
	public void removeData(final String type) {
		Object l = null;

		for (final V_GraphObjectData d : dataSet) {
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

	public final void setColor(final String c) {
		color = c;
	}

	public final void setDataSet(final SortedSet<V_GraphObjectData> dataSet) {
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
		if (value == null) {
			logger.error("Null value being set for key " + key);
		}

		// V_GraphObjectData d = new V_GraphObjectData(key, value);
		for (final V_GraphObjectData o : dataSet) {
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

	// TODO removeMedia for mediaSet

	public void setEdited(final boolean isEdited) {
		edited = isEdited;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setIdType(final String idType) {
		this.idType = idType;
	}

	public void setIdVal(final String idVal) {
		this.idVal = idVal;
	}

	public void setImgUrl(final String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public void setLeaf(final boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public final void setMediaSet(final SortedSet<V_GraphObjectData> mediaSet) {
		this.mediaSet = mediaSet;
	}

	public void setMinScore(final double minScore) {
		this.minScore = minScore;
	}

	public void setNbrLinks(final int nbrLinks) {
		this.nbrLinks = nbrLinks;
	}

	public void setNodeType(final String family) {
		nodeType = family;
	}

	public void setOrigin(final boolean isOrigin) {
		this.isOrigin = isOrigin;
	}

	/* * * * * * * * * * * * * * * * * */
	/* METHODS */
	/* * * * * * * * * * * * * * * * * */

	/**
	 * @param p1
	 *            the p1 to set
	 */
	public void setP1(final Double p1) {
		this.p1 = p1;
	}

	/**
	 * @param p2
	 *            the p2 to set
	 */
	public void setP2(final Double p2) {
		this.p2 = p2;
	}

	/**
	 * @param p3
	 *            the p3 to set
	 */
	public void setP3(final Double p3) {
		this.p3 = p3;
	}

	/**
	 * @param p4
	 *            the p4 to set
	 */
	public void setP4(final Double p4) {
		this.p4 = p4;
	}

	/**
	 * @param pie
	 *            the pie to set
	 */
	public void setPie(final String pie) {
		this.pie = pie;
	}

	public void setPriority(final double priority) {
		this.priority = priority;
	}

	public void setScanned(final boolean scanned) {
		this.scanned = scanned;
	}

	public void setSize(final int size) {
		this.size = size;
	}

	public void setTraversed(final boolean traversed) {
		this.traversed = traversed;
	}

	public void setUsed(final boolean isUsed) {
		this.isUsed = isUsed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "V_GenericNode [" + (id != null ? "id=" + id + ", " : "")
				+ (idType != null ? "idType=" + idType + ", " : "") + (idVal != null ? "idVal=" + idVal + ", " : "")
				+ (label != null ? "label=" + label + ", " : "")
				+ (nodeType != null ? "nodeType=" + nodeType + ", " : "")
				+ (dataSet != null ? "dataSet=" + dataSet : "") + "]";
	}
}
