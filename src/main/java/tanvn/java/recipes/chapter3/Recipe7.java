package tanvn.java.recipes.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe7 {
	public static void main(String[] args) {
		final List<String> strings = Arrays.asList("me", "you", "this", "world", "and", "the", "rest");
		Map<Boolean, Long> numberLengthMap = strings.stream()
				.collect(Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.counting()));

		numberLengthMap.forEach((k, v) -> System.out.printf("%5s: %d%n", k, v));

	}
}
