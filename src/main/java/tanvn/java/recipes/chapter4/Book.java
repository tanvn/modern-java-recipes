package tanvn.java.recipes.chapter4;

public class Book {

  private String id;
  private String name;
  private double price;

  public Book(String id, String name, double price) {
    super();
    this.id = id;
    this.price = price;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Book [name=" + name + ", price=" + price + "]";
  }

}
