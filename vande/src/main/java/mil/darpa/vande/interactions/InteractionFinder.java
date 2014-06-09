package mil.darpa.vande.interactions;

import java.util.List;

import mil.darpa.vande.generic.V_GraphQuery;

/**
 * 
 * @author PWG for DARPA Interface to be implemented by a domain-specific class
 *         to handle scanning for transactions
 * 
 */
@Deprecated
public interface InteractionFinder {

	long countEdges(V_GraphQuery q, String id);

	/**
	 * Search for transactions matching the ids contained in idList and add
	 * nodes and edges to the nodelist and edgelist passed in
	 * 
	 * FIXME: This uses side effects to return a modified idList, fix this crap.
	 * --djue
	 * 
	 * XXX: This gets passed something called originalQuery, which in existing
	 * vande implementations is a class field populated at construction time.
	 * However in the few implementations we have, the query is also passed as a
	 * parameter to makeGraphResponse, and is not modified from the one called
	 * OriginalQuery. I think the intent is that you would modify the query (by
	 * decreasing the degrees), and still be able to reference the original
	 * query. However it did not seem to be used that way in practice. Therefore
	 * we'll likely remove the field in implementations and just use the one
	 * passed into makeGraphResponse, which we will call q. --djue
	 * 
	 * @param idList
	 *            List of identifier strings
	 * @param originalQuery
	 *            GraphQuery that triggered the graph
	 * @param toCall
	 *            Callable: class to call back for each row with an Interaction.
	 *            Usually something like a graphBuilder implementation
	 */
	void query(List<String> idList, V_GraphQuery q, V_InteractionCallback toCall);

}
