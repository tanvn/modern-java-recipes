package tanvn.java.recipes.chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe3 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spärck Jones");

		List<Person> people = names.stream().map(name -> new Person(name)).collect(Collectors.toList());

		// or, alternatively,

		List<Person> people2 = names.stream().map(Person::new).collect(Collectors.toList());
		copyConstructor();
	}

	static void copyConstructor() {
		Person before = new Person("Grace Hopper");

		List<Person> people = Stream.of(before).collect(Collectors.toList());
		Person after = people.get(0);

		System.out.println(before == after);

		before.setName("Grace Murray Hopper");
		System.out.println("Grace Murray Hopper" == after.getName());
		people = Stream.of(before).map(Person::new).collect(Collectors.toList());
		after = people.get(0);
		System.out.println(before == after);
		System.out.println(before.equals(after));

		before.setName("Rear Admiral Dr. Grace Murray Hopper");
		System.out.println(before.equals(after));
	}

	static void arrayConstructor() {
		List<String> names = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spärck Jones");

		Person[] people = names.stream().map(Person::new).toArray(Person[]::new);
	}

}
