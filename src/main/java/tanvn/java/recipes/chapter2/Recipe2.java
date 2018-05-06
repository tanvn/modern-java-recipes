package tanvn.java.recipes.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Recipe2 {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("...");

		DoubleSupplier randomSupplier = new DoubleSupplier() {
			@Override
			public double getAsDouble() {
				return Math.random();
			}
			//
			// @Override
			// public Double get() {
			// // TODO Auto-generated method stub
			// return Math.random();
			// }
		};

		randomSupplier = () -> Math.random();
		randomSupplier = Math::random;

		// logger.info(randomSupplier);
		List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara", "Zoë", "Jayne", "Simon", "River",
				"Shepherd Book");

		Optional<String> first = names.stream().filter(name -> name.startsWith("C")).findFirst();

		System.out.println(first);
		System.out.println(first.orElse("None"));

		System.out.println(
				first.orElse(String.format("No result found in %s", names.stream().collect(Collectors.joining(", ")))));

		System.out.println(first.orElseGet(
				() -> String.format("No result found in %s", names.stream().collect(Collectors.joining(", ")))));

	}

}
