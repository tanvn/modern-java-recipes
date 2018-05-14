package tanvn.java.recipes.chapter3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Recipe9 {
  public static void main(String[] args) {
    Optional<Integer> firstEven = Stream
        .of(3, 1, 4, 1, 5, 9, 2, 6, 5)
          .parallel()
          .filter(n -> n % 2 == 0)
          .findFirst();
    System.out.println(firstEven);
    Optional<Integer> firstEvenGT10 = Stream
        .of(3, 1, 4, 1, 5, 9, 2, 6, 5)
          .filter(n -> n > 10)
          .filter(n -> n % 2 == 0)
          .findFirst();

    System.out.println(firstEvenGT10);
    List<String> wordList = Arrays.asList("this", "is", "a", "stream", "of",
        "strings");
    Set<String> words = new HashSet<>(wordList);
    Set<String> words2 = new HashSet<>(words);

    // Now add and remove enough elements to force a rehash
    IntStream.rangeClosed(0, 50).forEachOrdered(
        i -> words2.add(String.valueOf(i)));
    words2.retainAll(wordList);

    // The sets are equal, but have different element ordering
    System.out.println(words.equals(words2));
    System.out.println("Before: " + words);
    System.out.println("After : " + words2);

    // ...

    Optional<Integer> anyold = Stream
        .of(3, 1, 4, 1, 5, 9, 2, 6, 5)
          .unordered()
          .parallel()
          .map(Recipe9::delay)
          .findAny();

    System.out.println("Any: " + anyold);
    Optional<Integer> any = Stream
        .of(3, 1, 4, 1, 5, 9, 2, 6, 5)
          .unordered()
          .map(Recipe9::delay)
          .findAny();

    System.out.println("Sequential Any: " + any);

    any = Stream
        .of(3, 1, 4, 1, 5, 9, 2, 6, 5)
          .unordered()
          .parallel()
          .map(Recipe9::delay)
          .findAny();

    System.out.println("Parallel Any: " + any);

  }

  public static Integer delay(Integer n) {
    try {
      Thread.sleep((long) (Math.random() * 100));
    } catch (InterruptedException ignored) {
    }
    return n;
  }

}
