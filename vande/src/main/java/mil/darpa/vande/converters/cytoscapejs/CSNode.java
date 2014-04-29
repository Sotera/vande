package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericNode;


public class CSNode {
	
	public CSNode()
	{
		
	}
	public CSNodeData data;
	
	public CSNode(V_GenericNode node)
	{
		data = new CSNodeData(node);
	}
	

}
