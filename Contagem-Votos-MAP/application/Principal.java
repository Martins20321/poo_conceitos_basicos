package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {

        String path = "C:\\arquivos java\\exer.arquivos\\MAP-Exercício\\map.txt.txt";

        Map<String, Integer> contagem = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line !=null ){

                String[] fields = line.split(",");
                String name = fields[0];
                int votos = Integer.parseInt(fields[1]);

                if(contagem.containsKey(name)){
                    votos += contagem.get(name);
                }

                contagem.put(name, votos);
                line = br.readLine();
            }

            for(String s : contagem.keySet()){
                System.out.println(s  + ": " + contagem.get(s));
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
