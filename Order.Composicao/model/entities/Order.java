package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;

	private Client client; // Pertence a UM cliente
	private List<OrderItem> items = new ArrayList<>(); // TEM VÁRIOS itens pedidos

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//Invés de utilizar o set
	public void addItems(OrderItem item) {
		items.add(item);
	}
	
	public void removeItems(OrderItem item) {
		items.remove(item);
	}
	
	//Valortotal = Soma dos Subtotais
	public double total() {
		double sum = 0.0;
		for(OrderItem it : items) {
			sum += it.subTotal();
		}
		return sum;//Tudo vai estar armzenado nela
	}
	
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("Order moment: " + sdf2.format(moment) + "\n");
		sb.append("Order status: " + status);
		sb.append("Client: " + client.getName());
		sb.append(" " + sdf1.format(client.getBirthDate()));
		sb.append(" - " + client.getEmail() + "\n");
		sb.append("Order items: \n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}
