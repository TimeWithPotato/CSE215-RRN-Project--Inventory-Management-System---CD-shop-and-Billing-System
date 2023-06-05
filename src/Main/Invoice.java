package Main;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Invoice {
    private List<Product> items; 
    private LocalDateTime date;

    public Invoice() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public String getLocalDateTime() {
        return date.toString();
    }
    public void addProduct(Product product) {
        items.add(product);
        if (product instanceof StockableProduct) {
        	((StockableProduct) product).removeStock(1);
        }
    }
    public void removeProduct(Product product) {
        items.remove(product);
        if (product instanceof StockableProduct) {
        	((StockableProduct) product).addStock(1);
        }
    }

    public double calculatePriceWithoutDiscount() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
    private boolean isFullHouseDiscountAvailable() {
        int[] count = new int[3]; /// [0, Music], [1, Movies], [2, Game]
        for (Product item : items) {
            if (item instanceof Music) {
                count[0]++;
            } else if (item instanceof Movie) {
                count[1]++;
            } else if (item instanceof Game) {
                count[2]++;
            }
        }
        for (int i : count) {
            if (i < 2) {
                return false;
            }
        }
        return true;
    }
    private double calculateDiscountedPrice() {
    	StockableProduct prod = new StockableProduct();
    	double totalPrice = calculatePriceWithoutDiscount();
        double discountedPrice = totalPrice;
        if (isFullHouseDiscountAvailable()) { 
            double fullHouseDiscount = totalPrice * 0.5;
            discountedPrice = Math.min(totalPrice, discountedPrice - fullHouseDiscount); 
        }
        else {
        Map<Class<? extends Product>, Integer> itemCounts = new HashMap<>();
        for (Product item : items) {
            Class<? extends Product> itemClass = item.getClass();
            itemCounts.put(itemClass, itemCounts.getOrDefault(itemClass, 0) + 1);
        } 

        //double totalPrice = 0;
        /*for (Product item : items) {
            totalPrice += item.getPrice();
        }*/
 
        // Calculate discounts
        for (Map.Entry<Class<? extends Product>, Integer> entry : itemCounts.entrySet()) {
            int count = entry.getValue();
            if (count >= 2) {
                double lowestPrice = Double.MAX_VALUE;
                for (Product item : items) {
                    if (item.getClass() == entry.getKey()) {
                        if (item.getDiscount() < lowestPrice) {
                            lowestPrice = item.getDiscount();
                        }
                    }
                }
                System.out.println(lowestPrice);
                totalPrice -= lowestPrice;
                System.out.println(totalPrice);
                return totalPrice;
            }
            }
        }

        // Apply 50% discount for buying two items from each category
        /*if (itemCounts.size() == 3 && itemCounts.values().stream().allMatch(count -> count >= 2)) {
            totalPrice *= 0.5;
        }*/
        return totalPrice;
    }
 
     
 
    public String getInvoice() {
        StringBuilder invoice = new StringBuilder();
        invoice.append("Date - ").append(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm:ss"))).append("\n");
        for (Product item : items) {
            invoice.append("Name: ").append(item.getName()).append(", Price: ").append(item.getPrice()).append("\n");
            StockableProduct rmv;
            rmv = (StockableProduct) item;
            rmv.removeStock(1);
        }
        invoice.append("\nTotal Price: ").append(calculatePriceWithoutDiscount());
        invoice.append("\nPrice after discount: ").append(calculateDiscountedPrice());
        return invoice.toString();
    }
}

