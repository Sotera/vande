package mil.darpa.vande.legacy;




/**
 * Defines the methods needed for an object to be converted into a node
 * or paired with another one to form a link
 * @author PWG for DARPA
 *
 */
public interface Linkable {
	
	public String getId();
	public String getSrc();
	public String getLabel();
//	public int getIdType();
	public String getType(); // TODO: perhaps use an IdType
	public Number getValue();
//	public DateTime getTime(); // Not applicable to every instance
//	public List<IdProperty> getAttributes();
//	public void addAttribute(IdProperty p);

}
