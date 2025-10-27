package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Assinatura {

    private int numero;
    private LocalDate dataInicio;
    private double valorMensal;

    private List<Fatura> faturas= new ArrayList<>();

    public Assinatura(){

    }

    public Assinatura(int numero, LocalDate dataInicio, double valorMensal) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.valorMensal = valorMensal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public void addFatura(Fatura fatura){
        faturas.add(fatura);
    }

    public void removeFatura(Fatura fatura){
        faturas.remove(fatura);
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

}
