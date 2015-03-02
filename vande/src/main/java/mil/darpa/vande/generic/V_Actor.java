package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * An Actor represents a participant in an Interaction, such as Sender or
 * Receiver. It forms the basis for a node in an interaction graph
 * 
 * @author PWG for DARPA
 * 
 */
public class V_Actor {

	private String id;
	private String idType;
	private String idVal;
	private String label;
	private List<V_IdProperty> properties = null;
	private boolean edited = false;

	public V_Actor() {
		// TODO Auto-generated constructor stub
	}

	public V_Actor(final String id) {
		this.id = id;
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
	
	public final boolean isEdited() {
		return edited;
	}

	@Deprecated
	public final List<V_IdProperty> getProperties() {
		return properties;
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

	public void setProperties(final List<V_IdProperty> properties) {
		this.properties = properties;
	}
	
	public void setEdited(final boolean isEdited) {
		this.edited = isEdited;
	}
	
	/**
	 * Use addData() instead
	 * @param name
	 * @param value
	 */
	@Deprecated
	public final void addProperty(final String name, final String value) {
		addProperty(new V_IdProperty(name, value));
	}

	/**
	 * Add a property to the list for the actor
	 * 
	 * @param prop
	 *            IdProperty
	 */
	@Deprecated
	public final void addProperty(final V_IdProperty prop) {
		if (properties == null) {
			properties = new ArrayList<V_IdProperty>();
		}
		properties.add(prop);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		V_Actor other = (V_Actor) obj;
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
		if (properties == null) {
			if (other.properties != null) {
				return false;
			}
		} else if (!properties.equals(other.properties)) {
			return false;
		}
		return true;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((idVal == null) ? 0 : idVal.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "V_Actor [" + (id != null ? "id=" + id + ", " : "")
				+ (idType != null ? "idType=" + idType + ", " : "")
				+ (idVal != null ? "idVal=" + idVal + ", " : "")
				+ (label != null ? "label=" + label + ", " : "")
				+ (properties != null ? "properties=" + properties : "") + "]";
	}
}
