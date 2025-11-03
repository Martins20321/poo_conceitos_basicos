package application;

import model.services.BrazilInterestService;
import model.services.InterestService;
import model.services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int month = sc.nextInt();

        InterestService UiS = new BrazilInterestService(2.0);
        double payment =  UiS.payment(amount, month);

        System.out.println("Payment after " + month + " months: ");
        System.out.println(String.format("%.2f", payment));



        sc.close();
    }
}
