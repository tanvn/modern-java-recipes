package tanvn.java.recipes.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Recipe5 {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(-3);
		nums.add(1);
		nums.add(4);
		nums.add(-1);
		nums.add(5);
		nums.add(9);
		boolean removed = nums.removeIf(n -> n <= 0);
		System.out.println("Elements were " + (removed ? "" : "NOT") + " removed");
		nums.forEach(System.out::println);
	}

}
