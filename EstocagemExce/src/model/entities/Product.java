package model.entities;

import model.exception.StockException;

public class Product {
	private String name;
	private double price;
	private int quantity;
	
	public Product() {
		
	}

	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//Adicionando itens no estoque
	public void addStock(int amount) {
		quantity += amount;
	}
	
	//Removendo itens do estoque
	public void removeStock(int amount) {
		if(amount > quantity) { //Vendendo mais do que tem em estoque
			throw new StockException("Erro de venda: Não há itens suficientes em estoque.");
		}
		else {
		quantity -= amount;
		}
	}
	
	public void updatePrice(double price) {
		if(price <= 0) {
			throw new StockException("Erro em atualização de preço: o preço deve ser maior que zero");
		}
		else {
			this.price = price;	
		}
	}
	
	public String toString() {
		return "Nome: " + getName() + "| $ " + String.format("%.2f",getPrice()) + " | "; 
	}
}
