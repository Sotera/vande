package mil.darpa.vande.converters.graphml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Used to insert the key definitions as properties in the top level of
 * <graphml>
 * 
 * @author pgofton
 * 
 */
// @XmlAccessorType(XmlAccessType.PROPERTY)
public class GraphmlKey {

	// @XmlAttribute(name = "for")
	// Note that "for" is a variable name in graphml
	private String fore;

	// @XmlAttribute
	private String id;

	@XmlAttribute(name = "attr.name")
	private String name;

	@XmlAttribute(name = "attr.type")
	private String type;

	public final String getFor() {
		return fore;
	}

	public final void setFor(String fore) {
		this.fore = fore;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	@XmlTransient
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public final String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GraphmlKey() {

	}

	/**
	 * 
	 * @param id
	 *            String: the name of the key
	 * @param fore
	 *            String: "node" or "edge"
	 * @param name
	 *            String: the name of the key (usually same as id)
	 * @param type
	 *            String: type of variable (usually "string")
	 */
	public GraphmlKey(final String id, final String fore, final String name,
			final String type) {
		this.id = id;
		this.fore = fore;
		this.name = name;
		this.type = type;
	}

}
