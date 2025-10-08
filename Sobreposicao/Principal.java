package Sobreposicao;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
	
		List<Account> list = new ArrayList<>();
		
		Account y = new SavingsAccount(1023, "Gabriel", 1000.00, 0.01);
		Account z = new BusinessAccount(1024, "Roberto", 1000.00, 500.00);
		Account a = new SavingsAccount(1099, "Pedro", 1000.00, 0.05);
		Account b = new BusinessAccount(9090, "Pedro Lima", 2000.00, 500.00);

		list.add(y);
		list.add(z);
		list.add(a);
		list.add(b);
		
		//Soma de todos os saldos.
		double totalContas = 0.0;
		for(Account acc : list) { //Para cada conta acc da lista{
			totalContas += acc.getBalance();
		}
		 
		System.out.printf("Total Balance: %.2f%n", totalContas);
		
		for(Account acc : list) {
			acc.deposit(10.00);
		}
		for(Account acc : list) {
			System.out.printf("Update balance for account %d: %.2f%n" , acc.getNumber(), acc.getBalance());
		}
		
	}
}
