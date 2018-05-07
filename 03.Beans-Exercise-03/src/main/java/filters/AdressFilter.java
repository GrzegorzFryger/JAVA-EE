package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "AdressFilter")
public class AdressFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        Map<String,Boolean> param = new HashMap<>();
        Validator val = new Validator();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null;


        try
        {

            if(!val.isEmpty(request.getParameter("name")) && request.getParameter("name").length() > 3)
            {
                param.put(request.getParameter("name"),true);

            }
            else {
                param.put(request.getParameter("name"),false);
            }

            if (!val.isEmpty(request.getParameter("surname")) && request.getParameter("surname").length() > 3)
            {
                param.put(request.getParameter("surname"),true);
            }
            else {
                param.put(request.getParameter("surname"),false );
            }

            if ( request.getParameter("pesel").length() == 11 && !val.isEmpty(request.getParameter("pesel")) )
            {
                param.put(request.getParameter("pesel"),true );
            }
            else {
                param.put(request.getParameter("pesel"),false );
            }

        }
        catch (NullPointerException e)
        {

        }




        if (loggedIn && !param.containsValue(false) && !param.isEmpty() )
        {
            chain.doFilter(request, response);

        } else
        {
            response.sendRedirect("/");

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
