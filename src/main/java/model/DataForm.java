package model;

public class DataForm
{
    private double amountOfCredit;
    private int numberOfInstallments;
    private double interest;
    private double fixedFree;
    private TypeOfInstallments typeOfInstallments;





    public double getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(String amountOfCredit) {
        this.amountOfCredit = this.parraseToDouble(amountOfCredit);
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(String numberOfInstallments) {
        this.numberOfInstallments = this.parraseToInt(numberOfInstallments);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = this.parraseToDouble(interest);
    }

    public double getFixedFree() {
        return fixedFree;
    }

    public void setFixedFree(String fixedFree) {
        this.fixedFree =this.parraseToDouble( fixedFree);
    }

    public TypeOfInstallments getTypeOfInstallments() {
        return typeOfInstallments;
    }

    public void setTypeOfInstallments(TypeOfInstallments typeOfInstallments) {
        this.typeOfInstallments = typeOfInstallments;
    }

    private double parraseToDouble (String text) {

        try {

            return Double.parseDouble(text);

        } catch (Exception e) {

            return 0.0;
        }
    }

    private int parraseToInt (String text) {

        try {

            return Integer.parseInt(text);

        } catch (Exception e) {

            return 0;
        }
    }
}
