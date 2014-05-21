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

	public String getIdName() {
		return idName;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdName(final String idName) {
		this.idName = idName;
	}

	public void setIdValue(final String idValue) {
		this.idValue = idValue;
	}
}
