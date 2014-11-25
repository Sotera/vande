package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GraphObjectData;

public class CSEdgeData {

	private String amount;
	private List<CSAttr> attrs = new ArrayList<CSAttr>();
	private String count;
	private int day = -1;
	private String[] direction = null;
	private String id;
	private String idType;
	private String idVal;
	private String label;
	private int linewidth = 1;
	private int month = -1;
	private String source;
	private String target;
	private String color;
	private String lineStyle = "solid";
	private String type = "";

	private boolean visible = true;

	private String weight = "0";

	private int year = -1;

	public CSEdgeData() {

	}

	public CSEdgeData(final V_GenericEdge e) {
		if (e.isDirected()) {
			direction = new String[2];
			direction[0] = e.getSourceId();
			direction[1] = e.getTargetId();
			type = "arrow";
		}

		source = e.getSourceId();
		target = e.getTargetId();
		label = e.getLabel();
		idType = e.getIdType();
		idVal = e.getIdVal();

		amount = Double.toString(e.getValue());
		color = e.getColor();
		
		 // use setter function to ensure given lineStyle is valid for Cytoscape expectations
		setLineStyle(e.getLineStyle());
		
		weight = Integer.toString(e.getWeight());

		day = e.getDay();
		month = e.getMonth();
		year = e.getYear();
		count = Integer.toString(e.getCount());

		Set<V_GraphObjectData> s = e.getDataSet();
		for (V_GraphObjectData d : s) {
			this.attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
		}
	}

	public final String getAmount() {
		return amount;
	}

	public final List<CSAttr> getAttrs() {
		return attrs;
	}

	public final String getCount() {
		return count;
	}

	public final int getDay() {
		return day;
	}
	
	public String getColor() {
		return color;
	}

	public String getLineStyle() {
		return lineStyle;
	}
	
	public final String[] getDirection() {
		return direction;
	}

	public final String getId() {
		return id;
	}

	public final String getIdType() {
		return idType;
	}

	public final String getIdVal() {
		return idVal;
	}

	public final String getLabel() {
		return label;
	}

	public final int getLinewidth() {
		return linewidth;
	}

	public final int getMonth() {
		return month;
	}

	public final String getSource() {
		return source;
	}

	public final String getTarget() {
		return target;
	}

	public final String getType() {
		return type;
	}

	public final String getWeight() {
		return weight;
	}

	public final int getYear() {
		return year;
	}

	public final boolean isVisible() {
		return visible;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setAttrs(List<CSAttr> attrs) {
		this.attrs = attrs;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	public void setColor(String color) {
		// TODO: verify string input is color or hex value
		this.color = color;
	}
	
	public void setLineStyle(String style) {
		switch (style.toLowerCase()) {
		case "solid" :
			this.lineStyle = "solid";
			break;
		case "dotted" :
			this.lineStyle = "dotted";
			break;
		case "dashed" :
			this.lineStyle = "dashed";
			break;
		default :
			// invalid input string; don't change existing lineStyle
			break;
		}
	}

	public void setDay(int day) {
		this.day = day;
	}

	public final void setDirection(String[] direction) {
		this.direction = direction;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final void setIdType(String idType) {
		this.idType = idType;
	}

	public final void setIdVal(String idVal) {
		this.idVal = idVal;
	}

	public final void setLabel(String label) {
		this.label = label;
	}

	public final void setLinewidth(int linewidth) {
		this.linewidth = linewidth;
	}

	public final void setMonth(int month) {
		this.month = month;
	}

	public final void setSource(String source) {
		this.source = source;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setType(String type) {
		this.type = type;
	}

	public final void setVisible(boolean visible) {
		this.visible = visible;
	}

	public final void setWeight(String weight) {
		this.weight = weight;
	}

	public final void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "CSEdgeData [amount=" + amount + ", attrs=" + attrs + ", count="
				+ count + ", day=" + day + ", direction="
				+ Arrays.toString(direction) + ", id=" + id + ", idType="
				+ idType + ", idVal=" + idVal + ", color=" + color + ", lineStyle=" + lineStyle +", label=" + label
				+ ", linewidth=" + linewidth + ", month=" + month + ", source="
				+ source + ", target=" + target + ", type=" + type
				+ ", visible=" + visible + ", weight=" + weight + ", year="
				+ year + "]";
	}

}
