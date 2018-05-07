package logic;

import logic.generatorloanscheduleinterface.IGeneratorLoanSchedule;
import logic.loancalculatorinterface.InstallmentDescendingCalculator;
import logic.loancalculatorinterface.InstallmentFixedCalculator;
import model.DataForm;
import model.ScheduleRepayments;
import model.buldier.TimetableRepaymentsBuilder;
import model.TypeOfInstallments;

import java.util.ArrayList;
import java.util.List;

public class GeneratorLoanSchedule implements IGeneratorLoanSchedule<ScheduleRepayments,DataForm> {
    private InstallmentDescendingCalculator cacDes;
    private InstallmentFixedCalculator cacFix;


    public GeneratorLoanSchedule(InstallmentDescendingCalculator cacDes, InstallmentFixedCalculator cacFix) {
        this.cacDes = cacDes;
        this.cacFix = cacFix;
    }


    @Override
    public List<ScheduleRepayments> generateSchedule(DataForm dataForm)
    {
        List<ScheduleRepayments> temp = new ArrayList<>();



        if (dataForm.getTypeOfInstallments().equals(TypeOfInstallments.DECREASING))
        {

            for (int i = 1; i <= dataForm.getNumberOfInstallments(); i++)
        {
            ScheduleRepayments a =  TimetableRepaymentsBuilder.aTimetableRepayments().withInstalmentNumber(i)
                    .withAmountCapital(cacDes.calculateCapitalInstallment(dataForm.getNumberOfInstallments(),dataForm.getAmountOfCredit()))
                    .withAmountInterest(cacDes.calculateInstallmentInterest(dataForm.getNumberOfInstallments(),dataForm.getAmountOfCredit(),dataForm.getInterest(),i))
                    .withFixedFees(dataForm.getFixedFree())
                    .withTotalAmountInstallmentl(cacDes.calculateDescendingInstallment(i,dataForm.getNumberOfInstallments(),dataForm.getAmountOfCredit(),dataForm.getInterest(), dataForm.getFixedFree()))
                    .build();




            temp.add(a);
        }

        }

        if (dataForm.getTypeOfInstallments().equals(TypeOfInstallments.FIXED))
        {
            for (int i = 1; i <= dataForm.getNumberOfInstallments(); i++)
            {
                ScheduleRepayments a =  TimetableRepaymentsBuilder.aTimetableRepayments()
                        .withInstalmentNumber(i)
                        .withAmountCapital(cacFix.calculateCapitalInstallment(dataForm.getNumberOfInstallments(),dataForm.getAmountOfCredit(),dataForm.getInterest()))
                        .withAmountInterest(cacFix.calculateInstallmentInterest(dataForm.getAmountOfCredit(),dataForm.getInterest()))
                        .withFixedFees(dataForm.getFixedFree())
                        .withTotalAmountInstallmentl(cacFix.calculateFixedInstallment(dataForm.getNumberOfInstallments(),dataForm.getAmountOfCredit(),dataForm.getInterest(),dataForm.getFixedFree()))
                        .build();




                temp.add(a);
            }

        }

        return temp;
    }
}
