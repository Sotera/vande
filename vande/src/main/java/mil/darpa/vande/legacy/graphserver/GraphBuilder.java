package mil.darpa.vande.legacy.graphserver;

import mil.darpa.vande.legacy.GenericGraph;
/**
 * TODO: replace the string type with G_CanonicalPropertyType.
 * 
 * @author pwg
 *
 */

@Deprecated
public interface GraphBuilder {

	/**
	 * 
	 * @param type
	 *            String. Can be "customer", "customerList",
	 *            account", "accountList", "id" or an identifier
	 * 
	 * @param values
	 *            String[]. A list of values to treat as level 1 nodes.
	 * @param maxDegree
	 *            int. The maximum number of degrees for the graph.
	 * @return GraphResponse - an object containing the graph in GraphML format
	 * @throws Exception
	 */
	GenericGraph makeGraphResponse(String type, String[] values, int maxDegree,
			String nodeType) throws Exception;

	void setMaxNodes(int maxNodes);

	void setMaxEdgesPerNode(int maxEdgesPerNode);

	void setBiPartite(boolean biPartite);

	void setShowLeafNodes(boolean showLeafNodes);

	void setShowNameNodes(boolean showNameNodes);

	void setStyle(boolean style);

}