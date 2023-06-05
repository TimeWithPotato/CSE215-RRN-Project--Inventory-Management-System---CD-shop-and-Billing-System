package Main;

public class Movie extends StockableProduct {
	private String director;
	

//-----------------constructor----------------
	public Movie(String name, int productId, double price, String genre, int yearPublished, double discount, int numberOfItemsStocked, String director) {
		super(name,productId,price,genre,yearPublished,discount,numberOfItemsStocked);
		this.director = director;
	}
	
	//------------Getters and Setters ---------------
		public String getDirector() {
			return director;
		}
		
		public void SettersOfMovie(String director) {
			this.director = director;
		}
		
		
	//---------------------toString()-----------------
		@Override
		public String toString() {
			return " Director : " + director ;
		}
		
		
	//-----------------------getInfo()-----------------
		public String getInfo() {
			return super.getInfo() + this.toString();
		}
		

}
