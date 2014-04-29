package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericEdge;


public class CSEdge {
	
	public CSEdgeData data;
	
	public CSEdge()
	{
		
	}
	
	public CSEdge(V_GenericEdge e)
	{
		this.data=new CSEdgeData(e);
	}

}
