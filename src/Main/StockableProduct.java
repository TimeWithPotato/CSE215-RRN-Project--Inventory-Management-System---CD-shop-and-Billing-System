package Main;

class StockableProduct extends Product implements Stockable {
    private int numberOfItemsStocked;
    public StockableProduct() {
    	super();
    	numberOfItemsStocked =0;
    }
    public StockableProduct(String name, int productId, double price, String genre, int yearPublished, double discount,int numberOfItemsStocked) {
        super(name, productId, price, genre, yearPublished, discount);
        this.numberOfItemsStocked = numberOfItemsStocked;
    }

    @Override
    public void addStock(int num) {
        numberOfItemsStocked += num;
    }

    @Override
    public void removeStock(int num) {
        numberOfItemsStocked -= num;
    }

    @Override
    public void editStock(int num) {
        numberOfItemsStocked = num;
    }

    public int getNumberOfItemsStocked() {
        return numberOfItemsStocked;
    }

    @Override
    public String getInfo() {
        return "StockableProduct Info: " +
                "Name: " + getName() +
                ", Product ID: " + getProductId() +
                ", Price: " + getPrice() +
                ", Genre: " + getGenre() +
                ", Year Published: " + getYearPublished() +
                ", Discount: " + getDiscount() +
                ", Stocked Items: " + numberOfItemsStocked;
    }

    @Override
    public String toString() {
        return "StockableProduct{" +
                "numberOfItemsStocked=" + numberOfItemsStocked +
                ", " + super.toString() +
                '}';
    }
}

