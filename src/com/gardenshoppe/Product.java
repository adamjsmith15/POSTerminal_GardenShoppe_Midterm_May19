package com.gardenshoppe;

import java.util.ArrayList;

public class Product {

	private String name;
	private String category;
	private String description;
	private double price;
	private int quantity;

	public Product() {

	}

	public Product(String name, String category, String description, double price) {

		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	public Product(String name, String category, String description, double price, int quantity) {

		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		System.out.println("1. Add Item to Cart");
		System.out.println("2. View Items in Cart");
		System.out.println("3. Remove Item from Cart");
		System.out.println("4. Checkout");
		System.out.println("5. Quit");
	}

	public void printInventory(ArrayList<Product> inventory) {
		System.out.printf("%-2s %-20s %-20s %-20s %-19s\n", "   ", "Item", "Category" , "Description" , "Price");
		System.out.println("=========================================================================");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.printf("%-2s %s \n",(i + 1), inventory.get(i));
		}

		// TODO should have a formated title for items price descriptions and category
		// TODO this should probably take in a list and the print sysout that list
	}

	@Override
	public String toString() {
		String format = "%-20s %-20s %-20s $%,-20.2f";
		return String.format(format, name, category, description, price);
	}

}
