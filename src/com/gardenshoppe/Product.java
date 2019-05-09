package com.gardenshoppe;

public class Product {

	private String name;
	private String category;
	private String description;
	private double price;

	public Product() {

	}

	public Product(String name, String category, String description, double price) {

		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public String getCategory() {
	 return category;
	 }
	 public void setCategory(String category) {
	 this.category = category;
	 }
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void printMenu() {

	}

	@Override
	public String toString() {
		String format = "%-10s %-10s %-10s $%-10.2f";
		return String.format(format, name, category, description, price);//fix me
	}

}
