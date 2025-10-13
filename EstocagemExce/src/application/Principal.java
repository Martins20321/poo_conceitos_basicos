package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Product;
import model.exception.StockException;

public class Principal {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("Informe os dados do produto:");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Digite o preço do produto: ");
		double price = sc.nextDouble();
		System.out.print("Digite a quantidade inicial em estoque: ");
		int quantity = sc.nextInt();
		
		Product pro1 = new Product(name, price, quantity);
		
		//Informações do produto
		System.out.println();
		System.out.println("Produto cadastrado com sucesso:");
		System.out.print(pro1 + "Quantidade : " + pro1.getQuantity());
		System.out.println();
		
		//Movimentaçõoes de estoque
		System.out.println();
		System.out.print("Quantas unidades você deseja adicionar ao estoque? ");
		int amount = sc.nextInt();
		pro1.addStock(amount);
		
		System.out.println("Estoque atualizado: " + pro1 + "Quantidade: " + pro1.getQuantity());
		
		//Atualização de preço
		System.out.println();
		System.out.print("Digite o novo preço: ");
		price = sc.nextInt();
		pro1.updatePrice(price);
		
		System.out.println("Estoque atualizado: " + pro1 + "Quantidade:" + pro1.getQuantity());
		
		//Vendas
		System.out.println();
		System.out.println("Quantas unidades você deseja vender? ");
		amount = sc.nextInt();
		pro1.removeStock(amount);
		
		System.out.println();
		System.out.println("Estoque atualizado: " + pro1 + "Quantidade: " + pro1.getQuantity());
		}
		
		catch(StockException e) {
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Erro de inserção : Por favor insira um número válido");
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado, tente novamente");
		}
		sc.close();
	}
}
