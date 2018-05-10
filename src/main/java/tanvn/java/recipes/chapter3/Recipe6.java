package tanvn.java.recipes.chapter3;

import java.util.stream.Stream;

public class Recipe6 {

	public static boolean isPalindrome(String s) {
		long chars = s.toLowerCase().chars().peek(c -> System.out.println("char: " + c))
				.peek(cp -> System.out.println("code point: " + cp)).count();
		// .peek(cp -> System.out.println("code point: " + cp));
		String forward = s.toLowerCase().codePoints().filter(Character::isLetterOrDigit)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		String backward = new StringBuilder(forward).reverse().toString();
		return forward.equals(backward);
	}

	public static void main(String[] args) {
		Recipe6.isPalindrome("hello");
		// System.out.println("hello world");
		Stream.of("Madam, in Eden, I'm Adam", "Go hang a salami; I'm a lasagna hog", "Flee to me, remote elf!",
				"A Santa pets rats as Pat taps a star step at NASA").allMatch(Recipe6::isPalindrome);
	}
}
