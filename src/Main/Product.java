package Main;
//import java.io.*;
//import java.util.*;
abstract class Product {
    private String name;
    private int productId;
    private double price;
    private String genre;
    private int yearPublished;
    private double discount;
     
    public Product() {
    	
    }
    public Product(String name, int productId, double price, String genre, int yearPublished, double discount) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getDiscount() {
        return discount;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId=" + productId +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", yearPublished=" + yearPublished +
                ", discount=" + discount +
                '}';
    }
}