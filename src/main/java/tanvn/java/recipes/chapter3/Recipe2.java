package tanvn.java.recipes.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Recipe2 {
	public static void main(String[] args) {
		List<String> strings = Stream.of("this", "is", "a", "list", "of", "strings").collect(Collectors.toList());
		IntStream.of(3, 1, 4, 1, 5, 9).boxed().collect(Collectors.toList()); // does not compile
		IntStream.of(3, 4, 5, 6, 1, 19).mapToObj(Integer::valueOf).collect(Collectors.toSet());
		List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9).collect(ArrayList<Integer>::new, ArrayList::add,
				ArrayList::addAll);

	}

}
