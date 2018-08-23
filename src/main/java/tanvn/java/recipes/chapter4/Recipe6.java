package tanvn.java.recipes.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Recipe6 {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hello", "world", "how", "are", "things",
        "goinggg", "Iamverylong", "am", "a", "Java", "engineer");
    counting(words);
    maxLength(words);

  }

  private static void counting(List<String> words) {
    Map<Boolean, Long> numberLengthMap = words.stream().collect(Collectors
        .partitioningBy(a -> a.length() % 2 == 0, Collectors.counting()));
    numberLengthMap.forEach((k, v) -> {
      System.out.printf("%%2 ==0 %s : %d words %n", k, v);
    });
  }

  private static void maxLength(List<String> words) {
    Map<Boolean, Optional<String>> numberLengthMap = words.stream().collect(
        Collectors.partitioningBy(a -> a.length() % 2 == 0,
            Collectors.maxBy((a, b) -> a.length() - b.length())));
    numberLengthMap.forEach((k, v) -> {
      System.out.printf("max length of %%2 == %s : %s%n", k, v.orElse("N/A"));
    });

  }
}
