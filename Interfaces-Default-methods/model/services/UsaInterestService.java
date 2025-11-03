package model.services;

public class UsaInterestService implements InterestService{

    private double interestrate;

    public UsaInterestService(double interestrate) {
        this.interestrate = interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    @Override
    public double getInteresRate() { //Para pegar a taxa
        return interestrate;
    }
}
