package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericEdge;

public class CSEdge {
	
	private String bypass = null;
	private String classes = null;
	private CSEdgeData data;
	private boolean grabbable = true;
	private boolean	grabbed = false;
	private String group;
	private boolean	locked = false; 
	private CSPosition position;
	private boolean removed = false;
	private boolean	selectable = true;
	private boolean	selected = false;

	public CSEdge() {

	}

	public CSEdge(final V_GenericEdge e) {
		data = new CSEdgeData(e);
	}

	/* * * * * * * * * * * * * * * * * */
	/*             GETTERS             */
	/* * * * * * * * * * * * * * * * * */
	
	public String getBypass() {
		return bypass;
	}

	public String getClasses() {
		return classes;
	}

	public final CSEdgeData getData() {
		return data;
	}

	public boolean isGrabbable() {
		return grabbable;
	}

	public boolean isGrabbed() {
		return grabbed;
	}
	
	public String getGroup() {
		return group;
	}

	public boolean isLocked() {
		return locked;
	}

	public CSPosition getPosition() {
		return position;
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
	
	/* * * * * * * * * * * * * * * * * */
	/*             SETTERS             */
	/* * * * * * * * * * * * * * * * * */	

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

	/* * * * * * * * * * * * * * * * * */
	/*             METHODS             */
	/* * * * * * * * * * * * * * * * * */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CSEdge [data=" + data + "]";
	}

}
