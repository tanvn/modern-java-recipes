package tanvn.java.recipes.chapter2;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImplementPredicate {

	public String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
		return Arrays.stream(names).filter(condition).collect(Collectors.joining(", "));
	}

	public String getNamesOfLength(int length, String... names) {
		return Arrays.stream(names).filter(s -> s.length() == length).collect(Collectors.joining(", "));
	}

	public String getNamesStartingWith(String s, String... names) {
		return Arrays.stream(names).filter(str -> str.startsWith(s)).collect(Collectors.joining(", "));
	}

	public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
	public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");

}
