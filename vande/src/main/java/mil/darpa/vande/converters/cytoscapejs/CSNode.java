package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericNode;

public class CSNode {

	private CSNodeData data;

	public CSNodeData getData() {
		return data;
	}

	public void setData(CSNodeData data) {
		this.data = data;
	}

	public CSNode() {

	}

	public CSNode(final V_GenericNode node) {
		data = new CSNodeData(node);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSNode other = (CSNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "CSNode [data=" + data + "]";
	}

}
