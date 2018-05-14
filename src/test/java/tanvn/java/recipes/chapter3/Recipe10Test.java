package tanvn.java.recipes.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class Recipe10Test {

	@Test
	public void testIsPrimeUsingAllMatch() throws Exception {
		assertTrue(IntStream.of(2, 3, 5, 7, 11, 13, 17, 19).allMatch(Recipe10::isPrime));
	}

	@Test
	public void testIsPrimeWithComposites() throws Exception {
		assertFalse(Stream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20).anyMatch(Recipe10::isPrime));
	}

	@Test
	public void emptyStreamsDanger() throws Exception {
		assertTrue(Stream.empty().allMatch(e -> false));
		assertTrue(Stream.empty().noneMatch(e -> true));
		assertFalse(Stream.empty().anyMatch(e -> true));
	}

}
