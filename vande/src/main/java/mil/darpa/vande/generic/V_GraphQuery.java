package mil.darpa.vande.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This object encapsulates the specification for a graph including the initial
 * search terms.
 * 
 * @author PWG for DARPA
 */
@Deprecated
public class V_GraphQuery {
	private static final Logger logger = LoggerFactory.getLogger(V_GraphQuery.class);

	private boolean directed = true;
	private Long endTime = null;
	private String id = null; // Used for logging and persistence purposes
	private int maxEdgesPerNode = 50;
	private int maxHops = 3;
	private int maxNodes = 200;
	private int minLinks = 1;
	private int minTransValue = 0;
	private Set<String> searchIds = new HashSet<String>();
	private List<String> errors = new ArrayList<String>();

	private Long startTime = null;

	private final long timeInitiated = new Date().getTime();

	/*
	 * This was added to because legacy graph builders used it as a separate
	 * query parameter. --djue. It is usually something like customer or account
	 */
	private String type = null;
	private String userId = "unknown";
	private String username = "unknown";

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

	public V_GraphQuery(final Set<String> searchIds, final Long startTime, final Long endTime, final int minTransValue,
			final int maxEdgesPerNode, final int maxNodes, final boolean directed, final int minLinks, final int maxHops) {
		this.searchIds = searchIds;
		this.startTime = startTime;
		this.endTime = endTime;
		this.minTransValue = minTransValue;
		this.maxEdgesPerNode = maxEdgesPerNode;
		this.maxNodes = maxNodes;
		this.directed = directed;
		this.minLinks = minLinks;
		this.maxHops = maxHops;
	}

	public V_GraphQuery(final V_GraphQuery q) {
		directed = q.directed;
		endTime = q.endTime;
		maxEdgesPerNode = q.maxEdgesPerNode;
		maxHops = q.maxHops;
		maxNodes = q.maxNodes;
		minLinks = q.minLinks;
		searchIds = q.searchIds;
		startTime = q.startTime;
		type = q.type;

	}

	public void addSearchIds(final String... id) {
		if ((id == null) || (id.length == 0)) {
			logger.warn("null or empty id provided: " + Arrays.toString(id));
		} else {
			for (final String x : id) {
				searchIds.add(x);
			}

		}
	}

	public Long getEndTime() {
		return endTime;
	}

	/* * * * * * * * * * * * * * * * * */
	/* GETTERS */
	/* * * * * * * * * * * * * * * * * */

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	public String getId() {
		return id;
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

	public long getTimeInitiated() {
		return timeInitiated;
	}

	public String getType() {
		return type;
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public boolean isDirected() {
		return directed;
	}

	/* * * * * * * * * * * * * * * * * */
	/* SETTERS */
	/* * * * * * * * * * * * * * * * * */

	public void setDirected(final boolean directed) {
		this.directed = directed;
	}

	public void setEndTime(final Long endTime) {
		this.endTime = endTime;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(final List<String> errors) {
		this.errors = errors;
	}

	public void setId(final String id) {
		this.id = id;
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
		minTransValue = minValue;
	}

	public void setSearchIds(final Set<String> searchIds) {
		this.searchIds = searchIds;
	}

	public void setStartTime(final Long startTime) {
		this.startTime = startTime;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "V_GraphQuery [directed=" + directed + ", endTime=" + endTime + ", id=" + id + ", maxEdgesPerNode="
				+ maxEdgesPerNode + ", maxHops=" + maxHops + ", maxNodes=" + maxNodes + ", minLinks=" + minLinks
				+ ", username=" + username + ", userId=" + userId + ", minTransValue=" + minTransValue
				+ ", timeInitiated=" + timeInitiated + ", searchIds=" + searchIds + ", startTime=" + startTime
				+ ", type=" + type + "]";
	}
}
