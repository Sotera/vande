package mil.darpa.vande;

import java.util.List;

import mil.darpa.vande.generic.V_GraphQuery;
import mil.darpa.vande.interactions.InteractionCallback;

/**
 * 
 * @author PWG for DARPA
 * Interface to be implemented by a domain-specific class to handle 
 * scanning for transactions
 *  
 */
public interface InteractionFinder {
	
	/**
	 * Search for transactions matching the ids contained in idList
	 * and add nodes and edges to the nodelist and edgelist passed in
	 * @param idList List of identifier strings
	 * @param originalQuery GraphQuery that triggered the graph
	 * @param toCall Callable: class to call back for each row with an Interaction  
	 */
	public void query(List<String> idList, V_GraphQuery originalQuery, InteractionCallback toCall);

	long countEdges(V_GraphQuery originalQuery, String id);

}
