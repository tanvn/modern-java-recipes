package tanvn.java.recipes.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe12 {
	public static void main(String[] args) {
		Stream<String> first = Stream.of("a", "b", "c").parallel();
		Stream<String> second = Stream.of("X", "Y", "Z");
		List<String> strings = Stream.concat(first, second).collect(Collectors.toList());
		List<String> stringList = Arrays.asList("a", "b", "c", "X", "Y", "Z");
		System.out.println(stringList.equals(strings));
	}

}
