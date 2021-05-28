package medipharmacyservice;

import java.sql.Date;

public class Pharmacy {
	String Name;
	String expireDate;
	double price;
	private final static String MEDICINELISTCSV = "D:/csv/medicine/listMedicine.csv";
	//private final static String AVAILABLEMEDICINECSV = "D:/csv/medicine/availableMedicine.csv";
	
	
	public Pharmacy(String name,  String expireDate, double price) {
		super();
		Name = name;
		this.expireDate = expireDate;
		this.price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public static String getMedicinescsv() {
		return MEDICINELISTCSV;
	}
	public String toString() {
		return Name + " ,"  + expireDate + " , " + price ;
	}
	
	
	

}
