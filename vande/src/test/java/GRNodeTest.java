

import mil.darpa.vande.legacy.GenericNode;
import mil.darpa.vande.legacy.V_DirectedNode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * 
 * @author djue
 * 
 */
public class GRNodeTest {
	@Test
	public void testGRNode() {
		GenericNode n = new GenericNode();
		n.setBackgroundColor("unicorns");
		n.setId("SomeId");
		n.addData("attr1", "value1");
		n.addData("attr1", "value1");
		System.out.println(n);
		AssertJUnit.assertNotNull(n);
	}

	@Test
	public void testDirectedNode() throws Exception {
		V_DirectedNode d = new V_DirectedNode(1.0, "MyId");
		System.out.println(d);
		AssertJUnit.assertNotNull(d);
	}
}
