package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.enums.OrderStatus;
import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;

public class Principal {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
				
		for(int i = 1; i <= n; i ++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double Productprice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(nameProduct, Productprice);
			OrderItem it = new OrderItem(quantity, Productprice, product);
			
			order.addItems(it);
		}
		
		
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		}
		catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
		
		
		sc.close();
		
	}
}
