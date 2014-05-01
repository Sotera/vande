package mil.darpa.vande.legacy.graphserver;

import mil.darpa.vande.generic.V_GraphQuery;


/**
 * This is a new interface for any implementation that extends
 * GraphBuilderDirected (the base class)
 * 
 * This class seems really useful, so we'll want to decouple the methods from
 * the implementations using this interface.
 * 
 * @author pwg
 * 
 */

@Deprecated
public interface GraphBuilderWithDirection extends GraphBuilder {

	public abstract long getEndDate();

	/**
	 * @return the loader
	 */
	public abstract DirectableObjectLoader getLoader();

	public abstract long getStartDate();

	public abstract void setEndDate(long endDate);

	/**
	 * @param loader
	 *            the loader to set
	 */
	public abstract void setLoader(DirectableObjectLoader loader);

	public abstract void setMinWeight(int weight);

	public abstract void setQuery(V_GraphQuery q);

	public abstract void setStartDate(long startDate);

}