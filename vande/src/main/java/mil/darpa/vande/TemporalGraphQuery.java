package mil.darpa.vande;

import mil.darpa.vande.generic.V_GraphQuery;

/**
 * Extends GraphQuery to allow you to specify graphs that return multiple edges for the same pair 
 * of nodes, each such edge representing a different time period. 
 * <BR>These fields are not exclusive. You can request both daily and monthly
 * aggregations, for example. In this case, in the monthly links the value for
 * 'day' will be -1 and so on.  
 * 
 * @author PWG for DARPA
 *
 */
public class TemporalGraphQuery extends V_GraphQuery {
	
	private boolean byMonth=false;
	private boolean byDay=false;
	private boolean byYear=false;
	private boolean byHour=false;	
	private boolean byMinute=false;
	private int minLinksPerPeriod=1;
	private int minEdgeValue = 0;
	private int minPairValue = 0;	
	
	public boolean isByMonth() {
		return byMonth;
	}
	public void setByMonth(boolean byMonth) {
		this.byMonth = byMonth;
	}
	public boolean isByDay() {
		return byDay;
	}
	public void setByDay(boolean byDay) {
		this.byDay = byDay;
	}
	public boolean isByYear() {
		return byYear;
	}
	public void setByYear(boolean byYear) {
		this.byYear = byYear;
	}
	public boolean isByHour() {
		return byHour;
	}
	public void setByHour(boolean byHour) {
		this.byHour = byHour;
	}
	public boolean isByMinute() {
		return byMinute;
	}
	public void setByMinute(boolean byMinute) {
		this.byMinute = byMinute;
	}
	public int getMinLinksPerPeriod() {
		return minLinksPerPeriod;
	}
	/**
	 * 
	 * @param minLinksPerPeriod int. Default 1. Do not show an edge for a period if
	 * the number of links for that period between the two nodes is less than this
	 * number.
	 */
	public void setMinLinksPerPeriod(int minLinksPerPeriod) {
		this.minLinksPerPeriod = minLinksPerPeriod;
	}
	@Override
	public String toString() {
		return super.toString() + "TemporalGraphQuery [byMonth=" + byMonth + ", byDay=" + byDay
				+ ", byYear=" + byYear + ", byHour=" + byHour + ", byMinute="
				+ byMinute + ", minLinksPerPeriod=" + minLinksPerPeriod + "]";
	}
	public double getMinEdgeValue() {
		return minEdgeValue;
	}
	public void setMinEdgeValue(int minEdgeValue) {
		this.minEdgeValue = minEdgeValue;
	}
	public int getMinPairValue() {
		return minPairValue;
	}
	public void setMinPairValue(int minPairValue) {
		this.minPairValue = minPairValue;
	}	

}
