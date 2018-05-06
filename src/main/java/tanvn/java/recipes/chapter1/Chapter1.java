package tanvn.java.recipes.chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter1 {
	public static void main(String[] args) {
		recipe2();

	}

	static void recipe1() {
		Runnable r = () -> System.out.println("lambda expression implementing the run method");
		new Thread(r).start();
		File directory = new File("./src/main/java/tanvn/java/recipes/");
		System.out.println(directory.getAbsolutePath());

		String[] names = directory.list((File dir, String name) -> name.endsWith(".java"));

		List<String> listNames = Arrays.asList(names);
		// System.out.println(listNames.getClass().getName());
		System.out.println(Arrays.asList(names));

	}

	static void recipe2() {
		Stream.of(3, 1, 4, 1, 5, 9).forEach(x -> System.out.println(x));

		Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);

		Consumer<Integer> printer = System.out::println;
		Stream.of(3, 1, 4, 1, 5, 9).forEach(printer);
		System.out.println("------------");
		Stream.generate(Math::random).limit(10).forEach(System.out::println);

		List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
		List<String> sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
		Stream.of("hello", "world", "where", "will", "we", "disappear", "?").map(String::length)
				.forEach(System.out::print);
	}

}
