package model.services;

public interface ServicoPagamentoOnline {

    public double juros(double valor, int meses);
    public double taxaPagamento(double valor);
}
