package mil.darpa.vande.property;

import java.util.List;

import mil.darpa.vande.DirectableObject;
import mil.darpa.vande.generic.V_GraphQuery;
import mil.darpa.vande.interactions.V_InteractionCallback;

/**
 * 
 * This is usually done with some DAO implementation class. This needs to be at
 * a service layer above DAOs, for now. --djue
 * 
 * TODO:Merge this with what is currently called InteractionFinder --djue
 * 
 * 
 * @param <T>
 * @param <Q>
 */

public interface PropertyFinder {
	
	// List<T> getDestFor(String nbr, Q originalQuery) throws Exception;

	// List<T> getSrcFor(String nbr, Q originalQuery) throws Exception;

	// setting in q where applicable
	// List<T> pairQuery(Q q) throws Exception;

	// Taken from interactionFinder.
	long countEdges(V_GraphQuery q, String id);

	// Trying to be more like the modern code, but without the side
	// effects--djue
	// List<String> query(Q q) throws Exception;
	/**
	 * Search for transactions matching the ids contained in idList and add
	 * nodes and edges to the nodelist and edgelist passed in
	 * 
	 * FIXME: This uses side effects to return a modified idList, fix this crap.
	 * --djue
	 * 
	 * @param idList
	 *            List of identifier strings
	 * @param originalQuery
	 *            GraphQuery that triggered the graph
	 * @param toCall
	 *            Callable: class to call back for each row with an Interaction
	 */
	public void query(List<String> idList, V_GraphQuery q,
			V_PropertyCallback toCall);
}
