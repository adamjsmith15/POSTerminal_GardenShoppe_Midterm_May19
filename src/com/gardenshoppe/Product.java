package com.gardenshoppe;

public class Product {

	private String name;
	private Categories cat;
	private String description;
	private double price;

	public Product() {

	}

	public Product(String name, String category, String description, double price) {

		this.name = name;
		// this.category = category;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Categories getCategory() {
	return cat;
	}
	 public void setCategory(Categories category) {
	 this.cat = category;
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
		String format = "%-10s %-10s %-10s $%-10,.2f";
		return String.format(format, name, cat, description, price);
	}

}
