package mil.darpa.vande;

import java.util.List;

/**
 * Implemented by entitybeans that can be used to generate directed graphs.
 * 
 * @author PWG for DARPA
 * 
 */
public interface DirectableObject {

	public String getDest();

	public List<Object> getDestAttributes(); // for mouse over etc

	public List<Object> getEdgeAttributes(); // for mouse over etc

	public String getId(); // for drill down

	public String getSrc();

	public List<Object> getSrcAttributes(); // for mouse over etc

	/**
	 * Note that in older versions of this class, we returned a String instead.
	 * @return
	 */
	public Number getValue();

	public int getWeight();

}
