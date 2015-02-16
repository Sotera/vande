package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphObjectData;

public class CSNodeData {
	private List<CSAttr> attrs = new ArrayList<CSAttr>();

	private boolean cluster = false;
	private String color = "bababa";
	private boolean expanded, generated;
	private String id;
	private String idType;
	private List<CSNode> subNodes;
	private String idVal;
	private String label;
	private String reason;
	private String name;
	private String parent;
	private int size;
	private int nbrLinks = 0;
	private boolean origin = false;
	private String type = "circle";
	private boolean visible = true;
	private boolean edited = false;

	public CSNodeData() {

	}

	public CSNodeData(final V_GenericNode node) {
		if (node != null) {
			id = node.getId();
			label = node.getLabel();
			name = node.getLabel();
			idVal = node.getIdVal();
			idType = node.getIdType();
			origin = node.isOrigin();
			cluster = node.isCluster();
			nbrLinks = node.getNbrLinks();
			color = node.getColor();
			size = node.getSize();
			edited = node.isEdited();
			final Set<V_GraphObjectData> s = node.getDataSet();
			for (final V_GraphObjectData d : s) {
				if (d.getKey().equalsIgnoreCase("parent")) {
					parent = d.getKeyVal();
				} else {
					attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
				}
			}

			attrs.add(new CSAttr("Links", Integer.toString(nbrLinks)));
			if (cluster) {
				attrs.add(new CSAttr("Placeholder", "Too many links"));
			}
		}
	}

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
		final CSNodeData other = (CSNodeData) obj;
		if (attrs == null) {
			if (other.attrs != null) {
				return false;
			}
		} else if (!attrs.equals(other.attrs)) {
			return false;
		}
		if (cluster != other.cluster) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
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
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (nbrLinks != other.nbrLinks) {
			return false;
		}
		if (origin != other.origin) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (visible != other.visible) {
			return false;
		}
		return true;
	}

	public final List<CSAttr> getAttrs() {
		return attrs;
	}

	/**
	 * @return the color
	 */
	public final String getColor() {
		return color;
	}

	public final String getId() {
		return id;
	}

	public final String getIdType() {
		return idType;
	}

	public final String getIdVal() {
		return idVal;
	}

	public final String getLabel() {
		return label;
	}

	public final String getName() {
		return name;
	}

	public final int getNbrLinks() {
		return nbrLinks;
	}
	
	public final boolean isEdited() {
		return edited;
	}

	/**
	 * @return the parent
	 */
	public final String getParent() {
		return parent;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	public int getSize() {
		return size;
	}

	/**
	 * @return the subNodes
	 */
	public List<CSNode> getSubNodes() {
		return subNodes;
	}

	public final String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((attrs == null) ? 0 : attrs.hashCode());
		result = (prime * result) + (cluster ? 1231 : 1237);
		result = (prime * result) + ((color == null) ? 0 : color.hashCode());
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((idType == null) ? 0 : idType.hashCode());
		result = (prime * result) + ((idVal == null) ? 0 : idVal.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		result = (prime * result) + nbrLinks;
		result = (prime * result) + (origin ? 1231 : 1237);
		result = (prime * result) + ((parent == null) ? 0 : parent.hashCode());
		result = (prime * result) + size;
		result = (prime * result) + ((type == null) ? 0 : type.hashCode());
		result = (prime * result) + (visible ? 1231 : 1237);
		return result;
	}

	public boolean isCluster() {
		return cluster;
	}

	/**
	 * @return the expanded
	 */
	public boolean isExpanded() {
		return expanded;
	}

	/**
	 * @return the generated
	 */
	public boolean isGenerated() {
		return generated;
	}

	public boolean isOrigin() {
		return origin;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setAttrs(final List<CSAttr> attrs) {
		this.attrs = attrs;
	}

	public void setCluster(final boolean cluster) {
		this.cluster = cluster;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	final void setColor(final String color) {
		this.color = color;
	}

	/**
	 * @param expanded
	 *            the expanded to set
	 */
	public void setExpanded(final boolean expanded) {
		this.expanded = expanded;
	}

	/**
	 * @param generated
	 *            the generated to set
	 */
	public void setGenerated(final boolean generated) {
		this.generated = generated;
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

	public void setLabel(final String label) {
		this.label = label;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setNbrLinks(final int nbrLinks) {
		this.nbrLinks = nbrLinks;
	}

	public void setOrigin(final boolean origin) {
		this.origin = origin;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public final void setParent(final String parent) {
		this.parent = parent;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(final String reason) {
		this.reason = reason;
	}

	public void setSize(final int size) {
		this.size = size;
	}
	
	public void setEdited(final boolean isEdited) {
		this.edited = isEdited;
	}

	/**
	 * @param subNodes
	 *            the subNodes to set
	 */
	public void setSubNodes(final List<CSNode> subNodes) {
		this.subNodes = subNodes;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public void setVisible(final boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "CSNodeData [attrs=" + attrs + ", cluster=" + cluster + ", id="
				+ id + ", idType=" + idType + ", idVal=" + idVal + ", label="
				+ label + ", name=" + name + ", nbrLinks=" + nbrLinks
				+ ", origin=" + origin + ", type=" + type + ", visible="
				+ visible + "]";
	}

}