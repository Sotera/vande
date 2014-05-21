package mil.darpa.vande.interactions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mil.darpa.vande.generic.V_Actor;
import mil.darpa.vande.generic.V_IdProperty;

/**
 * 
 * This is essentially a list of two Actors, which is a precursor to a pair of nodes and an edge.  Similar to NodeList
 * 
 * An interaction represents an event involving two parties that can be
 * displayed in an interaction graph.
 * 
 * @author pgofton
 * 
 */
public class Interaction {

	public int day = -1;
	private long dt; // date time
	public int month = -1;
	private List<V_IdProperty> properties = null;
	private V_Actor source;
	private V_Actor target;
	private Double value = 0D;
	public int year = -1;

	public Interaction(final String source, final String target, final long dt, final Double value) {
		this.source = new V_Actor(source);
		this.target = new V_Actor(target);
		this.setDt(dt); // sets day month year also
		this.value = value;
	}

	public Interaction(final V_Actor source, final V_Actor target, final long dt, final Double value) {
		this.source = source;
		this.target = target;
		this.setDt(dt); // sets day month year also
		this.value = value;
	}

	public void addProperty(final V_IdProperty prop) {
		if (properties == null) {
			properties = new ArrayList<V_IdProperty>();
		}

		properties.add(prop);
	}

	public long getDt() {
		return dt;
	}

	public List<V_IdProperty> getProperties() {
		return properties;
	}

	public V_Actor getSource() {
		return source;
	}

	public String getSourceId() {
		return source.getId();
	}

	public V_Actor getTarget() {
		return target;
	}

	public String getTargetId() {
		return target.getId();
	}

	public Double getValue() {
		return value;
	}

	public void setDt(final long d) {
		this.dt = d;
		if (d != 0) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date(d));
			this.year = c.get(Calendar.YEAR);
			this.month = c.get(Calendar.MONTH); // zero based
			this.day = c.get(Calendar.DAY_OF_MONTH); // 1 based
		}
	}

	public void setProperties(final List<V_IdProperty> properties) {
		this.properties = properties;
	}

	public void setSource(final V_Actor source) {
		this.source = source;
	}

	public void setTarget(final V_Actor target) {
		this.target = target;
	}

	public void setValue(final Double value) {
		this.value = value;
	}
}