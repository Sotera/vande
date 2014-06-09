package mil.darpa.vande.generic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class V_IdProperty {
	private String idName;
	private String idValue;

	public V_IdProperty() {

	}

	public V_IdProperty(final String name, final String idValue) {
		this.idName = name;
		this.idValue = idValue;
	}

	public final String getIdName() {
		return idName;
	}

	public final String getIdValue() {
		return idValue;
	}

	public final void setIdName(final String idName) {
		this.idName = idName;
	}

	public final void setIdValue(final String idValue) {
		this.idValue = idValue;
	}

	@Override
	public String toString() {
		return "V_IdProperty ["
				+ (idName != null ? "idName=" + idName + ", " : "")
				+ (idValue != null ? "idValue=" + idValue : "") + "]";
	}
}
