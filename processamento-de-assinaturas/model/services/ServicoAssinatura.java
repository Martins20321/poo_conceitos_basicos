package model.services;

import model.entities.Assinatura;
import model.entities.Fatura;

import java.time.LocalDate;

public class ServicoAssinatura {

    private ServicoPagamentoOnline ServicoOnline;

    public ServicoAssinatura(ServicoPagamentoOnline servicoOnline) {
        ServicoOnline = servicoOnline;
    }

    public ServicoPagamentoOnline getServicoOnline() {
        return ServicoOnline;
    }

    public void setServicoOnline(ServicoPagamentoOnline servicoOnline) {
        ServicoOnline = servicoOnline;
    }

    public void processarAssinatura(Assinatura assinatura, int meses){

        double PagamentoBasico = assinatura.getValorMensal();

        for(int i = 1; i <= meses; i ++){

            LocalDate dataVenc = assinatura.getDataInicio().plusMonths(i);

            double juros = ServicoOnline.juros(PagamentoBasico, i);
            double taxaPagamento = ServicoOnline.taxaPagamento(PagamentoBasico);
            double totalTaxas =  PagamentoBasico + juros + taxaPagamento;

            assinatura.addFatura(new Fatura(dataVenc,totalTaxas));
        }
    }

}
