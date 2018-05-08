package tanvn.java.recipes.chapter3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Recipe1 {
  public static void main(String[] args) {
    String names = Stream
        .of("Gomez", "Morticia", "Wednesday", "Pugsley")
          .collect(Collectors.joining(","));
    System.out.println(names);
    List<BigDecimal> nums = Stream
        .iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
          .limit(10)
          .collect(Collectors.toList());
    System.out.println(nums);
    // prints [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L)).limit(10).forEach(
        System.out::println);
    List<Integer> ints = IntStream.range(10, 15).boxed().collect(
        Collectors.toList());
    System.out.println(ints);
    // prints [10, 11, 12, 13, 14]

    List<Long> longs = LongStream.rangeClosed(10, 15).boxed().collect(
        Collectors.toList());
    System.out.println(longs);
    // prints [10, 11, 12, 13, 14, 15]
  }

}
