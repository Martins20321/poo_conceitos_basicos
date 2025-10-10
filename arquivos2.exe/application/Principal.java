package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;

public class Principal {
	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		
		List <Product> list = new ArrayList<>(); 
		
		System.out.println("Enter pile path: ");
		String path = sc.nextLine();
		
		File strpath = new File(path);
		String sourceFolder = strpath.getParent();//Obtendo somente a pasta
		
		System.out.println(sourceFolder);
		
		//Criar dentro da pasta sem o arquivo
		boolean success = new File(sourceFolder + "\\out2").mkdir();		
		
		//Criar o arquivo summary
		String targetFilestr = sourceFolder + "\\out2\\summary2.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){	
		
			String itemCsv = br.readLine();
			while(itemCsv != null) {
				//Para quebrar a virgula
				String [] fields = itemCsv.split(";");
				String name = fields[0];//Pegando os dados nas suas posicoes
				double price = Double.parseDouble(fields[1]); //Fazer a conversao, porque e do tipo string. Por isso o Parse
				int quantity = Integer.parseInt(fields[2]);//Fazer a conversao novamente, com uso do parse
				
				list.add(new Product(name, price, quantity));
				
				itemCsv = br.readLine();
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilestr))){
			
				for(Product item: list) {//Obtendo o item dentro da lista
					bw.write(item.getName() + "," + String.format("%.2f",item.total()));
					bw.newLine();//Quebra de linha
					
				}
				System.out.println(targetFilestr + "Created");
			}
			catch(IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		}
		catch(IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		
		
		
		sc.close();
	}
}
