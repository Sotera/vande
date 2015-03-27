package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphObjectData;

public class CSNodeData {
	
	private List<CSAttr> attrs = new ArrayList<CSAttr>();
	private List<CSAttr> media = new ArrayList<CSAttr>();
	
	private boolean cluster = false;
	private String color = "bababa";
	private boolean edited = false;
	private boolean expanded;
	private boolean generated;
	private String id;
	private String idType;
	private String idVal;
	private String imgUrl = null;
	private String label;
	private String name;
	private int nbrLinks = 0;
	private boolean origin = false;
	private String parentId;
	private String reason;
	private int size;
	private List<CSNode> subNodes;
	private String type = "circle";
	private boolean visible = true;

	public CSNodeData() {

	}

	public CSNodeData(final V_GenericNode node) {
		if (node != null) {
			id = node.getId();
			label = node.getLabel();
			name = node.getLabel();
			idVal = node.getIdVal();
			idType = node.getIdType();
			imgUrl = node.getImgUrl();
			origin = node.isOrigin();
			cluster = node.isCluster();
			nbrLinks = node.getNbrLinks();
			color = node.getColor();
			size = node.getSize();
			edited = node.isEdited();
			
			final Set<V_GraphObjectData> s = node.getDataSet();
			for (final V_GraphObjectData d : s) {
				if (d.getKey().equalsIgnoreCase("parent")) {
				//	parent = d.getKeyVal();
				} else {
					attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
				}
			}
			attrs.add(new CSAttr("Links", Integer.toString(nbrLinks)));

			final Set<V_GraphObjectData> m = node.getMediaSet();
			for (final V_GraphObjectData d : m) {
				media.add(new CSAttr(d.getKey(), d.getKeyVal()));
			}
			
			if (cluster) {
				attrs.add(new CSAttr("Placeholder", "Too many links"));
			}
		}
	}

	/* * * * * * * * * * * * * * * * * */
	/*             GETTERS             */
	/* * * * * * * * * * * * * * * * * */

	public final List<CSAttr> getAttrs() {
		return attrs;
	}

	public final List<CSAttr> getMedia() {
		return media;
	}
	
	public boolean isCluster() {
		return cluster;
	}
	
	public final String getColor() {
		return color;
	}

	public final boolean isEdited() {
		return edited;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public boolean isGenerated() {
		return generated;
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
	
	public final String getImgUrl() {
		return imgUrl;
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

	public boolean isOrigin() {
		return origin;
	}
	
	public final String getParentId() {
		return parentId;
	}

	public String getReason() {
		return reason;
	}

	public int getSize() {
		return size;
	}

	public List<CSNode> getSubNodes() {
		return subNodes;
	}

	public final String getType() {
		return type;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             SETTERS             */
	/* * * * * * * * * * * * * * * * * */	
	
	public void setAttrs(final List<CSAttr> attrs) {
		this.attrs = attrs;
	}
	
	public void setMedia(final List<CSAttr> media) {
		this.media = media;
	}

	public void setCluster(final boolean cluster) {
		this.cluster = cluster;
	}

	final void setColor(final String color) {
		this.color = color;
	}
	
	public void setEdited(final boolean isEdited) {
		this.edited = isEdited;
	}

	public void setExpanded(final boolean expanded) {
		this.expanded = expanded;
	}

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
	
	public void setImgUrl(final String imgUrl) {
		this.imgUrl = imgUrl;
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
	
	public final void setParentId(final String parentId) {
		this.parentId = parentId;
	}

	public void setReason(final String reason) {
		this.reason = reason;
	}

	public void setSize(final int size) {
		this.size = size;
	}
	
	public void setSubNodes(final List<CSNode> subNodes) {
		this.subNodes = subNodes;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public void setVisible(final boolean visible) {
		this.visible = visible;
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             METHODS             */
	/* * * * * * * * * * * * * * * * * */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((attrs == null) ? 0 : attrs.hashCode());
		result = (prime * result) + ((media ==  null) ? 0 : media.hashCode());
		result = (prime * result) + (cluster ? 1231 : 1237);
		result = (prime * result) + ((color == null) ? 0 : color.hashCode());
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((idType == null) ? 0 : idType.hashCode());
		result = (prime * result) + ((idVal == null) ? 0 : idVal.hashCode());
		result = (prime * result) + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		result = (prime * result) + nbrLinks;
		result = (prime * result) + (origin ? 1231 : 1237);
		result = (prime * result) + ((parentId == null) ? 0 : parentId.hashCode());
		result = (prime * result) + size;
		result = (prime * result) + ((type == null) ? 0 : type.hashCode());
		result = (prime * result) + (visible ? 1231 : 1237);
		return result;
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
		if (media == null) {
			if (other.media != null) {
				return false;
			}
		} else if (!media.equals(other.media)) {
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
		if (imgUrl == null) {
			if (other.imgUrl != null) {
				return false;
			}
		} else if (!imgUrl.equals(other.imgUrl)) {
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
		if (parentId == null) {
			if (other.parentId != null) {
				return false;
			}
		} else if (!parentId.equals(other.parentId)) {
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
	
	@Override
	public String toString() {
		return "CSNodeData [attrs=" + attrs + ", media=" + media + ", cluster=" + cluster + ", id="
				+ id + ", idType=" + idType + ", idVal=" + idVal + ", label="
				+ label + ", name=" + name + ", nbrLinks=" + nbrLinks
				+ ", origin=" + origin + ", type=" + type + ", visible="
				+ visible + "]";
	}
}