package edu.test;

public class AlertService implements StockObserver {
    public void lowStock(Product p) {
    	   System.out.println("Low stock for " + p.getProductName() +  " – only "+ p.getQuantity() + " left!");
    }
}
