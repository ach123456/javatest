package org.abhilash.java.bean;

public class VehicalType{
	int id;
	String Truck;
	String car;	
	String bike;
	
	
	public VehicalType() {
		super();
	}
	public VehicalType(int id, String truck, String car, String bike) {
		super();
		this.id = id;
		this.Truck = truck;
		this.car = car;
		this.bike = bike;
	}
	public String getTruck() {
		return Truck;
	}
	public void setTruck(String truck) {
		Truck = truck;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getBike() {
		return bike;
	}
	public void setBike(String bike) {
		this.bike = bike;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}