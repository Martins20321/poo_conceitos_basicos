package model.entities;

import model.services.Printer;
import model.services.Scanner;

public class ComboDevice extends Device implements Scanner, Printer {

    public ComboDevice(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("Combo Printing: " + doc);
    }

    @Override
    public void print(String doc) {
        System.out.println("Combo processing" + doc);
    }

    @Override
    public String Scan() {
        return "Combo scan result";
    }
}
