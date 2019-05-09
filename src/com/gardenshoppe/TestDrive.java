package com.gardenshoppe;

import java.util.ArrayList;

public class TestDrive {
	public static void main(String[] args) {
		String fileName = "itemList.txt";
		FileIO f = new FileIO();
//		f.creatAFile();
//		f.writeToAFile();
//		f.readFromFile();
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product("Somebody", "dashjkasd","haksjdhas", 5.64));
		f.writeChartToAFile(list);
	}
}
