package Main;
import java.util.*;
public class Inventory implements Iterable<StockableProduct>{
	 private List<StockableProduct> items;
	 
//-------------constructor------------
	 public Inventory() {
		 this.items = new ArrayList<>();
	 }
	 
    
//---------------addItem()---------------------
	 public void addItem(StockableProduct product) {
		 items.add(product);
	 }
	 
	 
//-------------removeItem()-------------------
	 public void removeItem(int productId) {
		 items.removeIf(product -> product.getProductId() == productId);
	 }
	 
	 
//--------------getItem()------------------
	 public Product getItem(int productId) {
		 for (Product product : items) {
	            if (product.getProductId() == productId) {
	                return product;
	            }
	        }
	        return null;
	 }
	 
	 
//----------addProductStock()----------------
	 public void addProductStock(int productId, int numberOfNewStock) {
		 for (StockableProduct product : items) {
	            if (product.getProductId() == productId) {
	                product.addStock(numberOfNewStock);
	                break;
	            }
	        }
	 }
	 

//--------sortByPrice()------------------------
	 
	 public void sortByPrice() {
		 items.sort(Comparator.comparing(Product::getPrice));
	 }
	  
	 
//------------sortByAvailableStock()-----------------------
	 public void sortByAvailableStock() {
	        items.sort(Comparator.comparing(StockableProduct::getNumberOfItemsStocked));
	    }
	 
	    @Override
	    public Iterator<StockableProduct> iterator() {
	        return items.iterator();
	    }	 
	 
}
