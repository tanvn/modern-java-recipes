package tanvn.java.recipes.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe2 {

  public static void main(String[] args) {
    List<String> superHeroes = Stream
        .of("Mr. Furious", "The Blue Raja", "The Shoveler", "The Bowler",
            "Invisible Boy", "The Spleen", "The Sphinx")
          .sorted()
          .collect(Collectors.toList());
    System.out.println(superHeroes);
    Set<String> prefectures = Stream
        .of("Tokyo", "Osaka", "Kanagawa", "Chiba", "Kyoto", "Tokyo")

          .collect(Collectors.toSet());
    System.out.println(prefectures);
    String[] movies = Stream
        .of("Hellboy", "Avengers", "Black Panther", "Insidious", "The gift",
            "DeadPool 2")
          .toArray(String[]::new);
    System.out.println(Arrays.toString(movies));
    Set<Actor> actors = Movie.mysteryMenActors();
    Map<String, String> namesAndRoles = actors.stream().collect(
        Collectors.toMap(Actor::getName, Actor::getRole));
    namesAndRoles.forEach((k, v) -> System.out.println(k + " played " + v));
  }

}
