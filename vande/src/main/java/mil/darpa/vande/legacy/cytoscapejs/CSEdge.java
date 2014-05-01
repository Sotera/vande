package mil.darpa.vande.legacy.cytoscapejs;
import mil.darpa.vande.legacy.GenericEdge;


@Deprecated
public class CSEdge {
	
	public CSEdgeData data;
	
	public CSEdge()
	{
		
	}
	
	public CSEdge(GenericEdge e)
	{
		this.data = new CSEdgeData(e);
	}

}
