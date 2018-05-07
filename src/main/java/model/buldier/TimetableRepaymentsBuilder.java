package model.buldier;

import model.ScheduleRepayments;

public final class TimetableRepaymentsBuilder {
    private int instalmentNumber;
    private double amountCapital;
    private double amountInterest;
    private double fixedFees;
    private double totalAmountInstallmentl;

    private TimetableRepaymentsBuilder() {
    }

    public static TimetableRepaymentsBuilder aTimetableRepayments() {
        return new TimetableRepaymentsBuilder();
    }

    public TimetableRepaymentsBuilder withInstalmentNumber(int instalmentNumber) {
        this.instalmentNumber = instalmentNumber;
        return this;
    }

    public TimetableRepaymentsBuilder withAmountCapital(double amountCapital) {
        this.amountCapital = amountCapital;
        return this;
    }

    public TimetableRepaymentsBuilder withAmountInterest(double amountInterest) {
        this.amountInterest = amountInterest;
        return this;
    }

    public TimetableRepaymentsBuilder withFixedFees(double fixedFees) {
        this.fixedFees = fixedFees;
        return this;
    }

    public TimetableRepaymentsBuilder withTotalAmountInstallmentl(double totalAmountInstallmentl) {
        this.totalAmountInstallmentl = totalAmountInstallmentl;
        return this;
    }

    public ScheduleRepayments build() {
        return new ScheduleRepayments(instalmentNumber, amountCapital, amountInterest, fixedFees, totalAmountInstallmentl);
    }
}
