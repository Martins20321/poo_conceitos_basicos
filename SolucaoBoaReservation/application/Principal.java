package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Reservation;
import model.exception.DomainException;

public class Principal {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
			try {
			System.out.print("Room number:");
			int n = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			Date ckin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date ckout = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(n, ckin, ckout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			ckin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			ckout = sdf.parse(sc.next());
			
			reservation.updateDates(ckin, ckout);
				System.out.println("Reservation: " + reservation);
			}
			catch(ParseException e) {
				System.out.println("Invalid date format");
			}
			catch(DomainException e) {
				System.out.println( e.getMessage());
			}
			catch(RuntimeException e) {
				System.out.println("Unexpected error");
			}
		sc.close();
	}
}
