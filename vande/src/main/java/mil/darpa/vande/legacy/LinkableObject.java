package mil.darpa.vande.legacy;

/**
 * General purpose implementation of Linkable for where we don't have an object
 * that we can use to implement it.
 */
public class LinkableObject implements Linkable {

	private String id = "";
	private String label = "";
	private String src = ""; // not null because used in .equals
	private String type = "";
	private Number value = null;

	/*
	 * public List<IdProperty> getAttributes() { return attributes; }
	 * 
	 * 
	 * public void setAttributes(List<IdProperty> attributes) { this.attributes
	 * = attributes; }
	 * 
	 * 
	 * public void addAttribute(IdProperty p) { attributes.add(p); }
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Linkable))
			return false;
		Linkable t = (Linkable) o;
		return t.getId().equals(id) && t.getSrc().endsWith(src);

	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	// private List<IdProperty> attributes = new ArrayList<IdProperty>();

	public String getSrc() {
		return src;
	}

	@Override
	public String getType() {
		return type;
	}

	public Number getValue() {
		return value;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(Number value) {
		this.value = value;
	}
}
