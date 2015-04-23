package mil.darpa.vande.generic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * XXX: There is no real reason for this class-- a proper JSON serialization
 * framework can take a map of objects and make them into a list of kv pairs.
 * 
 * @author PWG
 * 
 */
/*
 * Each Node or Attribute in graphml can contain zero to many Data elements of
 * form <data key=foo>value</data>
 */
@XmlAccessorType(XmlAccessType.NONE)
public class V_GraphObjectData implements Comparable<V_GraphObjectData> {

	@XmlAttribute
	String key;
	@XmlValue
	String keyVal;

	public V_GraphObjectData() {

	}

	public V_GraphObjectData(final String key, final String keyVal) {
		this.key = key;
		this.keyVal = keyVal;
	}

	@Override
	public final int compareTo(final V_GraphObjectData o) {
		final int keyCompare = key.compareTo(o.key);
		if (keyCompare == 0) {
			return keyVal.compareTo(o.keyVal);
		} else {
			return keyCompare;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		final V_GraphObjectData other = (V_GraphObjectData) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (keyVal == null) {
			if (other.keyVal != null) {
				return false;
			}
		} else if (!keyVal.equals(other.keyVal)) {
			return false;
		}
		return true;
	}

	public final String getKey() {
		return key;
	}

	public final String getKeyVal() {
		return keyVal;
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
		result = (prime * result) + ((key == null) ? 0 : key.hashCode());
		result = (prime * result) + ((keyVal == null) ? 0 : keyVal.hashCode());
		return result;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public void setKeyVal(final String keyVal) {
		this.keyVal = keyVal;
	}

	@Override
	public String toString() {
		return key + ":" + keyVal;
	}

}
