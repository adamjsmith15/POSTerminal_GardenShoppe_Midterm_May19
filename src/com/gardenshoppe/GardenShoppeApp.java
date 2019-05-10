package com.gardenshoppe;

import java.util.ArrayList;
import java.util.Scanner;



public class GardenShoppeApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FileIO.createDir("inventory");
		Shopper customer = new Shopper();
		Product main = new Product();
		String keepShopping = "y";
		ArrayList<Product> cart = new ArrayList<>();
		ArrayList<Product> inventory = FileIO.readFromFile("itemList.txt");
		int userEntry = -1;
		System.out.println(inventory.get(0));

		// Greet Customer
		System.out.println("Welcome to The Garden Shoppe!");
		System.out.println("-----------------------------");

		// Get Customer Name
				//String name = Validator.getLine(scan, "Please enter your name: ");
				
				
		while (keepShopping.equalsIgnoreCase("y")) {
			//System.out.println(customer.shopCustomer(customer);
			main.printMenu();
			userEntry = Validator.getInt(scan, "What would you like to do?", 1, 5);
			if (userEntry == 1) {
				// TODO need to get input from user on what they would like to purchase
				// TODO maybe using the nums on the printMenu when that is finished
				customer.addToCart(cart, inventory.get(0), 1);
				
			}else if(userEntry == 2) {
				// TODO nice to have a sysout title either in the main or in the method idc Item, category, description, price
				customer.listOfItems(cart);
			}else if (userEntry == 3) {
				// TODO should print a modified list of the cart with numbers in front of it 
				// then get input from user on what they want to delete and pass that in.
				customer.removeFromCart(cart, inventory.get(0), 1);
			}else if (userEntry == 4) {
				// TODO check out
				// needs to get which payment method and then select the appropriate method to calculate payment
				// and return change 
			}else {
				break;
			}
			
			
			System.out.print("\nContinue shopping? (y/n): ");
			keepShopping = scan.next();
		}
			
		//System.out.println("\n" + customer);
		System.out.println("\nThanks for shopping at The Garden Shoppe!");
		
		
		
		scan.close();
	}

}
