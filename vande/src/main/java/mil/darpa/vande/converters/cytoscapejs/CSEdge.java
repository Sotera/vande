package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericEdge;

public class CSEdge {
	private String bypass = null, classes = null;
	private String group;

	private CSEdgeData data;

	private CSPosition position;

	private boolean removed = false, selected = false, selectable = true,
			locked = false, grabbed = false, grabbable = true;

	public CSEdge() {

	}

	public CSEdge(final V_GenericEdge e) {
		data = new CSEdgeData(e);
	}

	public String getBypass() {
		return bypass;
	}

	public String getClasses() {
		return classes;
	}

	public final CSEdgeData getData() {
		return data;
	}

	public String getGroup() {
		return group;
	}

	public CSPosition getPosition() {
		return position;
	}

	public boolean isGrabbable() {
		return grabbable;
	}

	public boolean isGrabbed() {
		return grabbed;
	}

	public boolean isLocked() {
		return locked;
	}

	public boolean isRemoved() {
		return removed;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setBypass(final String bypass) {
		this.bypass = bypass;
	}

	public void setClasses(final String classes) {
		this.classes = classes;
	}

	public final void setData(final CSEdgeData data) {
		this.data = data;
	}

	public void setGrabbable(final boolean grabbable) {
		this.grabbable = grabbable;
	}

	public void setGrabbed(final boolean grabbed) {
		this.grabbed = grabbed;
	}

	public void setGroup(final String group) {
		this.group = group;
	}

	public void setLocked(final boolean locked) {
		this.locked = locked;
	}

	public void setPosition(final CSPosition position) {
		this.position = position;
	}

	public void setRemoved(final boolean removed) {
		this.removed = removed;
	}

	public void setSelectable(final boolean selectable) {
		this.selectable = selectable;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "CSEdge [data=" + data + "]";
	}

}
