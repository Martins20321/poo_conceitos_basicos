package application;

import model.entites.AbstractShape;
import model.entites.Circle;
import model.entites.Rectangle;
import model.enums.Color;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AbstractShape s1 = new Circle(Color.GREEN, 2.0);
        AbstractShape s2 = new Rectangle(Color.RED, 3.0, 4.0);

        System.out.println("Circle color: " + s1.getColor());
        System.out.println("Circle area: " + String.format("%.2f",s1.area()));
        System.out.println("Rectangle color: " + s2.getColor());
        System.out.println("Rectangle area: " + s2.area());


        sc.close();
    }
}
