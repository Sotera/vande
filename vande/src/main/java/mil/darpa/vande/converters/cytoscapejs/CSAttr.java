package mil.darpa.vande.converters.cytoscapejs;

/**
 * Consists of a key value pair We add a list of CSAttrs to the data elements
 * when serving a Cytoscape graph. Note however that this is not part of
 * Cytoscape.js
 * 
 * @author PWG
 * 
 */
public class CSAttr {
	private String key;
	private String val;

	public CSAttr() {

	}
	
	public CSAttr(final String key, final String val) {
		this.key = key;
		this.val = val;
	}

	public final String getKey() {
		return key;
	}
	
	public final String getVal() {
		return val;
	}
	
	public void setKey(final String key) {
		this.key = key;
	}
	
	public void setVal(final String val) {
		this.val = val;
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
		final CSAttr other = (CSAttr) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (val == null) {
			if (other.val != null) {
				return false;
			}
		} else if (!val.equals(other.val)) {
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
		result = (prime * result) + ((key == null) ? 0 : key.hashCode());
		result = (prime * result) + ((val == null) ? 0 : val.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CSAttr [key=" + key + ", val=" + val + "]";
	}
}
