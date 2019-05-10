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
			//System.out.println(customer.shopCustomer(customer);
			main.printMenu();
			System.out.println();
			userEntry = Validator.getInt(scan, "What would you like to do?", 1, 5);
			System.out.println();
			if (userEntry == 1) {
				main.printInventory(inventory);
				System.out.println();
				int userAdd = Validator.getInt(scan, "Select the item number you would like to purchase: ", 1, 27);
				customer.addToCart(cart, scan, customer, inventory.get(userAdd-1));
				
			}else if(userEntry == 2) {
				customer.listOfItems(cart);
			}else if (userEntry == 3) {
				// TODO should print a modified list of the cart with numbers in front of it 
				int userDelete = Validator.getInt(scan, "Select the item number you would like to remove: ", 1, cart.size());
				customer.removeFromCart(cart, cart.get(userDelete -1));
			}else if (userEntry == 4) {
				
				double subT = reg.subTotal(cart, reg);
				
				reg.getPaymentMethod(scan, reg.calculateGrandTotal(reg));
				reg.printReceipt(cart, main, reg);
				// TODO needs to print receipt
				break;
			}else {
				break;
			}
		}
			
		//System.out.println("\n" + customer);
		System.out.println("\nThanks for shopping at The Garden Shoppe!");
		
		
		
		scan.close();
	}

}
