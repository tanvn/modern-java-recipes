package tanvn.java.recipes.chapter2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Recipe3 {
	public String getNamesOfLength(int length, String... names) {
		return Arrays.stream(names).filter(s -> s.length() == length).collect(Collectors.joining(", "));
	}

}
