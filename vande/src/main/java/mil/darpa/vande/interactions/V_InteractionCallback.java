package mil.darpa.vande.interactions;

/**
 * I think this was written because PWG didn't want to use the Graphene callback
 * class. It's essentially the same.--djue
 * 
 * @author PWG
 * 
 */
public interface V_InteractionCallback {

	/**
	 * We need to justify the existance of this callback. It looks like this is
	 * where the actual edges get created between nodes for the graph builder.
	 * 
	 * @param i
	 */
	void callBack(Interaction i);

}
