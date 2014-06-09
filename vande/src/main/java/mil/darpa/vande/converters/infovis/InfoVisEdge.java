package mil.darpa.vande.converters.infovis;

import java.util.HashMap;

@Deprecated
public class InfoVisEdge {
	private HashMap<String, String> data;

	/**
	 * { "nodeTo" : "graphnode1", "nodeFrom" : "graphnode0", "data" : { "$color"
	 * : "#557EAA" } }
	 */
	private String nodeTo, nodeFrom;

	public InfoVisEdge(final String t, final String f, final String... d) {
		nodeTo = t;
		nodeFrom = f;
		for (int i = 0; i < d.length; i += 2) {
			if (d.length > i + 1) {
				addData(d[i], d[i + 1]);
			}
		}
	}

	public void addData(final String key, final String value) {
		if (key != null && value != null && !key.isEmpty() && !value.isEmpty()) {
			if (data == null) {
				data = new HashMap<String, String>();
			}
			data.put(key, value);
		}
	}

	public final HashMap<String, String> getData() {
		return data;
	}

	public final String getNodeFrom() {
		return nodeFrom;
	}

	public final String getNodeTo() {
		return nodeTo;
	}

	public final void setData(final HashMap<String, String> theData) {
		this.data = theData;
	}

	public final void setNodeFrom(final String f) {
		this.nodeFrom = f;
	}

	public final void setNodeTo(final String t) {
		this.nodeTo = t;
	}

	@Override
	public String toString() {
		return "InfoVisEdge [nodeTo=" + nodeTo + ", nodeFrom=" + nodeFrom
				+ ", data=" + data + "]";
	}

}
