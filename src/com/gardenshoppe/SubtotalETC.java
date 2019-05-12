package com.gardenshoppe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class SubtotalETC {

	private double price;
	private double salesTax = 0.06;
	private double subTotal;
	private BigDecimal grandTotal;

	public void getPaymentMethod(ArrayList<Product> cart, Scanner sc, SubtotalETC e) {
		calcSubTotal(cart, e);
		System.out.println("Your grand total today is: " + calcGrandTotal(e));
		System.out.println("How would you like to pay for this?\n1.  Cash \n2.  Credit \n3.  Check\n");
		int userEntry = Validator.getInt(sc, "", 1, 3);
		if (userEntry == 1) {
			BigDecimal cash = payWithCash(sc);
			BigDecimal change = cash.subtract(calcGrandTotal(e));
			System.out.println("Your change is " + change);

		} else if (userEntry == 2) {
			payWithCreditCard(sc);
		} else {
			payWithCheck(sc);
		}

	}

	public void calcSubTotal(ArrayList<Product> cart, SubtotalETC e) {
		double sum = 0;
		for (int i = 0; i < cart.size(); i++) {
			sum += cart.get(i).getPrice() * cart.get(i).getQuantity();
		}
		e.setSubTotal(sum);
		System.out.println("Your sub total today is:" + e.getSubTotal());
	}

	public BigDecimal calcGrandTotal(SubtotalETC e) {
		double sales = e.getSubTotal();
		double tax = e.getSalesTax();
		BigDecimal b = new BigDecimal(Double.toString(sales));
		BigDecimal c = new BigDecimal(Double.toString(tax));
		BigDecimal grandT = b.multiply(c).add(b);
		return grandT;
	}

	public static BigDecimal payWithCash(Scanner sc) {
		double cash = Validator.getDouble(sc, "How much cash are we receiving?");
		BigDecimal money = new BigDecimal(cash);
		return money;
	}

	public static String payWithCreditCard(Scanner sc) {
		String creditCard = Validator.creditCardValidator(sc, "Please enter your credit card number: ");
		String expiration = Validator.getCreditCardExpiration(sc, "Enter credit card expiration date:");
		String cVV = Validator.getCVV(sc, "Enter CVV number:");
		return creditCard + "\n" + expiration + "\n" + cVV;
	}

	public static int payWithCheck(Scanner sc) {
		int checkNumber = Validator.getInt(sc, "Please enter your check nubmer");
		return checkNumber;
	}

	public void printReceipt(ArrayList<Product> list, Product p, SubtotalETC e) {
		String format = "%-20s %-20d %.2f \n";
		System.out.println();
		System.out.println("Below is your receipt: ");
		System.out.printf("%-15s %-10s %20s %n", "Item Name", "Item Quantity", "Item Price ");
		System.out.println("===========================================================");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(format, list.get(i).getName(), list.get(i).getQuantity(),
					list.get(i).getQuantity() * list.get(i).getPrice());
		}
		System.out.println("===========================================================");

		System.out.println("Subtotal: " + getSubTotal());
		System.out.printf("Tax: %.2f %n", getSubTotal() * e.getSalesTax());
		System.out.println("Grand total: " + calcGrandTotal(e));// because this one used BigDecimal class, so it has 3
																// decimal
	}

	public double getPrice() {
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
