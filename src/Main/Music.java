package Main;

public class Music extends StockableProduct {
	private String artistName;
	
//-------------Constructor------------------
	
	public Music(String name, int productId, double price, String genre, int yearPublished, double discount, int numberOfItemsStocked, String artistName) {
		super(name,productId,price,genre,yearPublished,discount,numberOfItemsStocked);
		this.artistName = artistName;
	}
	
//------------Getters and Setters ---------------
	public String GettersOfMusic() {
		return artistName;
	}
	
	public void SettersOfMusic(String artistName) {
		this.artistName = artistName;
	}
	
	
//---------------------toString()-----------------
	@Override
	public String toString() {
		return " Artist Name: " + artistName;
	}
	
	
//-----------------------getInfo()-----------------
	public String getInfo() {
		return super.getInfo() + this.toString();
	}
	

}
