package tanvn.java.recipes.chapter3;

import java.util.Arrays;
import java.util.List;

public class Recipe11 {
	public static void main(String[] args) {
		Customer sheridan = new Customer("Sheridan");
		Customer ivanova = new Customer("Ivanova");
		Customer garibaldi = new Customer("Garibaldi");

		sheridan.addOrder(new Order(1)).addOrder(new Order(2)).addOrder(new Order(3));
		ivanova.addOrder(new Order(4)).addOrder(new Order(5));

		List<Customer> customers = Arrays.asList(sheridan, ivanova, garibaldi);
		customers.stream().map(Customer::getName).forEach(System.out::println);
		customers.stream().map(Customer::getOrders).forEach(System.out::println);

		customers.stream().map(customer -> customer.getOrders().stream()).forEach(System.out::println);
		customers.stream().map(customer -> customer.getOrders().stream()).forEach(st -> {
			st.forEach(System.out::println);
		});

	}

}
