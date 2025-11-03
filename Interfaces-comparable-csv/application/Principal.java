package application;

import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        String path = "C:\\arquivos java\\exer.arquivos\\in.txt2.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String employeeCsv = br.readLine();
           while(employeeCsv != null){
               String [] fields = employeeCsv.split(","); // Para pegar dentro da String e fazer separadamente
               list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
               employeeCsv =  br.readLine();
           }
            Collections.sort(list);
            for(Employee emp : list){
                System.out.println(emp.getName() + " , " + emp.getSalary());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
