package Main;

public class Game extends StockableProduct {
	
	private String developer;
	
//------------constructor-------------------------------	
	public Game(String name, int productId, double price, String genre, int yearPublished, double discount, int numberOfItemsStocked, String developer) {
		super(name,productId,price,genre,yearPublished,discount,numberOfItemsStocked);
		this.developer = developer;
	}
	

//------------Getters and Setters-------------------
    public  String GettersOfGame() {
    	return developer;
    }
    
    public void SettersOfGame(String developer) {
    	this.developer = developer;
    }
    
 
//---------------------toString()---------------------
   @Override
   public String toString() {
	   return " Developer: " + developer;
   }
   
   
//------------------definition of getInfo()------------------
   
   public String getInfo() {

	   return super.getInfo()+ this.toString();
   }
}
