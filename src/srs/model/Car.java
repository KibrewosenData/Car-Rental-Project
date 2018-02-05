package srs.model;

public class Car {
	private String barnd;
	private String VIN;
	private String type;
	private String catagory;
	private double price ;
	public Car(String barnd, String vIN, String type, String catagory, double price) {
		super();
		this.barnd = barnd;
		VIN = vIN;
		this.type = type;
		this.catagory = catagory;
		this.price = price;
	}
	public Car(){
		
	}
	public String getBarnd() {
		return barnd;
	}
	public String getVIN() {
		return VIN;
	}
	public String getType() {
		return type;
	}
	public String getCatagory() {
		return catagory;
	}
	public double getPrice() {
		return price;
	}
	
	

}
