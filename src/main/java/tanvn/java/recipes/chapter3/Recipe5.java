package tanvn.java.recipes.chapter3;

import java.util.stream.IntStream;

public class Recipe5 {

	public static int sumDoublesDivisibleBy3(int start, int end) {
		return IntStream.rangeClosed(start, end).map(n -> n * 2).filter(n -> n % 3 == 0).sum();
	}

	public static int sumDoublesDivisibleBy3WithPeek(int start, int end) {
		return IntStream.rangeClosed(start, end).peek(n -> System.out.printf("original: %d%n", n)).map(n -> n * 2)
				.peek(n -> System.out.printf("doubled : %d%n", n)).filter(n -> n % 3 == 0)
				.peek(n -> System.out.printf("filtered: %d%n", n)).sum();
	}

	public static void main(String[] args) {
		System.out.println("result : " + sumDoublesDivisibleBy3WithPeek(10, 34));
	}

}
