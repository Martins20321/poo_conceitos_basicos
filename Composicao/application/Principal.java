package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.enums.WorkerLevel;
import model.entities.Department;
import model.entities.HourContract;
import model.entities.Worker;

public class Principal {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		
		try {
		List <Worker> list = new ArrayList<>();
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int number = sc.nextInt();
		for(int i = 1; i <= number; i ++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double vpH  = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract hc1 = new HourContract(contractDate, vpH, hours);
			worker.addContract(hc1);
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/yyyy): ");
		Date monthYear = sdf2.parse(sc.next());
		
		//Convertendo usando o calendario
		Calendar cal = Calendar.getInstance();
		cal.setTime(monthYear);
		int month = 1 + cal.get(Calendar.MONTH);
		int year  = cal.get(Calendar.YEAR);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthYear + ": " + String.format("%.2f",worker.income(month, year)));
		}
		catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
