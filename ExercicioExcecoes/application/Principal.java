package application;

import java.util.Scanner;

import model.Exceptions.BusinessException;
import model.entities.Account;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Informe os dados da conta:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Saldo Inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc1 = new Account(number, name, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar:");
		double amount = sc.nextDouble();
		acc1.withdraw(amount);
		System.out.println("Novo saldo: " + acc1.getBalance());
		}
		catch(BusinessException e) {
			System.out.println(e.getMessage()); //Pega a mensagem armazenada na excessao
		}
		catch(RuntimeException e) { 
			System.out.print("Erro inesperado, Tente novamente");
		} //Casos genéricos
		
		sc.close();
	}
}
