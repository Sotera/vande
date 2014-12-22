package mil.darpa.vande.converters.graphml;

import java.util.SortedSet;
import java.util.TreeSet;

import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphObjectData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphmlNode {
	protected static final Logger logger = LoggerFactory
			.getLogger(GraphmlNode.class);

	//@XmlElement(name = "data")
	private SortedSet<V_GraphObjectData> data = new TreeSet<V_GraphObjectData>();
	//@XmlAttribute
	private String id = "";

	//@XmlAttribute
	private String label = "";

	public final SortedSet<V_GraphObjectData> getDataSet() {
		return data;
	}

	public final void setDataSet(SortedSet<V_GraphObjectData> dataSet) {
		this.data = dataSet;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getLabel() {
		return label;
	}

	public GraphmlNode(final V_GenericNode node) {
		this.id = node.getId();
		this.label = node.getLabel(); // temp - not really part of graphml
		data.addAll(node.getDataSet());
		setLabel(node.getLabel()); // node-prop format
	}

	public final void addData(final String attribute, final String value) {
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
		for (V_GraphObjectData d : data) {
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

		data.add(new V_GraphObjectData(attribute, value));
	}

	private void removeData(final String type) {
		Object l = null;

		for (V_GraphObjectData d : data) {
			if (d.getKey().equals(type)) {
				l = d;
				break;
			}
		}
		if (l != null) {
			data.remove(l);
		}
	}

	public void setColors(final boolean GQTStyle) {
		// TODO
	}

	private void setLabel(final String label) {
		if (label == null || label.length() == 0) {
			logger.error("Setting invalid label into node");
			return;
		}
		removeData("label");
		removeData("node-prop-DisplayValue");

		addData("label", label);
		addData("node-prop-DisplayValue", label);
	}

}
