package Main;

public class Driver {
	public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Music m1 = new Music("Submarine", 1, 20, "Indie", 2011, 10, 100, "Alex Tumer");
        Music m2 = new Music("AM", 2, 10, "Indie", 2013, 5.5, 10, "Arctic Monkeys");
        Music m3 = new Music("Tranquility Base Hotel and Casino", 3, 23, "Indie", 2018, 7.5, 500, "Arctic Monkeys");
        Music m5 = new Music("Abbey Road", 5, 25, "Rock", 1969, 7.8, 5, "The Beatles");
        Music m4 = new Music("Rust in Peace", 4, 33, "Metal", 1990, 2.5, 10, "Megadeath");
        Music m6 = new Music("The Dark Side of the Moon", 6, 35, "Progressive Rock", 1973, 2.5, 10, "Pink Floyd");

        Movie v1 = new Movie("Good Will Hunting", 7, 12, "Drama", 1997, 5.4, 123, "Gus Van Sant");
        Movie v2 = new Movie("Life Is Beautiful", 8, 20, "Comedy-Drama", 1997, 2.6, 126, "Roberto Benigni");
        Movie v3 = new Movie("What's eating gilbert grape", 9, 20, "Drama", 1993, 6.4, 122, "Lasse Hallström");
        Movie v4 = new Movie("The Godfather", 10, 15, "Crime", 1972, 10, 125, "Francis Ford Coppola");
        Movie v5 = new Movie("The Rainmanker", 11,5,"Crime", 1997, 12, 127, "Francis Ford Coppola");
        Movie v6 = new Movie("Apocalyspe Now",12 , 24, "Drama", 1979, 4.9, 121, "Francis Ford Coppola");
        Movie v7 = new Movie("Leon the Professional", 13, 21, "Drama", 1994, 2.7, 124, "Luc Besson");
        
        Game g1 = new Game("Red Dead Redemption 2", 14, 29, "Survival", 2018, 3.7, 560, "Rockstar");
        Game g2 = new Game("God of War", 15, 12, "Action" , 2018, 5.6, 567, "Javaground");
        Game g3 = new Game("Grand Theft Auto V " , 16, 13, "Action", 2017, 2.3, 565, "Rockstar");
        
        inventory.addItem(m1);
        inventory.addItem(m2); 
        inventory.addItem(m3);
        inventory.addItem(m4);
        inventory.addItem(m5);
        inventory.addItem(m6);
        inventory.addItem(v1);
        inventory.addItem(v2);
        inventory.addItem(v3);
        inventory.addItem(v4);
        inventory.addItem(g1);
        inventory.addItem(g2);
        inventory.addItem(g3);

       System.out.println("Inventory:");
        for (StockableProduct item : inventory) {
            System.out.println(item.getInfo());
        }
        System.out.println("\nSorting by price:");
        inventory.sortByPrice();
        for (StockableProduct item : inventory) {
            System.out.println(item.getInfo());
        }



        Invoice invoice = new Invoice();
        invoice.addProduct(m1);
        invoice.addProduct(m2);
        invoice.addProduct(v1);
        invoice.addProduct(v2);
        invoice.addProduct(g1);
       

        System.out.println("\nInvoice:");
        System.out.println(invoice.getInvoice());
         
        
        
        Invoice invoice_1 = new Invoice();
        invoice_1.addProduct(m1);
        invoice_1.addProduct(m2);
        invoice_1.addProduct(v1);
        invoice_1.addProduct(v2);
        invoice_1.addProduct(g1);
        invoice_1.addProduct(g2);
         
        System.out.println("\nSorting by available stock:");
        inventory.sortByAvailableStock();
        for (StockableProduct item : inventory) {
            System.out.println(item.getInfo());
            System.out.println();
        }
        
    	System.out.println("Available games:");
    	for (StockableProduct item : inventory) {
    	    if (item instanceof Game) {
    	        System.out.println(item.getInfo());
    	    }
    	}
    	System.out.println();
    	
    	double minPrice = Double.MAX_VALUE;
    	Music cheapestAlbum = null;
    	for (StockableProduct item : inventory) {
    	    if (item instanceof Music && item.getNumberOfItemsStocked() > 0 && item.getPrice() < minPrice) {
    	        minPrice = item.getPrice();
    	        cheapestAlbum = (Music) item;
    	    }
    	}
    	if (cheapestAlbum != null) {
    	    System.out.println("Cheapest Music Album:");
    	    System.out.println("Name: " + cheapestAlbum.getName() + ", Price: " + cheapestAlbum.getPrice());
    	}
    	System.out.println();
    	
    	// Task 3: Find all movies directed by "Francis Ford Coppola"
    	System.out.println("Movies directed by Francis Ford Coppola:");
    	for (StockableProduct item : inventory) {
    	    if (item instanceof Movie && item.getNumberOfItemsStocked() > 0 && ((Movie) item).getDirector().equals("Francis Ford Coppola")) {
    	        System.out.println(item.getInfo());
    	        System.out.println();
    	    }
    	}
    	
    	System.out.println("Currently available numberOfItemsStocked of each sold product:");
    	for (StockableProduct item : inventory) {
    	    System.out.println(item.getName() + ": " + item.getNumberOfItemsStocked());
    	    System.out.println();
    	}
    	
    	
	} 

}
 
