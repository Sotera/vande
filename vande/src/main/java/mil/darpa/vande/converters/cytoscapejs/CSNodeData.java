package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphObjectData;

public class CSNodeData {
	private List<CSAttr> attrs = new ArrayList<CSAttr>();

	private boolean cluster = false;

	private String id;

	private String idType;
	private String idVal;
	private String label;
	private String name;
	private int nbrLinks = 0;
	private boolean origin = false;
	private String type = "circle";
	private boolean visible = true;

	public CSNodeData() {

	}

	public CSNodeData(final V_GenericNode node) {
		this.id = node.getId();
		this.label = node.getLabel();
		this.name = node.getLabel();
		this.idVal = node.getIdVal();
		this.idType = node.getIdType();
		this.origin = node.isOrigin();
		this.cluster = node.isCluster();
		this.nbrLinks = node.getNbrLinks();

		Set<V_GraphObjectData> s = node.getDataSet();
		for (V_GraphObjectData d : s) {
			this.attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
		}

		this.attrs.add(new CSAttr("Links", Integer.toString(this.nbrLinks)));
		if (cluster) {
			this.attrs.add(new CSAttr("Placeholder", "Too many links"));
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSNodeData other = (CSNodeData) obj;
		if (attrs == null) {
			if (other.attrs != null)
				return false;
		} else if (!attrs.equals(other.attrs))
			return false;
		if (cluster != other.cluster)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (idVal == null) {
			if (other.idVal != null)
				return false;
		} else if (!idVal.equals(other.idVal))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbrLinks != other.nbrLinks)
			return false;
		if (origin != other.origin)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	public List<CSAttr> getAttrs() {
		return attrs;
	}

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

	public String getName() {
		return name;
	}

	public int getNbrLinks() {
		return nbrLinks;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attrs == null) ? 0 : attrs.hashCode());
		result = prime * result + (cluster ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((idVal == null) ? 0 : idVal.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nbrLinks;
		result = prime * result + (origin ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (visible ? 1231 : 1237);
		return result;
	}

	public boolean isCluster() {
		return cluster;
	}

	public boolean isOrigin() {
		return origin;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setAttrs(List<CSAttr> attrs) {
		this.attrs = attrs;
	}

	public void setCluster(boolean cluster) {
		this.cluster = cluster;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public void setIdVal(String idVal) {
		this.idVal = idVal;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNbrLinks(int nbrLinks) {
		this.nbrLinks = nbrLinks;
	}

	public void setOrigin(boolean origin) {
		this.origin = origin;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVisible(boolean visible) {
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