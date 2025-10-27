package model.services;

public class ServicoFastPay implements ServicoPagamentoOnline{

    public static double JUROS = 0.01;
    public static double TAXA_PAGAMENTO = 0.015;

    @Override
    public double juros(double valor, int meses){
        return valor * (JUROS * meses);
    }

    @Override
    public double taxaPagamento(double valor) {
        return valor * TAXA_PAGAMENTO;
    }

}
