package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScheduleRepayments {
    private int instalmentNumber;
    private double amountCapital;
    private double amountInterest;
    private double fixedFees;
    private double totalAmountInstallmentl;


    public ScheduleRepayments(int instalmentNumber, double amountCapital, double amountInterest, double fixedFees, double totalAmountInstallmentl) {
        this.instalmentNumber = instalmentNumber;
        this.amountCapital = amountCapital;
        this.amountInterest = amountInterest;
        this.fixedFees = fixedFees;
        this.totalAmountInstallmentl = totalAmountInstallmentl;
    }

    public int getInstalmentNumber() {
        return instalmentNumber;
    }

    public void setInstalmentNumber(int instalmentNumber) {
        this.instalmentNumber = instalmentNumber;
    }

    public double getAmountCapital() {
        return new BigDecimal(amountCapital).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setAmountCapital(double amountCapital) {
        this.amountCapital = amountCapital;
    }

    public double getAmountInterest() {
        return new BigDecimal(amountInterest).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setAmountInterest(double amountInterest) {
        this.amountInterest = amountInterest;
    }

    public double getFixedFees() {
        return fixedFees;
    }

    public void setFixedFees(double fixedFees) {
        this.fixedFees = fixedFees;
    }

    public double getTotalAmountInstallmentl() {
        return new BigDecimal(totalAmountInstallmentl).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setTotalAmountInstallmentl(double totalAmountInstallmentl) {
        this.totalAmountInstallmentl = totalAmountInstallmentl;
    }


    @Override
    public String toString() {
        return "ScheduleRepayments{" +
                "instalmentNumber=" + instalmentNumber +
                ", amountCapital=" + amountCapital +
                ", amountInterest=" + amountInterest +
                ", fixedFees=" + fixedFees +
                ", totalAmountInstallmentl=" + totalAmountInstallmentl +
                '}';
    }


}
