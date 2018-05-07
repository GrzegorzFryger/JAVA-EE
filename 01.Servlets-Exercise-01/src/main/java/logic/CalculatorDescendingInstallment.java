package logic;

import logic.loancalculatorinterface.InstallmentDescendingCalculator;
import logic.loancalculatorinterface.InstallmentFixedCalculator;

import static java.lang.Math.pow;

public class CalculatorDescendingInstallment implements InstallmentDescendingCalculator
{

    public double calculateDescendingInstallment(int numberInstallment,int quantityInstallments, double amount, double interest, double fixedFree) {

        return calculateCapitalInstallment(quantityInstallments,amount) + calculateInstallmentInterest(quantityInstallments,amount,interest,numberInstallment) + fixedFree;

    }

    public double calculateCapitalInstallment(int quantityInstallments, double amount) {

        return amount/quantityInstallments;
    }

    public double calculateInstallmentInterest(int quantityInstallments, double amount, double interest, int numberInstallment) {

        return (calculateCapitalInstallment(quantityInstallments, amount)
                * (1.0 + (quantityInstallments - numberInstallment + 1.0 )* calculateInterest(interest)))- calculateCapitalInstallment(quantityInstallments,amount) ;
    }

    private double calculateInterest(double interest) {
        return ((interest/100.00)/12);
    }



}
