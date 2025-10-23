package edu.test;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class WareHouse {
	
     
	public static void main(String[] args) {
		ArrayList<Product> l = new ArrayList<>();
		StockObserver observer = new AlertService();

		l.add(new Product("P101", "LAPTOP", 20, 50));
		l.add(new Product("P102", "VIVO1PLUS", 30, 60));
		l.add(new Product("P103", "KEYBOARD", 10, 40));
		l.add(new Product("P104", "PENDRIVE", 30, 70));
		l.add(new Product("P105", "MOUSE", 20, 45));
		l.add(new Product("P106", "SPEAKAER", 20, 50));
		l.add(new Product("P107", "JOYSTICK", 20, 50));
		l.add(new Product("P108", "LIGHTPEN", 20, 50));

		int choice = 0;
		ListIterator<Product> itr = null;
		Product p = null;
		String id = null, name = null;
		int quantity = 0, threshold = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("-----WELCOME TO THE WAREHOUSE-----");
			System.out.println("1.DISPLAY ITEMS");
			System.out.println("2.SEARCH PRODUCT BY ID");
			System.out.println("3.ADD NEW PRODUCT");
			System.out.println("4.RECEIVE SHIPMENT");
			System.out.println("5.FULFILL ORDER");
			System.out.println("6.EXIT");

			System.out.println("Enter your choice");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				// DISPLAY
				System.out.println("----- CURRENT INVENTORY -----");
				itr = l.listIterator();

				while (itr.hasNext()) {
					p = itr.next();
					System.out.println(p);
				}
				break;

			case 2:
				System.out.println("ENTER ID OF ITEM YOU WANT TO SEARCH");
				id = sc.next();
				itr = l.listIterator();
				boolean found = false;

				while (itr.hasNext()) {
					p = itr.next();
					if (p.getProductId().equals(id)) {
						found = true;
						System.out.println("Here is your Product:");
						System.out.println(p);
						break;
					}
				}
				if (!found) {
					System.out.println("Item not found for the Id:" + id);
				}
				break;

			case 3:
				// Add new product
				System.out.println("Enter Product Id:");
				id = sc.next();
				System.out.println("Enter Product Name:");
				name = sc.next();
				System.out.println("Enter Product Quantity:");
				quantity = sc.nextInt();
				if (quantity < 0) {
					System.out.println("Error: Quantity cannot be negative! Please enter a valid Quantity");
					quantity = sc.nextInt();
				}
				System.out.println("Enter Product Threshold:");
				threshold = sc.nextInt();

				boolean productExists = false;
				itr = l.listIterator();

				while (itr.hasNext()) {
					p = itr.next();
					if (p.getProductId().equals(id)) {
						productExists = true;
						if (!p.getProductName().equalsIgnoreCase(name)) {
							System.out.println("Error: Product ID already exists with a different name ("
									+ p.getProductName() + ")");
						} else {
							int newQty = p.getQuantity() + quantity;
							p.setQuantity(newQty); // new setter
							System.out.println("Existing product found. Quantity updated for: " + p.getProductName());
						}
						break;
					}
				}

				if (!productExists) {
					Product newProduct = new Product(id, name, threshold, quantity);
					l.add(newProduct);
					System.out.println("Product added successfully.");
				}
				break;

			case 4:
				// receive shipment

				// either stock is finished or stocked limited the threshold

				System.out.println("Enter the Product Id of the product you want to Add in Warehouse");
				id = sc.next();
				System.out.println("Enter the quantity of Product");
				quantity = sc.nextInt();
				if (quantity < 0) {
					System.out.println("Quantity cannot be negative! Please enter a valid quantity.");
					quantity = sc.nextInt();
				}
				sc.nextLine();
				itr = l.listIterator();
				boolean found2 = false;
				while (itr.hasNext()) {
					p = itr.next();
					if (p.getProductId().equals(id)) {
						found2 = true;
						int qty = p.getQuantity();
						qty = qty + quantity;
						p.setQuantity(qty);
						System.out.println("SHIPMENT RECEIVED SUCCESSFULLY");

						if (p.getQuantity() > p.getThreshold()) {
							System.out.println("Stock is now above threshold level (" + p.getThreshold() + ")");
						}
						break;
					}
				}
				if (!found2) {
					System.out.println("Product not found for the Id :" + id);
				}
				break;

			case 5:
				// fulfill order

				// step 1 - take Product Id and Quantity from user

				System.out.println("Enter the Id of product you want to Order");
				id = sc.next();
				System.out.println("Enter the quantity of Product");
				quantity = sc.nextInt();
				if (quantity < 0) {
					System.out.println("Quantity cannot be negative! Please enter a valid quantity.");
					quantity = sc.nextInt();
				}
				sc.nextLine();

				boolean productFound = false;

				// step 2 - check if product exist

				itr = l.listIterator();
				while (itr.hasNext()) {
					p = itr.next();

					if (p.getProductId().equals(id)) {
						productFound = true;

						// check if product is on the stock
						if (p.getQuantity() < quantity) {
							System.out.println("Insufficient Stock available for " + p.getProductName());
							break;
						}

						// Update the stock
						else {
							int qty = p.getQuantity();
							qty = qty - quantity;
							p.setQuantity(qty);
							System.out.println("Fulfilled order : " + quantity + "units of " + p.getProductName()
									+ "(Remaining : " + p.getQuantity() + ")");
						}
						if (p.getQuantity() < p.getThreshold()) {
							observer.lowStock(p);
						}
						break;
					}
				}
				if(!productFound) {
					System.out.println("Product not found for the Id:" + id);
				}
				break;

			case 6:
				System.exit(0);

			default:
				System.out.println("Invalid choice");

			}
			System.out.println("================================================");
		}
	}
}
