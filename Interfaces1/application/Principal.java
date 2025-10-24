package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import javax.smartcardio.CardTerminal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do Aluguel");
        System.out.print("Modelo do Carro: ");
        String carModel = sc.nextLine();

        Vehicle v1 = new Vehicle(carModel);

        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt1);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt1);

        CarRental cRental = new CarRental(start, finish, v1);

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService Rentalservice = new RentalService(new BrazilTaxService(), pricePerHour, pricePerDay);

        Rentalservice.processInvoice(cRental);

        System.out.println("FATURA:");
        System.out.println("Pagamento Básico: $" + String.format("%.2f",cRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: $" + String.format("%.2f",cRental.getInvoice().getTax()));
        System.out.println("Pagamento total: $" + String.format("%.2f",cRental.getInvoice().totalPayment()));

        sc.close();
    }
}
