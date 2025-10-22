package model.entities;

import javax.management.RuntimeErrorException;

import model.Exceptions.BusinessException;

public class Account {
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	
	//Tratando as excessoes
	private void validateWithdraw(double amount) {
		if(amount > withdrawLimit ) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		}	//throw está repassando para o String da classe criada
		if(amount > balance) {
			throw new BusinessException("Erro de saque : Saldo insuficiente");
		}
	}
}
