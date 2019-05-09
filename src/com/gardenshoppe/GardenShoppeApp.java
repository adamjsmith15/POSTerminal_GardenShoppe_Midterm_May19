package com.gardenshoppe;

import java.util.Scanner;



public class GardenShoppeApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Shopper customer = new Shopper();
		String keepShopping = "y";

		// Greet Customer
		System.out.println("Welcome to The Garden Shoppe!");
		System.out.println("-----------------------------");

		// Get Customer Name
				//String name = Validator.getLine(scan, "Please enter your name: ");
				
				
		while (keepShopping.equalsIgnoreCase("y")) {
			//System.out.println(customer.shopCustomer(customer);
			System.out.println("Testing");
			
			System.out.print("\nContinue shopping? (y/n): ");
			keepShopping = scan.next();
		}
			
		//System.out.println("\n" + customer);
		System.out.println("\nThanks for shopping at The Garden Shoppe!");
		
		
		
		scan.close();
	}

}
