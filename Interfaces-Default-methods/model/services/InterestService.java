package model.services;

import java.security.InvalidParameterException;

public interface InterestService {

    public double getInteresRate();
        default double payment(double amount, int month){
            if(month < 1){
                throw new InvalidParameterException("Months must be greater than zero");
            }
            return amount * Math.pow(1.0 + getInteresRate() / 100.0, month);
        }
    }
