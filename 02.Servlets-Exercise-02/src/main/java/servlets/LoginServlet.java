package servlets;

import dao.HSQLDBConnection;
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

@WebServlet(name = "LoginServlet",
        urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

   private UserService userService;
   private ConnectionDB con;


    @Override
    public void init() throws ServletException {

        this.con = new HSQLDBConnection();
        this.userService = new UserService(con.getConnection());


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        controlUser(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {





            forwardToLogin(request, response);





    }




    private void forwardToLogin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String nextJSP = "/WEB-INF/jsp/login.jsp";
        RequestDispatcher dispatcher = null;
        getServletContext().getRequestDispatcher(nextJSP).forward(req, resp);


    }


    private void controlUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);


        User user;
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        if (!userService.searchByEmail(email).isEmpty()) {

            if (userService.searchByEmail(email).containsKey(password))
            {
                user = userService.getById(userService.searchByEmail(email).get(password));

                session.setAttribute("userData",user);


                response.sendRedirect("/user");


            } else {

                request.setAttribute("message", "błedne hasło ");
                forwardToLogin(request, response);
                }

        } else {

            request.setAttribute("message", "nie ma takiego uzytkownika");
            forwardToLogin(request, response);
        }

    }





}


