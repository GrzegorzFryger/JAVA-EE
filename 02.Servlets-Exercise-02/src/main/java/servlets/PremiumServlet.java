package servlets;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PremiumServlet",urlPatterns = {"/premium"})
public class PremiumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        User data = (User) session.getAttribute("userData");


        request.setAttribute("user",data);
            forwardToPremium(request,response);
    }

    private void forwardToPremium(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String nextJSP = "/WEB-INF/jsp/premium.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
}
