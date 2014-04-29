package mil.darpa.vande.generic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class V_IdProperty {
	public String idName;
	public String idValue;

	public V_IdProperty() {

	}

	public V_IdProperty(String name, String idValue) {
		this.idName = name;
		this.idValue = idValue;
	}

	public String getIdName() {
		return idName;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
}
