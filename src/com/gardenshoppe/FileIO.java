package com.gardenshoppe;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



public class FileIO {
	Scanner sc =  new Scanner(System.in);
	String fileName = "src/com/gardenshoppe/itemList.txt";
	//creat itemList file
	public static void creatAFile(String fileName) {
		
		Path path = Paths.get(fileName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully!");
			} catch (IOException e) {

				System.out.println("OOPS! Something went wrong. Contact somebody!");
			}
		} else {
			System.out.println("The file already exists");

		}
	}
	//write all products to the file(store owner use only)
	public static void writeToAFile(Scanner sc) {
		Product p = null;
		String fileName = "src/com/gardenshoppe/itemList.txt";
		Path path = Paths.get(fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			String countinue = "y";
			while (countinue.equalsIgnoreCase("y")) {
				p = new Product(Validator.getString(sc, "Enter the product name: "),
								Validator.getString(sc, "Enter the item catagory: "), //bugs
								Validator.getString(sc, "Enter the description: "),
								Validator.getDouble(sc, "Enter product price: "));
				output.println(p.getName() + "," + p.getCategory() + ", "
								+ p.getDescription() + "," + p.getPrice());
				countinue = Validator.getStringMatchingRegex(sc, "Add more?(y/n)", "[yYnN ]+");
			} 
		} catch (FileNotFoundException e) {
			System.out.println("Yoooo, I don't know what's going on -- contact someone!");
		} finally {
			output.close();
	}
	}
	
	//write the file with user items in their chart(including create a chartFile and display the list)
	public static void writeChartToAFile(ArrayList<Product> list) {
		Product p = null;
		String fileName = "src/chartList.txt";
		creatAFile(fileName); 
		Path path = Paths.get(fileName);

		File file = path.toFile();
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			for(int i = 0; i < list.size(); i++) {
				output.println(list.get(i));
			}
			
			for(Product pp: list) {
				System.out.println(pp);
			}
			
			readFromFile(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Yoooo, I don't know what's going on -- contact someone!");
		} finally {
			output.close();
	}
	}

	public static ArrayList<Product> readFromFile(String fileName) {
		ArrayList<Product> productList = new ArrayList<>();
		
		Path filePath = Paths.get("inventory",fileName);

		File f = filePath.toFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();

			while (line != null) {
				String[] arr = line.split(",");
				// TODO need to either make category a string and not search by it or add conditional logic
				// to determine what category and assign it to arr[1]
				productList.add(new Product(arr[0], arr[1], arr[2], Double.parseDouble(arr[3])));
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found...");

		} catch (IOException e) {
			System.out.println("Something crazy happened -- call someone who can help!");

		}
//		for(int i = 0; i < productList.size(); i++ ) {	
//			System.out.println((i+1 + " " + productList.get(i)));
//		}
		return productList;
	}
	
	public static void createDir(String path) {
		String dirPath = path;

		Path folder = Paths.get(dirPath);

		if (Files.notExists(folder)) {
			try {
				Files.createDirectories(folder);
				System.out.println("Folder was created successfully");
			} catch (IOException e) {
				System.out.println("I don't know");
			}
		} else {
			System.out.println("Folder already exists.");
		}
	}

}

