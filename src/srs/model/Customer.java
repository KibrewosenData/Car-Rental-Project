package srs.model;

public class Customer {
	private String firstName;
	private String lastNName;
	private String drivLicNum;
	private Car car;
	private int carID;
	
	public Customer(String firstName, String lastNName, String drivLicNum, int carID) {
		super();
		this.firstName = firstName;
		this.lastNName = lastNName;
		this.drivLicNum = drivLicNum;
		this.carID=carID;
		car =new Car();
		//this.carVID = carVID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastNName() {
		return lastNName;
	}
	public String getDrivLicNum() {
		return drivLicNum;
	}
	public Car getCar() {
		return car;
	}
	public String getCarVID() {
		return car.getVIN();
	}


}
