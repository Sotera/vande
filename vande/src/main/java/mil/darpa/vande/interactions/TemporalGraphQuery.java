package mil.darpa.vande.interactions;

import mil.darpa.vande.generic.V_GraphQuery;

/**
 * Extends GraphQuery to allow you to specify graphs that return multiple edges
 * for the same pair of nodes, each such edge representing a different time
 * period. <BR>
 * These fields are not exclusive. You can request both daily and monthly
 * aggregations, for example. In this case, in the monthly links the value for
 * 'day' will be -1 and so on.
 * 
 * @author PWG for DARPA
 * 
 */
@Deprecated
public class TemporalGraphQuery extends V_GraphQuery {

	private boolean byDay = false;
	private boolean byHour = false;
	private boolean byMinute = false;
	private boolean byMonth = false;
	private boolean byYear = false;
	private int minEdgeValue = 0;
	private int minLinksPerPeriod = 1;
	private int minPairValue = 0;

	public TemporalGraphQuery() {
		// TODO Auto-generated constructor stub
	}

	public TemporalGraphQuery(final V_GraphQuery q) {
		super(q);
	}

	/**
	 * Used for filtering in edgelists
	 * 
	 * @return
	 */
	public double getMinEdgeValue() {
		return minEdgeValue;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @return
	 */
	public int getMinLinksPerPeriod() {
		return minLinksPerPeriod;
	}

	/**
	 * Used for filtering in edgelists
	 * 
	 * @return
	 */
	public final int getMinPairValue() {
		return minPairValue;
	}

	/**
	 * Used when adding interactions to edge lists
	 * 
	 * @return
	 */
	public final boolean isByDay() {
		return byDay;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @return
	 */
	public final boolean isByHour() {
		return byHour;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @return
	 */
	public final boolean isByMinute() {
		return byMinute;
	}

	/**
	 * Used when adding interactions to edge lists
	 * 
	 * @return
	 */
	public final boolean isByMonth() {
		return byMonth;
	}

	/**
	 * Used when adding interactions to edge lists
	 * 
	 * @return
	 */
	public final boolean isByYear() {
		return byYear;
	}

	public void setByDay(final boolean byDay) {
		this.byDay = byDay;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @param byHour
	 */
	public final void setByHour(final boolean byHour) {
		this.byHour = byHour;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @param byMinute
	 */
	public final void setByMinute(final boolean byMinute) {
		this.byMinute = byMinute;
	}

	public final void setByMonth(final boolean byMonth) {
		this.byMonth = byMonth;
	}

	public void setByYear(final boolean byYear) {
		this.byYear = byYear;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @param minEdgeValue
	 */
	public final void setMinEdgeValue(final int minEdgeValue) {
		this.minEdgeValue = minEdgeValue;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @param minLinksPerPeriod
	 *            int. Default 1. Do not show an edge for a period if the number
	 *            of links for that period between the two nodes is less than
	 *            this number.
	 */
	public final void setMinLinksPerPeriod(final int minLinksPerPeriod) {
		this.minLinksPerPeriod = minLinksPerPeriod;
	}

	/**
	 * FIXME: Seems unused
	 * 
	 * @param minPairValue
	 */
	public final void setMinPairValue(final int minPairValue) {
		this.minPairValue = minPairValue;
	}

	@Override
	public String toString() {
		return super.toString() + "TemporalGraphQuery [byMonth=" + byMonth + ", byDay=" + byDay + ", byYear=" + byYear
				+ ", byHour=" + byHour + ", byMinute=" + byMinute + ", minLinksPerPeriod=" + minLinksPerPeriod + "]";
	}

}
