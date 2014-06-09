package mil.darpa.vande.generic;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class GenericGraphTest {
	@Test
	public void test() {
		V_GenericNode g = new V_GenericNode("theId");

		AssertJUnit.assertEquals("theId", g.getId());

		g.addData("key", "value");
		AssertJUnit.assertEquals("value", g.getDataValue("key"));

	}
}
