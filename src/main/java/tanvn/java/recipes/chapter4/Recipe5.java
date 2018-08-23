package tanvn.java.recipes.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe5 {

  public static void main(String[] args) {
    List<String> words = Arrays.asList("this", "is", "a", "meaningless",
        "sentence", "just", "for", "test");
    Map<Boolean, List<String>> partitionWords = words.stream().collect(
        Collectors.partitioningBy(s -> s.length() % 2 == 0));
    partitionWords.forEach((type, wordList) -> {
      System.out.println("length %2 " + type + " : " + wordList);
    });
    Map<Integer, List<String>> groupByLength = words.stream().collect(
        Collectors.groupingBy(s -> s.length()));
    groupByLength.forEach((length, wordList) -> {
      System.out.printf("%d : %s%n", length, wordList);
    });
  }

}
