package mil.darpa.vande.legacy.graphserver;

import java.util.ArrayList;
import java.util.List;

import mil.darpa.vande.DirectableObject;


@Deprecated
public class TransactionDistinctEntityPair implements DirectableObject {

	private List<Object> attributeList = new ArrayList<Object>();
	private String dest = "";
	private String destEntityId = "";
	private String destEntityName = "";
	private int nbr = 0;
	private String src = "";

	private String srcEntityId = "";
	private String srcEntityName = "";

	private Double total = 0D;

	//TODO: This was changed to Number, from String, to make it work with Vande.  But does this suit the needs? --djue
	private Number value = 0;

	private int weight = 0;

	public TransactionDistinctEntityPair() {

	}

	public void addAttribute(Object attr) {
		attributeList.add(attr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDistinctEntityPair other = (TransactionDistinctEntityPair) obj;
		if (attributeList == null) {
			if (other.attributeList != null)
				return false;
		} else if (!attributeList.equals(other.attributeList))
			return false;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (destEntityId == null) {
			if (other.destEntityId != null)
				return false;
		} else if (!destEntityId.equals(other.destEntityId))
			return false;
		if (destEntityName == null) {
			if (other.destEntityName != null)
				return false;
		} else if (!destEntityName.equals(other.destEntityName))
			return false;
		if (nbr != other.nbr)
			return false;
		if (src == null) {
			if (other.src != null)
				return false;
		} else if (!src.equals(other.src))
			return false;
		if (srcEntityId == null) {
			if (other.srcEntityId != null)
				return false;
		} else if (!srcEntityId.equals(other.srcEntityId))
			return false;
		if (srcEntityName == null) {
			if (other.srcEntityName != null)
				return false;
		} else if (!srcEntityName.equals(other.srcEntityName))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	public List<Object> getAttributeList() {
		return attributeList;
	}

	@Override
	public String getDest() {
		// TODO Auto-generated method stub
		return dest;
	}

	@Override
	public List<Object> getDestAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDestEntityId() {
		return destEntityId;
	}

	public String getDestEntityName() {
		return destEntityName;
	}

	@Override
	public List<Object> getEdgeAttributes() {
		return attributeList;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNbr() {
		return nbr;
	}

	@Override
	public String getSrc() {
		return src;
	}

	@Override
	public List<Object> getSrcAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSrcEntityId() {
		return srcEntityId;
	}

	public String getSrcEntityName() {
		return srcEntityName;
	}

	public Double getTotal() {
		return total;
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attributeList == null) ? 0 : attributeList.hashCode());
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result
				+ ((destEntityId == null) ? 0 : destEntityId.hashCode());
		result = prime * result
				+ ((destEntityName == null) ? 0 : destEntityName.hashCode());
		result = prime * result + nbr;
		result = prime * result + ((src == null) ? 0 : src.hashCode());
		result = prime * result
				+ ((srcEntityId == null) ? 0 : srcEntityId.hashCode());
		result = prime * result
				+ ((srcEntityName == null) ? 0 : srcEntityName.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + weight;
		return result;
	}

	public void setAttributeList(List<Object> attributeList) {
		this.attributeList = attributeList;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public void setDestEntityId(String destEntityId) {
		this.destEntityId = destEntityId;
	}

	public void setDestEntityName(String destEntityName) {
		this.destEntityName = destEntityName;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setSrcEntityId(String srcEntityId) {
		this.srcEntityId = srcEntityId;
	}

	public void setSrcEntityName(String srcEntityName) {
		this.srcEntityName = srcEntityName;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setValue(Number value) {
		this.value = value;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
