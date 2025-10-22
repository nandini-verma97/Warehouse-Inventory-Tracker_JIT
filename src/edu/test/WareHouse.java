package edu.test;

import java.util.ArrayList;

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
     
     System.out.println("Items added");
     System.out.println(new Product("P108", "LIGHTPEN", 20, 50));
     
	}
}

