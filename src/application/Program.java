package application;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import entities.Product;
import entities.ImportedProduct;
import entities.UsedProduct;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");		
		
		List<Product> listOfProducts= new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner (System.in);
		Product p;
		System.out.print("Enter the number of products: ");
		int N = s.nextInt();
		
		for(int i=0;i<N;i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch=s.next().charAt(0);
			
			if(ch=='c') {
				System.out.print("Name: ");
				s.nextLine();
				String name=s.nextLine();
				System.out.print("Price: ");
				double price=s.nextDouble();
				p = new Product(name, price);
				listOfProducts.add(p);				
			}
			else if(ch=='i') {
				System.out.print("Name: ");
				s.nextLine();
				String name=s.nextLine();
				System.out.print("Price: ");
				double price=s.nextDouble();
				System.out.print("Customs fee: ");
				double customsFee=s.nextDouble();
				
				//UPCASTING
				p = new ImportedProduct(name, price, customsFee);
				listOfProducts.add(p);				
			}
			else {
				System.out.print("Name: ");
				s.nextLine();
				String name=s.nextLine();
				System.out.print("Price: ");
				double price=s.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(s.next());
				
				//UPCASTING
				p = new UsedProduct(name, price, manufactureDate);
				listOfProducts.add(p);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product product : listOfProducts) {
			System.out.println(product.priceTag());
		}
				
		s.close();
	}
}
