package servlets;


import model.DataForm;
import model.TypeOfInstallments;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "FormServlet",
        urlPatterns = {"/"})
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("option1", TypeOfInstallments.DECREASING);
        request.setAttribute("option2", TypeOfInstallments.FIXED);
        request.getRequestDispatcher("/WEB-INF/formloandata.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Map<String, String> messages = new HashMap<>();

        if(!isDigit(request.getParameter("amountofcredit")) || request.getParameter("amountofcredit").equals("0") )
        {
           messages.put("message", "niepoprawna kwota dla kwoty");
        }

         if(!isDigit(request.getParameter("numberofinstallment")) || request.getParameter("numberofinstallment").equals("0"))
        {
            messages.put("message2", "niepoprawna kwota dla ilosci rat");
        }

        if(!isDigit( request.getParameter("interest")) || request.getParameter("interest").equals("0"))
        {
            messages.put("message3", "niepoprawna kwota dla oporcentowania");
        }

        if(!isDigit(request.getParameter("fixedfree")))
        {
            messages.put("message4", "niepoprawna kwota dla oplat stalych");
        }

        if (messages.isEmpty()) {

            DataForm data = new DataForm();
            data.setAmountOfCredit(request.getParameter("amountofcredit"));
            data.setNumberOfInstallments(request.getParameter("numberofinstallment"));
            data.setInterest(request.getParameter("interest"));
            data.setFixedFree(request.getParameter("fixedfree"));
            data.setTypeOfInstallments(TypeOfInstallments.valueOf(request.getParameter("typeofinstallments")));



                request.getSession().setAttribute("user", "user");
                request.getSession().setAttribute("data", data);

                response.sendRedirect(request.getContextPath() + "/schedule");



        }



        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/formloandata.jsp").forward(request, response);
    }

    private Boolean isDigit(String text)
    {

        try {

            Double.parseDouble(text);
            return true;



        } catch (Exception e) {

            return false;
        }
    }
}
