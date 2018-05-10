package tanvn.java.recipes.chapter3;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe3 {
  public static void main(String[] args) {
    String[] strings = "this is an array of strings".split(" ");
    long count = Arrays.stream(strings).map(String::length).count();
    System.out.println("There are " + count + " strings");

    int totalLength = Arrays.stream(strings).mapToInt(String::length).sum();
    System.out.println("The total length is " + totalLength);

    OptionalDouble ave = Arrays
        .stream(strings)
          .mapToInt(String::length)
          .average();
    System.out.println("The average length is " + ave);

    OptionalInt max = Arrays.stream(strings).mapToInt(String::length).max();

    OptionalInt min = Arrays.stream(strings).mapToInt(String::length).min();

    System.out.println("The max and min lengths are " + max + " and " + min);
    String s = Stream.of("this", "is", "a", "list").reduce("", String::concat);
    System.out.println(s);
    String s2 = Stream
        .of("this", "is", "a", "list")
          .collect(() -> new StringBuilder(), (sb, str) -> sb.append(str),
              (sb1, sb2) -> sb1.append(sb2))
          .toString();
    String s3 = Stream.of("this", "is", "a", "list").collect(
        Collectors.joining());
  }

}
