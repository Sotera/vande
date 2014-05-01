package mil.darpa.vande.legacy.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * it now looks like the Vande code wants us to use Object instead of a hard
 * coded class like this. It usually showed up in classes that implemented the
 * old DirectableObject, and there would be three lists of these objects:
 * 
 * private List<Object> edgeAttributeList = new ArrayList<Object>(); 
 * 
 * private List<Object> srcAttributeList = new ArrayList<Object>(); 
 * 
 * private List<Object> destAttributeList = new ArrayList<Object>();
 * 
 * TODO: Determine whether this class has any value-- if not, delete it. --djue
 * 
 * @author pwg
 * 
 */
@Deprecated
@XmlAccessorType(XmlAccessType.FIELD)
public class IdProperty {
	public String idName;
	public String idValue;

	public IdProperty() {

	}

	public IdProperty(final String name, final String idValue) {
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
