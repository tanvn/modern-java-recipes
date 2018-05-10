package tanvn.java.recipes.chapter3;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe4 {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("this", "is", "a", "list", "of",
        "strings");

    List<String> sorted = strings
        .stream()
          .sorted(Comparator.comparingInt(String::length))
          .collect(Collectors.toList());
    sorted.stream().reduce((prev, curr) -> {
      assertTrue(prev.length() <= curr.length());
      return curr;
    });
  }

}
