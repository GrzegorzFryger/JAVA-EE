package logic.loancalculatorinterface;


public interface InstallmentDescendingCalculator {

    public double calculateDescendingInstallment(int numberInstallment,int quantityInstallments, double amount, double interest, double fixedFree);

    public double calculateCapitalInstallment(int quantityInstallments, double amount);

    public double calculateInstallmentInterest(int quantityInstallments, double amount, double interest, int numberInstallment);

    
}
