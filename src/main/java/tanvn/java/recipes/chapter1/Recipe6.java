package tanvn.java.recipes.chapter1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe6 {
	public static void main(String[] args) {
		List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig");

		List<String> sorted = bonds.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		// [Brosnan, Connery, Craig, Dalton, Lazenby, Moore]

		sorted = bonds.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		// [Moore, Lazenby, Dalton, Craig, Connery, Brosnan]

		sorted = bonds.stream().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList());
		// [Brosnan, Connery, Craig, Dalton, Lazenby, Moore]

		sorted = bonds.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		// [Moore, Craig, Dalton, Connery, Lazenby, Brosnan]

		sorted = bonds.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		// [Craig, Moore, Dalton, Brosnan, Connery, Lazenby]
	}

}
