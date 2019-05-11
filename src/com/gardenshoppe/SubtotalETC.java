package com.gardenshoppe;

	import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
//import java.util.Formatter.BigDecimalLayoutForm;
	import java.util.Scanner;

	public class SubtotalETC {
	 
		
		private double price; 
		private double salesTax = 0.06; 
		private double subTotal;
		private BigDecimal grandTotal;
	
		
		
		public static BigDecimal calculateGrandTotal(SubtotalETC e) {
	        BigDecimal b = new BigDecimal(e.getSubTotal());
	        BigDecimal c = new BigDecimal((e.getSalesTax()));
	        
	        BigDecimal total = b.add(b.multiply(c));
	        e.setGrandTotal(total);
	        System.out.printf("Your total today is $%.2f \n", total);
	        return total;
	    }
		
		public static double subTotal(ArrayList<Product> cart, SubtotalETC e) {
			double sum = 0;
			for (int i = 0; i<cart.size(); i++) {
				sum += e.getSubTotal() + (cart.get(i).getPrice() * cart.get(i).getQuantity());
						}
			e.setSubTotal(sum);
			return sum;
		}
		public void getPaymentMethod(Scanner sc, BigDecimal tot) {
			System.out.println("How would you like to pay for this?");
			System.out.println("1.  Cash");
			System.out.println("2.  Credit");
			System.out.println("3.  Check");
			int userEntry = Validator.getInt(sc, "", 1, 3);
			if(userEntry == 1) {
				BigDecimal cash = payWithCash(sc);
				BigDecimal change = cash.subtract(tot);
				System.out.printf("Your change is $%.2f \n", change);
				
			}else if(userEntry == 2) {
				payWithCreditCard(sc);
			}else {
				payWithCheck(sc);
			}
			
		}
		
		public static BigDecimal payWithCash(Scanner sc) {
			double cash = Validator.getDouble(sc, "How much cash are we receiving?");
			BigDecimal money = new BigDecimal(cash);
			return money;
		}
		
		public static String payWithCreditCard(Scanner sc) {
			String creditCard = Validator.creditCardValidator(sc, "Please enter your credit card number: ");
			
			return creditCard;
			
		}
		
		public static int payWithCheck(Scanner sc) {
			int checkNumber = Validator.getInt(sc, "Please enter your check nubmer");
			return checkNumber;
		}
		
		public void printReceipt(ArrayList<Product> list, Product p, SubtotalETC e) {
	        String format = "%-20s %-20d %.2f \n";
	        System.out.printf("%-15s %-10s %20s %n", "Item Name", "Item Quantity", "Item Price ");
	        System.out.println("===========================================================");
	        for(int i = 0; i < list.size(); i++) {
	            System.out.printf(format, list.get(i).getName(), list.get(i).getQuantity(), 
	                    list.get(i).getQuantity()*list.get(i).getPrice());
	        }
	        System.out.println("===========================================================");
	        
	        System.out.printf("Subtotal: %.2f \n", e.getSubTotal()); //send a Arraylist for that method; it returns a subtotal
	        System.out.printf("Tax: %.2f \n", e.getSubTotal() * (e.getSalesTax());
	        System.out.printf("Grandtotal: %.2f \n", e.getGrandTotal());
	    }
		public  double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getSalesTax() {
			return salesTax;
		}

		public void setSalesTax(double salesTax) {
			this.salesTax = salesTax;
		}

		public double getSubTotal() {
			return subTotal;
		}

		public void setSubTotal(double subTotal) {
			this.subTotal = subTotal;
		}

		public BigDecimal getGrandTotal() {
			return grandTotal;
		}

		public void setGrandTotal(BigDecimal grandTotal) {
			this.grandTotal = grandTotal;
		}

		public SubtotalETC() {
		
		}

		public SubtotalETC(double price, double salesTax, double subTotal, BigDecimal grandTotal, double bigDecimal) {
			super();
			this.price = price;
			this.salesTax = salesTax;
			this.subTotal = subTotal;
			this.grandTotal = grandTotal;
			
		}
		
		
		
		
		}



