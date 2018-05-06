package tanvn.java.recipes.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Recipe1 {
	public static void main(String[] args) {
		List<String> myString = Arrays.asList("this", "is", "a", "list", "of", "strings");

		myString.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println(s);
			}
		});

		myString.forEach(s -> System.out.println(s));
		myString.forEach(System.out::println);

	}

}
