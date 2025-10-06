package application1;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;

	import entities.Reservation;

	public class Principal {
		public static void main(String[] args) throws ParseException {
			
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Room number:");
			int n = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			Date ckin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date ckout = sdf.parse(sc.next());
			
			if(! ckout.after(ckin)) {
				System.out.println("Error in Reservatio: Check-out date must be after check-in date");
			}
			else {
				Reservation reserva = new Reservation(n, ckin, ckout);
				System.out.println("Reservation: " + reserva);
				
				System.out.println("Enter data to update the reservation:");
				System.out.print("Check-in date (dd/MM/yyyy):");
				ckin = sdf.parse(sc.next());
				System.out.print("Check-out date (dd/MM/yyyy):");
				ckout = sdf.parse(sc.next());
				
				Date now = new Date();
				if(ckin.before(now) || ckout.before(now)) {
					System.out.println("Error in reservation: Reservation dates for update must be future dates!!!!");
				}
				else if(! ckout.after(ckin)) {
					System.out.println("Error in Reservatio: Check-out date must be after check-in date");
				}
				
				else {
					reserva.updateDates(ckin, ckout);
					System.out.println("Reservation: " + reserva);
				}
			}
		
			
			
			
		
			
			
			
			
			sc.close();
		}
	}
