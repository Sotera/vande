package mil.darpa.vande.property;

import mil.darpa.vande.generic.V_GenericGraph;

/**
 * This is a copy of InteractionCallback, with the object changed to some
 * container for properties, instead of a container for an Interaction.
 * 
 * TODO: See if we can combine the two by a flexible object.
 * 
 * @author djue
 * 
 */
public interface V_PropertyCallback {
	/**
	 * TODO: we need to justify the existence of this callback. It looks like
	 * this is where the edges are created between nodes, but is that really
	 * necessary to be in core core? Sounds like it should be in the customer
	 * code.
	 * 
	 * Another thing is that we either use a generic datastructure like the list
	 * below, or we have something that is kind of custom, or we have a more
	 * canonical idea to represent, like an event or interaction with two
	 * parties.
	 * 
	 * For entity creation, we might not be limited to the amount of properties
	 * that appear on one row of the data. So you either have to put them in a
	 * list or a custom object for the datasource (not a great idea).
	 * 
	 * The list is a problem, because you then have to reverse engineer the list
	 * to see which ones you want to create edges between. The inefficiency here
	 * is that we already had the properties/nodes identified before we called
	 * this callback, and the style in which we want to create a property graph
	 * is largely defined by the custom data source. So this last reason calls
	 * into question the necessity of this function call.
	 * 
	 * 
	 * 
	 * @param i
	 */
	void callBack(V_GenericGraph subgraph);

}
