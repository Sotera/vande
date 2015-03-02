package mil.darpa.vande.generic;

public class V_LegendItem {

	private final V_GraphObjectData color;
	private final V_GraphObjectData text;

	public V_LegendItem() {
		color = new V_GraphObjectData("color", "");
		text = new V_GraphObjectData("text", "");
	}

	public V_LegendItem(final String color, final String text) {
		this.color = new V_GraphObjectData("color", color);
		this.text = new V_GraphObjectData("text", text);
	}

	public String getColor() {
		return color.getKeyVal();
	}

	public String getText() {
		return text.getKeyVal();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public void setColor(final String color) {
		// TODO make sure color is valid hex
		this.color.setKeyVal(color);
	}

	public void setText(final String text) {
		this.text.setKeyVal(text);
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
		final V_LegendItem other = (V_LegendItem) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
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
		final int prime = 73;
		int result = 1;
		result = (prime * result) + ((color == null) ? 0 : color.hashCode());
		result = (prime * result) + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "{color: " + color.getKeyVal() + ",text: " + text.getKeyVal() + "}";
	}
}
