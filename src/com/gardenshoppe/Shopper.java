package com.gardenshoppe;

import java.util.ArrayList;


public class Shopper {
	
	private String item;
	private double priceInCart;
	private int quantity;
	private double finalTax;
		
	public static void listOfItems(ArrayList<Product> cart){
		//take in line by line and print what they have in their cart
		for(int i = 0; i < cart.size(); i++) {
		 System.out.println(cart.get(i));
		}
	}
	

	public void addToCart(ArrayList<Product> cart, Product item, int quantity) {
	 cart.add(item);
	 System.out.println("You've entered " + item.getName() + " to your shopping cart at " + item.getPrice());
	 
}
	public void removeFromCart(ArrayList<Product> cart , Product item, int quantity) {
		for(int i = 0; i < cart.size(); i++) {
		cart.indexOf(item);
		if(cart.contains(item)) {
			cart.remove(i);
			System.out.println("You've removed " + item.getName() + " from your shopping cart at " + item.getPrice());
		} else { 
			continue;
		}
		
			
		} System.out.println("cart has been updated");
	}
	
	
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getPriceInCart() {
		return priceInCart;
	}
	public void setPriceInCart(double priceInCart) {
		this.priceInCart = priceInCart;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getFinalTax() {
		return finalTax;
	}
	public void setFinalTax(double finalTax) {
		this.finalTax = finalTax;
	}
	public Shopper() {
		super();
	}
	public Shopper(String item, double priceInCart, int quantity, double finalTax) {
		super();
		this.item = item;
		this.priceInCart = priceInCart;
		this.quantity = quantity;
		this.finalTax = finalTax;
	}
	@Override
	public String toString() {
		return "Shopper item=" + item + ", priceInCart=" + priceInCart + ", quantity=" + quantity + ", finalTax="
				+ finalTax;
	}
}
