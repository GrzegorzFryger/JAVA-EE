package logic;

import logic.loancalculatorinterface.InstallmentFixedCalculator;

import static java.lang.Math.pow;

public  class CalculatorFixedInstallment implements InstallmentFixedCalculator{


    public double calculateFixedInstallment(int quantityInstallments, double amount, double interest, double fixedFree) {

        return calculateCapitalInstallment(quantityInstallments, amount, interest) + calculateInstallmentInterest(amount, interest) + fixedFree;

    }

    public double calculateCapitalInstallment(int numberInstallments, double amount, double interest) {
        double p = calculateInterest(interest);
        return (amount * p) / (pow((1 + p), numberInstallments) - 1);
    }

    public double calculateInstallmentInterest(double amount, double interest) {
        return amount * calculateInterest(interest);
    }


    private double calculateInterest(double interest) {
        return ((1.0 / 12.0 * interest)) / 100.0;
    }


}