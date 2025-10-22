
public class Product {
   private String productId;
   private String productName;
   private int threshold;
   private int quantity;
   public Product(String productId, String productName, int threshold, int quantity) {
	    this.productId = productId;
	    this.productName = productName;
	    this.threshold = threshold;
	    setQuantity(quantity); // reuse validation
	}

   public String getProductId() {
	return productId;
   }
   public void setProductId(String productId) {
	this.productId = productId;
   }
   public String getProductName() {
	return productName;
   }
   public void setProductName(String productName) {
	this.productName = productName;
   }
   public int getThreshold() {
	return threshold;
   }
   public void setThreshold(int threshold) {
	this.threshold = threshold;
   }
   public int getQuantity() {
	return quantity;
   }
   public void setQuantity(int quantity) {
	   if(quantity < 0) {
		   System.out.println("Quantity can not be negative");
	   }
	   else {
		   this.quantity = quantity;
	   }
	
   }
   public String toString() {
	   return "[ " + productId + ", " + productName + ", " + threshold + ", " + quantity + " ]";  
   }
}
