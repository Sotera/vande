package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericEdge;

public class CSEdge {
	/**
	 * 
	 */
	/**
	 * 
	 */
	private String bypass = null, classes = null;
	/**
	 * 
	 */
	private String group;

	/**
	 * 
	 */
	private CSEdgeData data;

	/**
	 * 
	 */
	private CSPosition position;

	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private boolean removed = false, selected = false, selectable = true,
			locked = false, grabbed = false, grabbable = true;

	/**
	 * 
	 */
	public CSEdge() {

	}

	/**
	 * @param e
	 */
	public CSEdge(final V_GenericEdge e) {
		data = new CSEdgeData(e);
	}

	/**
	 * @return
	 */
	public String getBypass() {
		return bypass;
	}

	/**
	 * @return
	 */
	public String getClasses() {
		return classes;
	}

	/**
	 * @return
	 */
	public final CSEdgeData getData() {
		return data;
	}

	/**
	 * @return
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @return
	 */
	public CSPosition getPosition() {
		return position;
	}

	/**
	 * @return
	 */
	public boolean isGrabbable() {
		return grabbable;
	}

	/**
	 * @return
	 */
	public boolean isGrabbed() {
		return grabbed;
	}

	/**
	 * @return
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @return
	 */
	public boolean isRemoved() {
		return removed;
	}

	/**
	 * @return
	 */
	public boolean isSelectable() {
		return selectable;
	}

	/**
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param bypass
	 */
	public void setBypass(final String bypass) {
		this.bypass = bypass;
	}

	/**
	 * @param classes
	 */
	public void setClasses(final String classes) {
		this.classes = classes;
	}

	/**
	 * @param data
	 */
	public final void setData(final CSEdgeData data) {
		this.data = data;
	}

	/**
	 * @param grabbable
	 */
	public void setGrabbable(final boolean grabbable) {
		this.grabbable = grabbable;
	}

	/**
	 * @param grabbed
	 */
	public void setGrabbed(final boolean grabbed) {
		this.grabbed = grabbed;
	}

	/**
	 * @param group
	 */
	public void setGroup(final String group) {
		this.group = group;
	}

	/**
	 * @param locked
	 */
	public void setLocked(final boolean locked) {
		this.locked = locked;
	}

	/**
	 * @param position
	 */
	public void setPosition(final CSPosition position) {
		this.position = position;
	}

	/**
	 * @param removed
	 */
	public void setRemoved(final boolean removed) {
		this.removed = removed;
	}

	/**
	 * @param selectable
	 */
	public void setSelectable(final boolean selectable) {
		this.selectable = selectable;
	}

	/**
	 * @param selected
	 */
	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

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
