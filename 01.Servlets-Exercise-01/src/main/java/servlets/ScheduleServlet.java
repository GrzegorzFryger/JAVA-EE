package servlets;



import logic.CalculatorDescendingInstallment;
import logic.CalculatorFixedInstallment;
import logic.GeneratorLoanSchedule;
import logic.generatorloanscheduleinterface.IGeneratorLoanSchedule;
import model.DataForm;
import model.ScheduleRepayments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;



@WebServlet("/schedule")
public class ScheduleServlet extends HttpServlet {

    private IGeneratorLoanSchedule<ScheduleRepayments,DataForm> gen;
    private DataForm dataForm;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

      HttpSession session = req.getSession();

       this.dataForm = (DataForm)  session.getAttribute("data");
       this.gen = new GeneratorLoanSchedule(new CalculatorDescendingInstallment(),new CalculatorFixedInstallment());



        req.setAttribute("schedule", gen.generateSchedule(dataForm));

        session.setAttribute("schedule",gen.generateSchedule(dataForm));
        req.getRequestDispatcher("/WEB-INF/schedule.jsp").forward(req,resp);



    }


}








