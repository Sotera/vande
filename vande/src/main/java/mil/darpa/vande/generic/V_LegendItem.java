package mil.darpa.vande.generic;

public class V_LegendItem {

	private V_GraphObjectData color;
	private V_GraphObjectData text;
	
	public V_LegendItem() {
		this.color = new V_GraphObjectData("color", "");
		this.text = new V_GraphObjectData("text", "");
	}
	
	public V_LegendItem(String color, String text) {
		this.color = new V_GraphObjectData("color", color);
		this.text = new V_GraphObjectData("text", text);
	}
	
	public String getColor() {
		return this.color.getKeyVal();
	}
	
	public void setColor(String color) {
		// TODO make sure color is valid hex
		this.color.setKeyVal(color);
	}
	
	public String getText() {
		return this.text.getKeyVal();
	}
	
	public void setText(String text) {
		this.text.setKeyVal(text);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		
		V_LegendItem that = (V_LegendItem) o;
		
		if (this.color == null) {
			if (that.color != null) {
				return false;
			}
		} else if (!this.color.equals(that.color)) {
			return false;
		}
		
		if (this.text == null) {
			if (that.text != null) {
				return false;
			}
		} else if (!this.text.equals(that.text)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.color == null) ? 0 : color.hashCode());
		result = prime * result + ((this.text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "{color: " + this.color.getKeyVal() + ",text: " + this.text.getKeyVal() + "}";
	}
}
