package tanvn.java.recipes.chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe1 {
	private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings", "made", "randomly");

	public List<String> defaultSort() {
		// Collections.sort(sampleStrings);
		sampleStrings.sort((a, b) -> a.compareTo(b));
		return sampleStrings;
	}

	public List<String> defaultSortUsingStreams() {
		return sampleStrings.stream().sorted().collect(Collectors.toList());
	}

	public List<String> lengthSortUsingSorted() {
		return sampleStrings.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
	}

	public List<String> lengthSortUsingComparator() {
		return sampleStrings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
	}

	public List<String> lengthSortThenAlphaSort() {
		return sampleStrings.stream()
				.sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Recipe1 rcp1 = new Recipe1();
		System.out.println(rcp1.lengthSortUsingComparator());
		System.out.println(rcp1.defaultSort());
		Stream<String> origin = Stream.of("This", "is", "a", "simple", "test", "about", "stream");
		Stream<String> clone = origin.sorted();
		System.out.println(clone.equals(origin));
		System.out.println(rcp1.lengthSortThenAlphaSort());
		clone.forEach(System.out::println);
		// origin.forEach(System.out::println); // Error here

	}

}
