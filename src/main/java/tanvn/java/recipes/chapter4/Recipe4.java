package tanvn.java.recipes.chapter4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe4 {
  public static void main(String[] args) {
    final String wordsPath = "/usr/share/dict/words";
    System.out.println("\nNumber of words of each length:");
    try (Stream<String> lines = Files.lines(Paths.get(wordsPath))) {
      // Map<Integer, List<String>> lengthGroup = lines
      // .collect(Collectors.groupingBy(String::length));
      Map<Integer, Long> lengthCount = lines
          .filter(s -> s.length() > 15)
            .collect(
                Collectors.groupingBy(String::length, Collectors.counting()));
      lengthCount
          .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
            .forEach(
                e -> System.out.println(e.getKey() + " ->" + e.getValue()));
      // .forEach(
      // (length, count) -> System.out.println(length + " : " + count));

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
