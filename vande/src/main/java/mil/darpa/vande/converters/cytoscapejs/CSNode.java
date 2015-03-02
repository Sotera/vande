package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericNode;

public class CSNode {

	private String bypass = null;
	private String classes = null;
	private CSNodeData data;
	private boolean	grabbable = true;
	private boolean	grabbed = false;
	private String group;
	private boolean	locked = false;
	private CSPosition position;
	private boolean removed = false;
	private boolean	selectable = true;
	private boolean	selected = false;

	public CSNode() {

	}

	public CSNode(final V_GenericNode node) {
		data = new CSNodeData(node);
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

	public CSNodeData getData() {
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

	public void setData(final CSNodeData data) {
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
		final CSNode other = (CSNode) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
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
		result = (prime * result) + ((data == null) ? 0 : data.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "CSNode [data=" + data + "]";
	}
}
