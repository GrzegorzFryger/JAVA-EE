package logic.loancalculatorinterface;



public interface InstallmentFixedCalculator {
    public double calculateFixedInstallment(int quantityInstallments, double amount, double interest, double fixedFree);

    public double calculateCapitalInstallment(int numberInstallments, double amount, double interest);

    public double calculateInstallmentInterest(double amount, double interest);
}
