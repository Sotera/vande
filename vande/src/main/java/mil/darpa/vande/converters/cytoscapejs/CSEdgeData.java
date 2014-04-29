package mil.darpa.vande.converters.cytoscapejs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GraphObjectData;

public class CSEdgeData {
	
	public String id;
	public String source;
	public String target;
	public String amount;
	public String count;
	public String idType;
	public String idVal;
	public String label;
	public String weight="0";
	public int day = -1;
	public int month=-1;
	public int year=-1;

	public List<CSAttr> attrs = new ArrayList<CSAttr>();

	public int linewidth = 1;
	public String type = "";
	public boolean visible=true;
	public String[] direction = null;
	
	public CSEdgeData()
	{
		
	}
	
	public CSEdgeData(V_GenericEdge e)
	{
		if (e.isDirected()) {
			direction=new String[2];
			direction[0] = e.getSourceId();
			direction[1] = e.getTargetId();
			type="arrow";
		}
		
		source=e.getSourceId();
		target = e.getTargetId();
		label = e.getLabel();
		idType = e.getIdType();
		idVal = e.getIdVal();
		
		amount=Double.toString(e.getValue());
		weight=Integer.toString(e.getWeight());
		
		day=e.getDay();
		month=e.getMonth();
		year=e.getYear();
		count = Integer.toString(e.getCount());
		
		Set<V_GraphObjectData> s= e.getDataSet();
		for (V_GraphObjectData d:s) {
			this.attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
		}
	}

}
