package mil.darpa.vande.legacy;

import java.util.Properties;

/** Represents a single transaction or other event involving two actors
 * - in other words, a non-aggregated edge.<BR>
 * If your class that represents a transaction or event implements this interface
 * you can use the helper classes to assist in the creation of aggregated Edges
 * @author PWG for DARPA
 *
 */
@Deprecated
public interface Edgeable {
	
	public String getSourceId();
	public String getTargetId();
	public double getValue();
	public int getYear();
	public int getMonth();
	public int getDay();
	public Properties getProperties();// the props for the interacton not the actors
}
