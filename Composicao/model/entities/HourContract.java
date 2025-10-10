package model.entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private double valorPerHour;
	private int hours;

	public HourContract() {

	}

	public HourContract(Date date, double valorPerHour, int hours) {
		super();
		this.date = date;
		this.valorPerHour = valorPerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValorPerHour() {
		return valorPerHour;
	}

	public void setValorPerHour(double valorPerHour) {
		this.valorPerHour = valorPerHour;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double totalValue() {
		return valorPerHour * hours;
	}
	
}
