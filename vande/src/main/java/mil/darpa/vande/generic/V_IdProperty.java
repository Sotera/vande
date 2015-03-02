package mil.darpa.vande.generic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class V_IdProperty implements Comparable<V_IdProperty> {
	
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

	@Override
	public int compareTo(V_IdProperty o) {
		// Compare the name first, then the value if needed.
		int cmpName = idName.compareTo(o.idName);
		return (cmpName != 0 ? cmpName : idValue.compareTo(o.idValue));
	}
}
