package model.services;

public class BrazilInterestService implements InterestService{

    private double interestrate;

    public BrazilInterestService(double interestrate) {
        this.interestrate = interestrate;
    }


    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    @Override
    public double getInteresRate() { //Pegando a taxa por cada país, não podendo ser um default method
        return interestrate;
    }

}
