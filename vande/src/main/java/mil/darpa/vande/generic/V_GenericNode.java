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


	protected boolean traversed = false;
	protected boolean isOrigin = false; // true if it's the one searched for
	protected boolean isLeaf = true; // default, until children added
	protected int degree = 0;
	private boolean isCluster = false;
	protected boolean isUsed = false;
	protected int nbrLinks = 0;
	private boolean scanned = false; // true when we have searched on this value
	protected SortedSet<V_GraphObjectData> dataSet = new TreeSet<V_GraphObjectData>();
	
	protected static final Logger logger = LoggerFactory
			.getLogger(V_GenericNode.class);

	
	public V_GenericNode(String id) {
		super(id);
	}

	/**
	 * @return the dataSet
	 */

	public SortedSet<V_GraphObjectData> getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSet
	 *            the dataSet to set
	 */
	public final void setDataSet(SortedSet<V_GraphObjectData> dataSet) {
		this.dataSet = dataSet;
	}


	public boolean isTraversed() {
		return traversed;
	}

	public void setTraversed(boolean traversed) {
		this.traversed = traversed;
	}

	public boolean isOrigin() {
		return isOrigin;
	}

	public void setOrigin(boolean isOrigin) {
		this.isOrigin = isOrigin;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public boolean isCluster() {
		return isCluster;
	}

	public void setCluster(boolean isCluster) {
		this.isCluster = isCluster;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getNbrLinks() {
		return nbrLinks;
	}

	public void setNbrLinks(int nbrLinks) {
		this.nbrLinks = nbrLinks;
	}

	public void incLinks() {
		++nbrLinks;
	}


	public void removeData(String type) {
		Object l = null;

		for (V_GraphObjectData d : dataSet) {
			if (d.getKey().equals(type)) {
				l = d;
				break;
			}
		}
		if (l != null)
			dataSet.remove(l);
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
	public void addData(String attribute, String value) {
		// We can have two entries for an identifier name. But SnagL barfs
		// if it gets two entries for the same name. So we kludge the name
		// here

		try {
			if (attribute == null || attribute.length() == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error(
					"Add Data with empty attribute name " + e.getMessage(), e);
			return;
		}

		if (value == null || value.length() == 0) {
			logger.error("Add Data for name " + attribute + " with null value");
			new Exception().printStackTrace();
			return;
		}

		// Now add the value
		boolean need_add = false;
		for (V_GraphObjectData d : dataSet) {
			if (d.getKey().equals(attribute)) {
				if (d.getKeyVal().equals(value))
					return; // Duplicate attr + value - ignore it
				else {
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

	public String getDataValue(String key)
	{
		for (V_GraphObjectData o:dataSet) {
			if (o.key.equals(key))
				return o.keyVal;
		}
		return null;
	}
	
	/**
	 * Change the existing value of an attribute or add a new one.
	 * <BR>Different from addData which handles dupes by appending an underscore to the key 
	 * @param key
	 * @param value
	 */
	public void setDataValue(String key, String value)
	{
		if (value==null) {
			logger.error("Null value being set for key " + key);
		}
		//V_GraphObjectData d = new V_GraphObjectData(key, value);
		for (V_GraphObjectData o:dataSet) {
			if (o.key.equals(key)) {
				dataSet.remove(o);
				break;
			}
		}
		
		addData(key, value);
	}
	public boolean isScanned() {
		return scanned;
	}

	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}


}
