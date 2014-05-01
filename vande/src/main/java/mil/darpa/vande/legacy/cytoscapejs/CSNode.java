package mil.darpa.vande.legacy.cytoscapejs;

import mil.darpa.vande.legacy.GenericNode;



@Deprecated
public class CSNode {
	
	public CSNode()
	{
		
	}
	public CSNodeData data;
	
	public CSNode(GenericNode node)
	{
		data = new CSNodeData(node);
	}
	

}
