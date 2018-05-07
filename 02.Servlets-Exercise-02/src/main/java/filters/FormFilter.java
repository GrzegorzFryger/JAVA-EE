package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FormFilter")
public class FormFilter implements Filter {
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

        System.out.print(loginURI);


        boolean loggedIn = session != null && session.getAttribute("userData") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);




        if (loggedIn || loginRequest)
        {
            response.sendRedirect(loginURI);

        } else
            {
                chain.doFilter(request, response);
        }

    }
}
