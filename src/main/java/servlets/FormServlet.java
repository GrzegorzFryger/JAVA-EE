package servlets;

import dao.HSQLDBConnection;
import dao.UserMapperImpl;
import dao.interfaces.ConnectionDB;
import model.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FromServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet
{

    private UserService userService;
    private ConnectionDB con;

    @Override
    public void init() throws ServletException {

        this.con = new HSQLDBConnection();
        this.userService = new UserService(con.getConnection());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        chechForm(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


            forwardToForm(request, response);




    }

    private void forwardToForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String nextJSP = "/WEB-INF/jsp/form.jsp";
        RequestDispatcher dispatcher = null;
        getServletContext().getRequestDispatcher(nextJSP).forward(req, resp);


    }

    private void chechForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> messages = new HashMap<>();

        if( request.getParameter("firstName").isEmpty() || request.getParameter("firstName").length() < 3 )
        {
            messages.put("message", "Imie musi mieć więcej niż 2 litery");
        }

        if(request.getParameter("lastName").isEmpty() || request.getParameter("lastName").length() <3)
        {
            messages.put("message2", "Nazwisko musi być dłuższe niż 2 litery");
        }

        if(request.getParameter("username").isEmpty() || request.getParameter("username").length() < 3)
        {
            messages.put("message3", "nazwa uzytkownika musi byc dłuzsza nic 2 litery");
        }

        if(request.getParameter("password").isEmpty() || request.getParameter("password").length() < 5)
        {
            messages.put("message4", "bledne haslo, musi zawierac wiecej niz 5 liter");
        }
        if(request.getParameter("email").isEmpty() || !request.getParameter("email").contains("@"))
        {
            messages.put("message4", "błedny email");
        }

        if (messages.isEmpty()) {

            HttpSession session = request.getSession(false);

            User user = new User();

            user.setName(request.getParameter("firstName"));
            user.setSurname(request.getParameter("lastName"));
            user.setUserName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setPremium(false);

            userService.add(user);

            System.out.print(user);

            session.setAttribute("userData",user);


            response.sendRedirect("/user");



        }
        else{

            request.setAttribute("messages", messages);
            forwardToForm(request,response);
        }




    }
}

