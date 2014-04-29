package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * An Actor represents a participant in an Interaction, such as Sender or
 * Receiver. It forms the basis for a node in an interaction graph
 * @author PWG for DARPA
 *
 */
public class V_Actor {
	private String id;  // must be enough to identifiy the entity
						// will also be used as the id for the node
	private String label;
	private String idType;
	private String idVal;
	private List<V_IdProperty> properties = null;

	public V_Actor (String id)
	{
		this.id = id;
	}
	/**
	 * Add a property to the list for the actor
	 * @param prop IdProperty
	 */
	public void addProperty(V_IdProperty prop)
	{
		if (properties==null)
			properties=new ArrayList<V_IdProperty>();
		properties.add(prop);
	}
	
	public void addProperty(String p, String v)
	{
		addProperty(new V_IdProperty(p, v));
	}
	public String getId()
	{
		return id;
	}
	public List<V_IdProperty> getProperties()
	{
		return properties;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public void setId(String id) {
		this.id = id;
	}
	public void setProperties(List<V_IdProperty> properties) {
		this.properties = properties;
	}
}
