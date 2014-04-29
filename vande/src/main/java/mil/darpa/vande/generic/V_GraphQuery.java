package mil.darpa.vande.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * This object encapsulates the specification for a graph including
 * the initial search terms.
 * 
 * @author PWG for DARPA
 */
public class V_GraphQuery {

	private Set<String> searchIds = new HashSet<String>();
	private Long startTime = null;
	private Long endTime = null;
	private int minTransValue = 0;

	private int maxEdgesPerNode = 50;
	private int maxNodes = 200;
	private boolean directed=true;
	private int minLinks = 1;
	private int maxHops = 3;
	
/**
	 * @param searchIds a Set of initial terms to search for. Must not be 
	 * empty 
	 * @param startTime Long - If non-null, ignore items prior to this time
	 * @param endTime Long - If non-null, ignore items prior to this time 
	 * @param minTransValue - if non-null, ignore line items with a value of less than
	 * this amount
	 * @param minEdgeValue - if non-null, ignore edges with a value of less than
	 * this amount
	 * @param minPairValue - if non-null, ignore edges where the total value of 
	 * edges between the parties is less than
	 * this amount
	 * @param maxEdgesPerNode int. If a node has more than the specified 
	 * number of edges, return it tagged as a placeholder.
	 * @param maxNodes do not return a graph with more than this number
	 * of nodes. If the number of nodes exceeds this number. reduce the 
	 * degree until a graph with fewer nodes is reached. If that is not
	 * possible, return an error.  
	 * @param directed boolean. If false, treat an edge from A to B
	 * and an edge from B to A as the same edge.
	 * @param minLinks int do not show an edge betweem two nodes if there were 
	 * fewer than this number of interactions.
	 * @param maxDegrees int do not show more than this number of degrees.
	 *  
**/ 

	public V_GraphQuery(Set<String> searchIds, Long startTime, Long endTime,
			int minTransValue, int maxEdgesPerNode, int maxNodes, boolean directed,
			int minLinks, int maxHops) {
		this.searchIds = searchIds;
		this.startTime = startTime;
		this.endTime = endTime;
		this.minTransValue = minTransValue;
		this.maxEdgesPerNode = maxEdgesPerNode;
		this.maxNodes = maxNodes;
		this.directed=directed;
		this.minLinks = minLinks;
		this.setMaxHops(maxHops);
	}
	
	public V_GraphQuery(){
		
	}
	
	public Set<String> getSearchIds() {
		return searchIds;
	}
	
	public void addSearchId(String id)
	{
		searchIds.add(id);
	}
	public void setSearchIds(Set<String> searchIds) {
		this.searchIds = searchIds;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public int getMinTransValue() {
		return minTransValue;
	}
	public void setMinTransValue(int minValue) {
		this.minTransValue = minValue;
	}
	public int getMaxEdgesPerNode() {
		return maxEdgesPerNode;
	}
	public void setMaxEdgesPerNode(int maxEdgesPerNode) {
		this.maxEdgesPerNode = maxEdgesPerNode;
	}
	public int getMaxNodes() {
		return maxNodes;
	}
	public void setMaxNodes(int maxNodes) {
		this.maxNodes = maxNodes;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public int getMinLinks() {
		return minLinks;
	}

	public void setMinLinks(int minLinks) {
		this.minLinks = minLinks;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public int getMaxHops() {
		return maxHops;
	}

	public void setMaxHops(int maxHops) {
		this.maxHops = maxHops;
	}

	@Override
	public String toString() {
		return "GraphQuery [searchIds=" + searchIds + ", startTime="
				+ startTime + ", endTime=" + endTime + ", minValue=" + minTransValue
				+ ", maxEdgesPerNode=" + maxEdgesPerNode + ", maxNodes="
				+ maxNodes + ", directed=" + directed + ", minLinks="
				+ minLinks + ", maxHops=" + maxHops + "]";
	}

	

}
