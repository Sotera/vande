package mil.darpa.vande.interactions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mil.darpa.vande.generic.V_Actor;
import mil.darpa.vande.generic.V_IdProperty;

/**
 * An interaction represents an event involving two parties that can be displayed
 * in an interaction graph.
 * 
 * @author pgofton
 *
 */
public class Interaction {
	
	private V_Actor source;
	private V_Actor target;
	private long dt; // date time
	private Double value = 0D;
	private List<V_IdProperty> properties = null;
	public int day=-1;
	public int month=-1;
	public int year=-1;
	
	public Interaction(V_Actor source, V_Actor target, long dt, Double value) {
		this.source = source;
		this.target = target;
		this.setDt(dt); // sets day month year also
		this.value = value;
	}

	public Interaction(String source, String target, long dt, Double value) {
		this.source = new V_Actor(source);
		this.target = new V_Actor(target);
		this.setDt(dt); // sets day month year also
		this.value = value;
	}
	
	public void setDt(long d)
	{
		this.dt=d;
		if (d != 0) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date(d));
			this.year = c.get(Calendar.YEAR);
			this.month = c.get(Calendar.MONTH); // zero based
			this.day = c.get(Calendar.DAY_OF_MONTH); // 1 based
		}
	}

	public void addProperty(V_IdProperty prop)
	{
		if (properties==null)
			properties=new ArrayList<V_IdProperty>();
		
		properties.add(prop);
	}

	public V_Actor getSource() {
		return source;
	}

	public void setSource(V_Actor source) {
		this.source = source;
	}

	public V_Actor getTarget() {
		return target;
	}

	public void setTarget(V_Actor target) {
		this.target = target;
	}

	public long getDt() {
		return dt;
	}


	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<V_IdProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<V_IdProperty> properties) {
		this.properties = properties;
	}

	public String getSourceId() {
		return source.getId();
	}

	public String getTargetId() {
		return target.getId();
	}
}