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
	
		
		
		public static BigDecimal calculateSalesTax(SubtotalETC e) {
	        BigDecimal b = new BigDecimal(e.getSubTotal());
	        BigDecimal c = new BigDecimal((1-e.getSalesTax()));
	        
	        e.setGrandTotal(b.multiply(c));
	        return b.multiply(c);
	    }
		
		public static double subTotal(ArrayList<Product> cart, SubtotalETC e) {
			double sum = 0;
			for (int i = 0; i<cart.size(); i++) {
				sum += e.getSubTotal() + (cart.get(i).getPrice() * cart.get(i).getQuantity());
						}
			e.setSubTotal(sum);
			return sum;
		}
		
//		public static double BigDecimal getGrandTotal1() {
//			
//			BigDecimal result = test.add(new BigDecimal(0));
//			System.out.println(result);
//		}
		
//		public static double grandTotal(ArrayList<Product> cart, SubtotalETC e) {
//			return grandTotal;
//		}
		
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



