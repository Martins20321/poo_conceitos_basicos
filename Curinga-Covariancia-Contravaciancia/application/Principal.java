package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1, 9, 12, 14);
        List<Double> myDoubles = Arrays.asList(90.1, 32.3, 130.1);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printList(myObjs);
        System.out.println();
        copy(myDoubles, myObjs);
        printList(myObjs);
    }
    public static void copy(List<? extends Number> source, List<? super Number> destiny){
       for(Number number : source){
           destiny.add(number);
       }
    }

    public static void printList(List<?> list){
        for(Object obj : list){
            System.out.println(obj);
        }
    }
}
