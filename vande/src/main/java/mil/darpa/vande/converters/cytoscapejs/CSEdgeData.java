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
	private String color;
	private String count;
	private int day = -1;
	private String[] direction = null;
	private boolean edited = false;
	private boolean expanded = false;
	private boolean generated = false;
	private String id;
	private String idType;
	private String idVal;
	private String label;
	private int linewidth = 1;
	private String lineStyle = "solid";
	private int month = -1;
	private List<String> old_targets;
	private List<String> old_sources;
	private String source;
	private String target;
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
		edited = e.isEdited();
		expanded = e.isExpanded();
		
		final Set<V_GraphObjectData> s = e.getDataSet();
		for (final V_GraphObjectData d : s) {
			attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
		}
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             GETTERS             */
	/* * * * * * * * * * * * * * * * * */
	
	public final String getAmount() {
		return amount;
	}

	public final List<CSAttr> getAttrs() {
		return attrs;
	}

	public String getColor() {
		return color;
	}

	public final String getCount() {
		return count;
	}

	public final int getDay() {
		return day;
	}

	public final String[] getDirection() {
		return direction;
	}
	
	public final boolean isEdited() {
		return edited;
	}

	public final boolean isExpanded() {
		return expanded;
	}
	
	public boolean isGenerated() {
		return generated;
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

	public String getLineStyle() {
		return lineStyle;
	}

	public final int getLinewidth() {
		return linewidth;
	}

	public final int getMonth() {
		return month;
	}

	public List<String> getOld_sources() {
		return old_sources;
	}

	public List<String> getOld_targets() {
		return old_targets;
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

	public final boolean isVisible() {
		return visible;
	}
	
	public final String getWeight() {
		return weight;
	}

	public final int getYear() {
		return year;
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             SETTERS             */
	/* * * * * * * * * * * * * * * * * */		
	
	public void setAmount(final String amount) {
		this.amount = amount;
	}

	public void setAttrs(final List<CSAttr> attrs) {
		this.attrs = attrs;
	}

	public void setColor(final String color) {
		// TODO: verify string input is color or hex value
		this.color = color;
	}

	public void setCount(final String count) {
		this.count = count;
	}

	public void setDay(final int day) {
		this.day = day;
	}

	public final void setDirection(final String[] direction) {
		this.direction = direction;
	}

	public void setEdited(final boolean isEdited) {
		this.edited = isEdited;
	}
	
	public void setExpanded(final boolean isExpanded) {
		this.expanded = isExpanded;
	}

	public void setGenerated(final boolean generated) {
		this.generated = generated;
	}

	public final void setId(final String id) {
		this.id = id;
	}

	public final void setIdType(final String idType) {
		this.idType = idType;
	}

	public final void setIdVal(final String idVal) {
		this.idVal = idVal;
	}

	public final void setLabel(final String label) {
		this.label = label;
	}

	public void setLineStyle(final String style) {
		switch (style.toLowerCase()) {
		case "solid":
			this.lineStyle = "solid";
			break;
		case "dotted":
			this.lineStyle = "dotted";
			break;
		case "dashed":
			this.lineStyle = "dashed";
			break;
		default:
			// invalid input string; don't change existing lineStyle
			break;
		}
	}

	public final void setLinewidth(final int linewidth) {
		this.linewidth = linewidth;
	}

	public final void setMonth(final int month) {
		this.month = month;
	}

	public void setOld_sources(final List<String> old_sources) {
		this.old_sources = old_sources;
	}

	public void setOld_targets(final List<String> old_targets) {
		this.old_targets = old_targets;
	}

	public final void setSource(final String source) {
		this.source = source;
	}

	public void setTarget(final String target) {
		this.target = target;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public final void setVisible(final boolean visible) {
		this.visible = visible;
	}

	public final void setWeight(final String weight) {
		this.weight = weight;
	}

	public final void setYear(final int year) {
		this.year = year;
	}
	
	/* * * * * * * * * * * * * * * * * */
	/*             METHODS             */
	/* * * * * * * * * * * * * * * * * */

	@Override
	public String toString() {
		return "CSEdgeData ["
				+ "amount=" + amount + ", " + "attrs=" + attrs + ", " 
				+ "count=" + count + ", " + "day=" + day + ", " 
				+ "direction=" + Arrays.toString(direction) + ", " + "id=" + id + ", " 
				+ "idType=" + idType + ", " + "idVal=" + idVal + ", " 
				+ "color=" + color + ", " + "lineStyle=" + lineStyle + ", " 
				+ "isEdited=" + edited + ", " + "label=" + label + ", " 
				+ "linewidth=" + linewidth + ", " + "month=" + month + ", " 
				+ "source=" + source + ", " + "target=" + target + ", " 
				+ "type=" + type + ", " + "visible=" + visible + ", "
				+ "weight=" + weight + ", " + "year=" + year 
				+ "]";
	}

}
