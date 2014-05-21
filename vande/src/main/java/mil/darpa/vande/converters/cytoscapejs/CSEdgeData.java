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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public List<CSAttr> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<CSAttr> attrs) {
		this.attrs = attrs;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String[] getDirection() {
		return direction;
	}

	public void setDirection(String[] direction) {
		this.direction = direction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdVal() {
		return idVal;
	}

	public void setIdVal(String idVal) {
		this.idVal = idVal;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getLinewidth() {
		return linewidth;
	}

	public void setLinewidth(int linewidth) {
		this.linewidth = linewidth;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "CSEdgeData [amount=" + amount + ", attrs=" + attrs + ", count="
				+ count + ", day=" + day + ", direction="
				+ Arrays.toString(direction) + ", id=" + id + ", idType="
				+ idType + ", idVal=" + idVal + ", label=" + label
				+ ", linewidth=" + linewidth + ", month=" + month + ", source="
				+ source + ", target=" + target + ", type=" + type
				+ ", visible=" + visible + ", weight=" + weight + ", year="
				+ year + "]";
	}

	public String type = "";
	public boolean visible = true;
	public String weight = "0";
	public int year = -1;

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

}
