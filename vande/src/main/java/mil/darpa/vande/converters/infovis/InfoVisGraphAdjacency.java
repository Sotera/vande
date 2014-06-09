package mil.darpa.vande.converters.infovis;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "adjacencies", "data", "id", "name" })
@Deprecated
public class InfoVisGraphAdjacency {
	@JsonProperty("data")
	private HashMap<String, String> data;
	@JsonProperty("adjacencies")
	private ArrayList<InfoVisEdge> edges;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;

	public final ArrayList<InfoVisEdge> getEdges() {
		return edges;
	}

	public final void setEdges(ArrayList<InfoVisEdge> edges) {
		this.edges = edges;
	}

	public InfoVisGraphAdjacency() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InfoVisGraphAdjacency [data=" + data + ", edges=" + edges
				+ ", id=" + id + ", name=" + name + "]";
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param d
	 */
	public InfoVisGraphAdjacency(final String id, final String name,
			final String... d) {
		this.id = id;
		this.name = name;
		for (int i = 0; i < d.length; i += 2) {
			if (d.length > i + 1) {
				addData(d[i], d[i + 1]);
			}
		}
	}

	// keys are like [$dim, $color, $type]
	// ex {$dim=10, $color=#83548B, $type=circle}
	public void addData(final String key, final String value) {
		if (data == null) {
			data = new HashMap<String, String>(3);
		}
		data.put(key, value);
	}

	public void addEdge(final InfoVisEdge a) {
		if (edges == null) {
			edges = new ArrayList<InfoVisEdge>(5);
		}
		edges.add(a);
	}

	public HashMap<String, String> getData() {
		return data;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setData(final HashMap<String, String> data) {
		this.data = data;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
