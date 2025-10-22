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

				ListIterator<Product> itr = l.listIterator();
				Product p = null;
				while (itr.hasNext()) {
					p = itr.next();
					System.out.println(p);
				}
				break;

			case 2:
	            System.out.println("ENTER ID OF ITEM YOU WANT TO SEARCH");
	            String id = sc.next();
	            ListIterator<Product> itr1 = l.listIterator();
	            Product p1 = null;
	            boolean found  = false;
	            while(itr1.hasNext()){
	            	    p1  = itr1.next();
	                if(p1.getProductId().equals(id)){
	                	   found = true;
	                   System.out.println("Here is your Product:" + p1);
	                   break;
	                }
	            }
	            if(!found) {
	            	System.out.println("Item not found for the Id:" + id);
	            }
	            break;
	  

			case 3:
				// add new product

			case 4:
				// receive shipment

			case 5:
				// fulfill order

			case 6:
				System.exit(1);

			default:
				System.out.println("Invalid choice");

			}
		}
	}
}
