package application;

import model.entities.ComboDevice;
import model.entities.ConcretePrinter;
import model.entities.ConcreteScanner;

public class Principal {
    public static void main(String[] args) {

        ConcretePrinter p = new ConcretePrinter("1080");

        p.processDoc("My letter");
        p.print("My letter");

        ConcreteScanner s = new ConcreteScanner("2020");

        System.out.println();
        s.processDoc("My email");

        System.out.println("Scan result: " + s.Scan());

        ComboDevice c1 = new ComboDevice("3030");

        System.out.println();
        c1.processDoc("My dissertation");
        c1.print("My dissertation");
        System.out.println("Scann result: " + c1.Scan());

    }
}
