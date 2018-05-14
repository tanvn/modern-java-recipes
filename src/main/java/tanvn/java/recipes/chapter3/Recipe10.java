package tanvn.java.recipes.chapter3;

import java.util.stream.IntStream;

public class Recipe10 {
	public static void main(String[] args) {

		IntStream.rangeClosed(2, 29).forEach(a -> {
			boolean result = isPrime(a);
			System.out.println(a + ":" + result);
		});

	}

	public static boolean isPrime(int n) {
		int upperBound = (int) Math.floor(Math.sqrt(n));
		// System.out.println(n + ":" + upperBound);
		return IntStream.rangeClosed(2, upperBound).noneMatch(a -> n % a == 0);
	}

}
