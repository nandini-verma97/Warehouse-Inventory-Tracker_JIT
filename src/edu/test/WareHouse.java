package edu.test;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class WareHouse {
	public static void main(String[] args) {
		ArrayList<Product> l = new ArrayList<>();

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
			System.out.println("");
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
				// add new product
				System.out.println("Enter Product Id");
				id = sc.next();
				System.out.println("Enter Product name");
				name = sc.next();
				System.out.println("Enter product quantity");
				quantity = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter product threshold");
				threshold = sc.nextInt();
				sc.nextLine();
				boolean found1 = false;

				itr = l.listIterator();
				while (itr.hasNext()) {
					p = itr.next();
					if (p.getProductId().equals(id)) {
						found1 = true;
						int qty = p.getQuantity();
						qty = qty + quantity;
						p.setQuantity(qty);
						System.out.println("Product already exist with Id: " + p.getProductId() + "and Name: " + p.getProductName());
						break;
					}

				}
				if (!found1) {
					p = new Product(id, name, quantity, threshold);
					l.add(p);
					System.out.println("Product added successfully");
				}
				break;

			case 4:
				// receive shipment
				
				//either stock is finished or stocked limited the threshold
				
				
				System.out.println("Enter the Product Id of the product you want to Order");
				id = sc.next();
				System.out.println("Enter the quantity of Product");
				quantity = sc.nextInt();
				sc.nextLine();
				itr = l.listIterator();
				boolean found2 = false;
				while(itr.hasNext()) {
					p = itr.next();
					if(p.getProductId().equals(id)) {
						found2 = true;
						int qty = p.getQuantity();
						qty = qty +  quantity;
						p.setQuantity(qty);
						System.out.println("SHIPMENT RECEIVED SUCCESSFULLY");
						
						if (p.getQuantity() > p.getThreshold()) {
			                System.out.println("Stock is now above threshold level (" + p.getThreshold() + ")");
			            }
						break;
					}
				}
				if(!found2) {
					System.out.println("Product not found for the Id :" + id );
				}
				break;

			case 5:
				// fulfill order

			case 6:
				System.exit(0);

			default:
				System.out.println("Invalid choice");

			}
		}
	}
}
