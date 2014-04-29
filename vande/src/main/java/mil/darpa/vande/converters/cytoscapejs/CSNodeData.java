package mil.darpa.vande.converters.cytoscapejs;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mil.darpa.vande.generic.V_GenericNode;
import mil.darpa.vande.generic.V_GraphObjectData;

public class CSNodeData {
	public String id;
	public String idType;
	public String idVal;
	public String label;
	public String name;
	public String type = "circle";
	public boolean origin=false;
	public boolean visible = true;
	public boolean cluster=false;
	public int nbrLinks= 0;
	
	public List<CSAttr> attrs = new ArrayList<CSAttr>();
	
public CSNodeData()
{
	
}

public CSNodeData(V_GenericNode node)
{
	this.id=node.getId();
	this.label=node.getLabel();
	this.name = node.getLabel();
	this.idVal = node.getIdVal();
	this.idType = node.getIdType();
	this.origin = node.isOrigin();
	this.cluster = node.isCluster();
	this.nbrLinks = node.getNbrLinks();

	Set<V_GraphObjectData> s= node.getDataSet();
	for (V_GraphObjectData d:s) {
		this.attrs.add(new CSAttr(d.getKey(), d.getKeyVal()));
	}
	
	this.attrs.add(new CSAttr("Links", Integer.toString(this.nbrLinks)));
	if (cluster)
		this.attrs.add(new CSAttr("Placeholder", "Too many links"));
	
}



	
	
}