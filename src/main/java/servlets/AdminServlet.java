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
import java.util.List;


@WebServlet(
        name = "AdminServlet",
        urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

   private  ConnectionDB connection;
   private  UserService userService;



    @Override
    public void init() throws ServletException {

        this.connection = new HSQLDBConnection();
        userService = new UserService(this.connection.getConnection());


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User data = (User) session.getAttribute("userData");
        request.setAttribute("user",data);

        updatePremiumForUser(request,response);

        request.setAttribute("message","Uprawnienia zmienione ");
        request.setAttribute("userList",userService.getAll());

        forwardListUser(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession(false);
        User data = (User) session.getAttribute("userData");






        request.setAttribute("userList",userService.getAll());
        request.setAttribute("user",data);

        forwardListUser(request,response);

    }


    protected void forwardListUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nextJSP = "/WEB-INF/jsp/admin.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("userList", this.userService.getAll());
        dispatcher.forward(req, resp);
    }

    protected void updatePremiumForUser (HttpServletRequest request, HttpServletResponse response)
    {


        Long id = Long.valueOf(request.getParameter("idUser"));
        Boolean premium = Boolean.valueOf(request.getParameter("action"));

        User user = userService.getById(id);
        user.setPremium(premium);

        this.userService.update(user);


    }
}
