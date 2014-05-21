package mil.darpa.vande.generic;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This object encapsulates the specification for a graph including the initial
 * search terms.
 * 
 * @author PWG for DARPA
 */
public class V_GraphQuery {
	private boolean directed = true;
	private Long endTime = null;
	private int maxEdgesPerNode = 50;
	private int maxHops = 3;
	private int maxNodes = 200;
	private int minLinks = 1;
	private int minTransValue = 0;
	private static final Logger logger = LoggerFactory
			.getLogger(V_GraphQuery.class);

	private Set<String> searchIds = new HashSet<String>();
	private Long startTime = null;

	// This was added to because legacy graph builders used it as a separate
	// query parameter. --djue
	// It is usually something like customer or account
	private String type = null;

	public V_GraphQuery() {

	}

	/**
	 * @param searchIds
	 *            a Set of initial terms to search for. Must not be empty
	 * @param startTime
	 *            Long - If non-null, ignore items prior to this time
	 * @param endTime
	 *            Long - If non-null, ignore items prior to this time
	 * @param minTransValue
	 *            - if non-null, ignore line items with a value of less than
	 *            this amount
	 * @param minEdgeValue
	 *            - if non-null, ignore edges with a value of less than this
	 *            amount
	 * @param minPairValue
	 *            - if non-null, ignore edges where the total value of edges
	 *            between the parties is less than this amount
	 * @param maxEdgesPerNode
	 *            int. If a node has more than the specified number of edges,
	 *            return it tagged as a placeholder.
	 * @param maxNodes
	 *            do not return a graph with more than this number of nodes. If
	 *            the number of nodes exceeds this number. reduce the degree
	 *            until a graph with fewer nodes is reached. If that is not
	 *            possible, return an error.
	 * @param directed
	 *            boolean. If false, treat an edge from A to B and an edge from
	 *            B to A as the same edge.
	 * @param minLinks
	 *            int do not show an edge betweem two nodes if there were fewer
	 *            than this number of interactions.
	 * @param maxDegrees
	 *            int do not show more than this number of degrees.
	 * 
	 **/

	public V_GraphQuery(final Set<String> searchIds, final Long startTime,
			final Long endTime, final int minTransValue,
			final int maxEdgesPerNode, final int maxNodes,
			final boolean directed, final int minLinks, final int maxHops) {
		this.searchIds = searchIds;
		this.startTime = startTime;
		this.endTime = endTime;
		this.minTransValue = minTransValue;
		this.maxEdgesPerNode = maxEdgesPerNode;
		this.maxNodes = maxNodes;
		this.directed = directed;
		this.minLinks = minLinks;
		this.setMaxHops(maxHops);
	}

	public V_GraphQuery(V_GraphQuery q) {
		this.directed = q.directed;
		this.endTime = q.endTime;
		this.maxEdgesPerNode = q.maxEdgesPerNode;
		this.maxHops = q.maxHops;
		this.maxNodes = q.maxNodes;
		this.minLinks = q.minLinks;
		this.searchIds = q.searchIds;
		this.startTime = q.startTime;
		this.type = q.type;

	}

	public void addSearchIds(final String... id) {
		if (id == null || id.length == 0) {
			logger.warn("null or empty id provided: " + id);
		} else {
			for (String x : id) {
				searchIds.add(x);
			}

		}
	}

	public Long getEndTime() {
		return endTime;
	}

	public int getMaxEdgesPerNode() {
		return maxEdgesPerNode;
	}

	public int getMaxHops() {
		return maxHops;
	}

	public int getMaxNodes() {
		return maxNodes;
	}

	public int getMinLinks() {
		return minLinks;
	}

	public int getMinTransValue() {
		return minTransValue;
	}

	public Set<String> getSearchIds() {
		return searchIds;
	}

	public Long getStartTime() {
		return startTime;
	}

	public String getType() {
		return type;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(final boolean directed) {
		this.directed = directed;
	}

	public void setEndTime(final Long endTime) {
		this.endTime = endTime;
	}

	public void setMaxEdgesPerNode(final int maxEdgesPerNode) {
		this.maxEdgesPerNode = maxEdgesPerNode;
	}

	public void setMaxHops(final int maxHops) {
		this.maxHops = maxHops;
	}

	public void setMaxNodes(final int maxNodes) {
		this.maxNodes = maxNodes;
	}

	public void setMinLinks(final int minLinks) {
		this.minLinks = minLinks;
	}

	public void setMinTransValue(final int minValue) {
		this.minTransValue = minValue;
	}

	public void setSearchIds(final Set<String> searchIds) {
		this.searchIds = searchIds;
	}

	public void setStartTime(final Long startTime) {
		this.startTime = startTime;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GraphQuery [searchIds=" + searchIds + ", startTime="
				+ startTime + ", endTime=" + endTime + ", minValue="
				+ minTransValue + ", maxEdgesPerNode=" + maxEdgesPerNode
				+ ", maxNodes=" + maxNodes + ", directed=" + directed
				+ ", minLinks=" + minLinks + ", maxHops=" + maxHops + "]";
	}

}
