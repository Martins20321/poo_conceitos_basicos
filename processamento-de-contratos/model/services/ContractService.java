package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public OnlinePaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int month){

        double basicQuota = contract.getTotalValue()/month;

        for(int i = 1; i <= month; i ++){
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = paymentService.interest(basicQuota, i);
            double fee =  paymentService.paymentFee(basicQuota + interest);
            double totalQuota = basicQuota + interest + fee;

            contract.addInstallment(new Installment(dueDate, totalQuota));
        }

    }

}
