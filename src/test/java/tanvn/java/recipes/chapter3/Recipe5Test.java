package tanvn.java.recipes.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Recipe5Test {
	@Test
	public void sumDoublesDivisibleBy3Test() throws Exception {
		assertEquals(1554, Recipe5.sumDoublesDivisibleBy3(100, 120));
	}
}
