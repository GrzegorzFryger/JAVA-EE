package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")

public class AdminFilter implements Filter {
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig)
            throws ServletException {

        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/user";

        User temp;
        boolean loggedIn;




       try {

           temp = (User)session.getAttribute("userData");
           loggedIn = session != null && temp.getAdmin().equals(true);

       }catch (NullPointerException e)
       {
           loggedIn = false;
       }



        boolean loginRequest = request.getRequestURI().equals(loginURI);


        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }
}
