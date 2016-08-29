package easp.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EASPInvoice {
	
	private ArrayList<EASPPosition> positions;
	private int customerID;
	private double totalPrice;
	private String date;
	private int id;

	public EASPInvoice(int customerID, ArrayList<EASPPosition> positions) {
		this.id = 0;
		this.positions = positions;
		this.customerID = customerID;
		this.totalPrice = this.computeTotalPrice();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		this.date = formatter.format(currentTime);
	}

	private double computeTotalPrice() {
		double price = 0.0;
		for (int i = 0; i < this.positions.size(); i++) {
			price += positions.get(i).getPrice();
		}
		return price;
	}
	
	public int getID(){
		return this.id;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public double getPrice() {
		return this.totalPrice;
	}

	public String getDate() {
		return this.date;
	}

}
