package model.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalary;

	private Department department;//ele pertence a um departamento
	private List<HourContract> contracts = new ArrayList<>();//ele pertence a vários contratos 
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	//Fazer e desfazer a associação
	public void addContract(HourContract contract) { //Adiciona esse contrato  na lista
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	//Saber quanto ele ganhou em determinado mês
	public double income(int month, int year) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
	for(HourContract c : contracts) {
		cal.setTime(c.getDate());
		int c_year = cal.get(Calendar.YEAR); //Veficiando se são as mesmas datas
		int c_month = 1 + cal.get(Calendar.MONTH);
		if(c_month == month && c_year == year) {
			sum += c.totalValue();
		}
	}
		return sum;
	}
}