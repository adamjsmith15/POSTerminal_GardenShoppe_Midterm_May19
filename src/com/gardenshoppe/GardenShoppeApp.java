package com.gardenshoppe;

import java.util.ArrayList;
import java.util.Scanner;



public class GardenShoppeApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Shopper customer = new Shopper();
		Product main = new Product();
		SubtotalETC reg = new SubtotalETC();
		ArrayList<Product> cart = new ArrayList<>();
		ArrayList<Product> inventory = FileIO.readFromFile("itemList.txt");
		int userEntry = -1;

		// Greet Customer
		System.out.println("Welcome to The Garden Shoppe!");
		System.out.println("-----------------------------");

		while (userEntry != 5) {
			main.printMenu();
			userEntry = Validator.getInt(scan, "What would you like to do?", 1, 5);
			switch(userEntry) {
				case 1:
					customer.addToCart(cart, scan, customer, inventory, main);
						break;
				case 2:
						customer.listOfItems(cart);
						break;
				case 3:
						customer.removeFromCart(cart, scan, main);
						break;
				case 4:
//						reg.getSubTotal(cart, reg);
//						reg.calcGrandTotal(reg);
						reg.getPaymentMethod(cart, scan, reg);
						reg.printReceipt(cart, main, reg);
						break;
				case 5:
						System.out.print("Goodbye!");
						break;
			}
		}
		System.out.println("\nThanks for shopping at The Garden Shoppe!");
		scan.close();
	}

}
