
package mil.darpa.vande.legacy;
import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphObjectData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An extension of GRNode for directed graph use
 * 
 * @author ??
 * 
 */
public class DirectedNode extends V_GenericNode {

	// TODO: remove any that are dupes of GRNode

	static String origin_bg_color = "#ffff0000";
	static String leaf_bg_color = "#0000ffff";
	private boolean isPlaceholder = false;

	private String valueType = null;
	private boolean used = true;

	static Logger logger = LoggerFactory.getLogger(V_GenericNode.class);


	public DirectedNode(double value, String id) {
		super(id);
//		this.value = value;
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

	public void addData(String attribute, String value, String family) {

		addData(attribute, value);

	}

	public void setLabel(String label) {
		if (label == null || label.length() == 0) {
			logger.error("Setting invalid label into node");
			return;
		}
		removeData("label");
		removeData("node-prop-DisplayValue");

		addData("label", label);
		addData("node-prop-DisplayValue", label);
	}

	public String getLabel() {
		String label = null;

		for (V_GraphObjectData d : dataSet) {
			if (d.getKey().equals("label"))
				label = d.getKeyVal();
		}
		return label;
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

	public void setValueType(String type) {
		addData("IdentifierType", type);
		valueType = type;
	}


	public void setValue(double value) {
		dataSet.add(new V_GraphObjectData("Identifier", Double.toString(value)));
//		this.value = value; // to make traversal easier
	}

	public String getValueType() {
		return valueType;
	}

	public void setIdTableSource(String source) {
		addData("IdentifierTableSource ", source);
	}

	public void setExpandable(boolean b) {
		/*
		 * if (!isOrigin) { removeData("node-prop-BackgroundColor");
		 * 
		 * if (b) { // logger.trace("Setting background color");
		 * addData("node-prop-BackgroundColor", "ffff0000"); } }
		 */
	}

	public void incLinks() {
		++nbrLinks;
	}

	public void decLinks() {
		--nbrLinks;
	}


	// public void setId_type(int id_type) {
	// // Only used for Identifier nodes.
	// // Note that a person might have the same identifier value for more than
	// // one identifier type.
	// // So we use the family rather than the exact identifier. They can still
	// // see the short name when looking
	// // at the linked person node.
	// this.id_type = id_type;
	// setValueType(dao.getFamily(id_type));
	// }

	public boolean isCluster() {
		return isPlaceholder;
	}

	public void setPlaceholder(boolean isPlaceholder) {
		this.isPlaceholder = isPlaceholder;
		String lab = getLabel();
		if (lab.charAt(0) != '[')
			setLabel("[" + lab + "]");
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}


	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "Node: " + getId();
	}

}
