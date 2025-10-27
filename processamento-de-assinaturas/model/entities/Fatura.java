package model.entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fatura {

    DateTimeFormatter fmt1 =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dataVencimento;
    private double valor;

    public Fatura(LocalDate dataVencimento, double valor) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){
        return getDataVencimento().format(fmt1) + " - " + String.format("%.2f", valor);
    }
}
