package Refaz1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employee: ");
		int n = sc.nextInt();
		for( int i = 1; i <= n; i ++) {
			System.out.print("Employee #" + i + "data:");
			System.out.print("Outsourced (y/n)?");
			char c = sc.next().charAt(0);
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Hours: ");
			int h = sc.nextInt();
			System.out.println("Value per hour:");
			double valueHour = sc.nextDouble();
			if( c == 'y') {
				System.out.println("Additional charge:");
				double adicional = sc.nextDouble();
				Employee f1 = new OutsourcedEmployee(name, h, h, h);
				list.add(f1);
			}
			else {
				Employee f2 = new Employee(name, h, h);
				list.add(f2);
			}
			
		}
		
		System.out.println();
		System.out.println("PAGAMENTS:");
		for (Employee f1: list) {
			System.out.println(f1.getName() + " - $ "  + String.format("%.2f", f1.payment()));
		}
		
		
		
		sc.close();
	}
}
