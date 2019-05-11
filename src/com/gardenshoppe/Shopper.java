package com.gardenshoppe;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopper {

	private String item;
	private double priceInCart;
	private int quantity;
	private double finalTax;

	public void addToCart(ArrayList<Product> cart, Scanner sc, Shopper c, ArrayList<Product> inv, Product P) {
		String continueAdd = "y";
		while(continueAdd.equals("y")) {
			P.printInventory(inv);//display inventory here
			System.out.println();
			int userAdd = Validator.getInt(sc, "Select the item number you would like to purchase: ", 1, 27);
			//used the instance variable of quantity in shopper class
			int num = Validator.getInt(sc, "How many " + inv.get(userAdd -1).getName() + " would you like to add? ");
			setQuantity(num);
			cart.add(new Product(inv.get(userAdd -1).getName(),inv.get(userAdd -1).getCategory(), getQuantity(),
					inv.get(userAdd -1).getPrice()));
			System.out.println("You've entered " + getQuantity() + " " + inv.get(userAdd -1).getName() + " to your shopping cart at "
					+ inv.get(userAdd -1).getPrice()+ " each.");
			continueAdd = Validator.getStringMatchingRegex(sc, "Add more items?(y/n)", "[yYnN]+");
			}
	}

	public void listOfItems(ArrayList<Product> cart) {
		// take in line by line and print what they have in their cart
		System.out.printf("   %-19s %-21s %-19s $%s\n", "Item", "Category", "Quantity", "Price");
		System.out.println("=========================================================================");
		if (!cart.isEmpty()) {
			for (int i = 0; i < cart.size(); i++) {
				System.out.printf("%d. %-20s %-22s %-17d $%.2f %n", i + 1, cart.get(i).getName(),
						cart.get(i).getCategory(), cart.get(i).getQuantity(),
						cart.get(i).getPrice() * cart.get(i).getQuantity());
			}
			System.out.println("=========================================================================");
		} else {
			System.out.println("Cart is empty!");
			System.out.println("=========================================================================");
		}
		System.out.println();

	}

	public void removeFromCart(ArrayList<Product> cart, Scanner sc, Product item) {
		String countinueRemove = "y";
		while (countinueRemove.equals("y")) {
			listOfItems(cart);// display what item in the cart again in order for user to delete items by
								// selecting the item number
			if (!cart.isEmpty()) {
				int userDelete = Validator.getInt(sc, "Select the item number you would like to remove: ", 1,
						cart.size());
				for (int i = 0; i < cart.size(); i++) {
					// find match
					if ((cart.get(userDelete - 1).getName()).equals(cart.get(userDelete - 1).getName())) {
						// if quantity is more than one, ask user how many they wish to remove
						if (cart.get(userDelete - 1).getQuantity() > 1) {
							System.out.println("You have total of " + cart.get(userDelete - 1).getQuantity() + " "
									+ cart.get(userDelete - 1).getName() + "s in your cart.");
							// take in user input
							int num = Validator.getInt(sc, "How many would you like to remove?");
							// reset the quantity for that perticular item according to how many user wants to keep in the cart
							cart.get(userDelete - 1).setQuantity((cart.get(userDelete - 1).getQuantity()) - num);
							break;
						} else {
}
							cart.remove(userDelete - 1);
						break;
						}
					}
				System.out.println("cart has been updated");
			} else {
				System.out.println("Cart is empty!");
			}
			countinueRemove = Validator.getStringMatchingRegex(sc, "Remove more items?(y/n)", "[yYnN]+");
			System.out.println();
		}
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
		String format = "%-10s %-10d %-10d $%,-10.2f";
		return String.format(format, item, priceInCart, quantity, finalTax);
	}
}
