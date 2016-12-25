package com.example.nguyehai.shoptest5.datas;

public class DataPhone {
	public String name;
	public String color;
	public String size;
	public String model;
	public String price;
	public String condition;
	public String description;
	public String imagelink;

	public DataPhone(String name) {
		this.name = name;
	}
	public DataPhone(String name, String color, String size, String model, String price, String condition, String desctiption, String imagelink) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.model = model;
		this.price = price;
		this.condition = condition;
		this.description = desctiption;
		this.imagelink = imagelink;
	}
/*
	public static ArrayList<DataPhone> getUsers() {
		ArrayList<DataPhone> dataForiPhones = new ArrayList<DataPhone>();
		dataForiPhones.add(new DataPhone("Harry", "San Diego"));
		dataForiPhones.add(new DataPhone("Marla", "San Francisco"));
		dataForiPhones.add(new DataPhone("Sarah", "San Marco"));
		return dataForiPhones;
	}*/
}
