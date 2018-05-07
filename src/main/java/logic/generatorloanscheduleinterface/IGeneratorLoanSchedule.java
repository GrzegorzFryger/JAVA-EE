package logic.generatorloanscheduleinterface;

import model.TypeOfInstallments;

import java.util.List;

public interface IGeneratorLoanSchedule <T,E >
{

    public List <T> generateSchedule (E dataForm);
}
