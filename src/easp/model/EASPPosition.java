package easp.model;

public class EASPPosition {

	private EASPInvoice parentInvoice;

	private int position;
	private int amount;
	private String title;
	private String article;
	private String unit;
	private double pricePerUnit;
	private double price;
	
	public EASPPosition (int position){
		this.position = position;
	}

	public EASPInvoice getParentInvoice() {
		return parentInvoice;
	}

	public void setParentInvoice(EASPInvoice parentInvoice) {
		this.parentInvoice = parentInvoice;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
