package tanvn.java.recipes.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

public class Recipe12Test {
	@Test
	public void concatParallel() throws Exception {
		Stream<String> first = Stream.of("a", "b", "c").parallel();
		Stream<String> second = Stream.of("X", "Y", "Z");
		Stream<String> third = Stream.of("alpha", "beta", "gamma");

		Stream<String> total = Stream.concat(Stream.concat(first, second), third);

		assertTrue(total.isParallel());
	}

	@Test
	public void flatMapNotParallel() throws Exception {
		Stream<String> first = Stream.of("a", "b", "c").parallel();
		Stream<String> second = Stream.of("X", "Y", "Z");
		Stream<String> third = Stream.of("alpha", "beta", "gamma");
		Stream<String> fourth = Stream.empty();

		Stream<String> total = Stream.of(first, second, third, fourth).flatMap(Function.identity());
		assertFalse(total.isParallel());
	}

	@Test
	public void flatMapParallel() throws Exception {
		Stream<String> first = Stream.of("a", "b", "c").parallel();
		Stream<String> second = Stream.of("X", "Y", "Z");
		Stream<String> third = Stream.of("alpha", "beta", "gamma");
		Stream<String> fourth = Stream.empty();

		Stream<String> total = Stream.of(first, second, third, fourth).flatMap(Function.identity());
		assertFalse(total.isParallel());

		total = total.parallel();
		assertTrue(total.isParallel());
	}

}
