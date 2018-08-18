package tanvn.java.recipes.chapter4;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movie {

  public static Set<Actor> mysteryMenActors() {
    return Stream
        .of(new Actor("Janeane Garofalo", "The Bowler"),
            new Actor("Greg Kinnear", "Captain Amazing"),
            new Actor("William H. Macy", "The Shoveler"),
            new Actor("Paul Reubens", "The Spleen"),
            new Actor("Wes Studi", "The Sphinx"),
            new Actor("Kel Mitchell", "Invisible Boy"))
          .collect(Collectors.toSet());
  }

  private Set<Actor> actors;

  public Movie(Set<Actor> actors) {
    super();
    this.actors = actors;
  }

  public Set<Actor> getActors() {
    return actors;
  }

  public void setActors(Set<Actor> actors) {
    this.actors = actors;
  }

}
