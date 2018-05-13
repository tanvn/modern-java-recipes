package tanvn.java.recipes.chapter3;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Recipe13 {
	public static int multByTwo(int n) {
		System.out.printf("Inside multByTwo with arg %d%n", n);
		return n * 2;
	}

	public static boolean divByThree(int n) {
		System.out.printf("Inside divByThree with arg %d%n", n);
		return n % 3 == 0;
	}

	public static void main(String[] args) {

		OptionalInt firstEvenDoubleDivBy3 = IntStream.range(100, 200).map(Recipe13::multByTwo)
				.filter(Recipe13::divByThree).findFirst();
		System.out.println(firstEvenDoubleDivBy3);
	}

}
