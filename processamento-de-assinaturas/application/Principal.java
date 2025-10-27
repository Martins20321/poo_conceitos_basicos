package application;

import model.entities.Assinatura;
import model.entities.Fatura;
import model.services.ServicoAssinatura;
import model.services.ServicoFastPay;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados da assinatura:");
        System.out.print("Número: ");
        int numero = sc.nextInt();
        System.out.print("Data de início: ");
        LocalDate dateInicio = LocalDate.parse(sc.next(), fmt1);
        System.out.print("Valor mensal: ");
        double valorMensal = sc.nextDouble();

        Assinatura assinatura = new Assinatura(numero, dateInicio,valorMensal);

        System.out.print("Número de meses: ");
        int meses = sc.nextInt();

        ServicoAssinatura servico  = new ServicoAssinatura(new ServicoFastPay());
        servico.processarAssinatura(assinatura, meses);

        System.out.println();
        System.out.println("FATURAS: ");
        for (Fatura fatura : assinatura.getFaturas()){
            System.out.println(fatura);
        }

        sc.close();
    }

}
