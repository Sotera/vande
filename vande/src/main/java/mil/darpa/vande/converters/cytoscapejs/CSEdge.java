package mil.darpa.vande.converters.cytoscapejs;

import mil.darpa.vande.generic.V_GenericEdge;

public class CSEdge {

	private CSEdgeData data;

	public final CSEdgeData getData() {
		return data;
	}

	public final void setData(CSEdgeData data) {
		this.data = data;
	}

	public CSEdge() {

	}

	@Override
	public String toString() {
		return "CSEdge [data=" + data + "]";
	}

	public CSEdge(final V_GenericEdge e) {
		this.data = new CSEdgeData(e);
	}

}
