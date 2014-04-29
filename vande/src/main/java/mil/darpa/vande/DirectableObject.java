package mil.darpa.vande;

import java.util.List;

/**
 * Implemented by entitybeans that can be used to generate directed graphs.
 * 
 * @author PWG for DARPA
 * 
 */
public interface DirectableObject {

	public String getSrc();

	public String getDest();

	public Number getValue();

	public int getWeight();

	public String getId(); // for drill down

	public List<Object> getEdgeAttributes(); // for mouse over etc

	public List<Object> getSrcAttributes(); // for mouse over etc

	public List<Object> getDestAttributes(); // for mouse over etc

}
