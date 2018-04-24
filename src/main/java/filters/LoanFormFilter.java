package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "LoanFormFilter")
public class LoanFormFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {

        Map<String,Boolean> param = new HashMap<>();
        Validator val = new Validator();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null;


        try
        {
            if(!val.isEmpty(request.getParameter("city")) && !val.isEmpty(request.getParameter("street")))
            {
                param.put(request.getParameter("city"),true);
                param.put(request.getParameter("street"),true);

                System.out.print("1");
            }
            else {
                param.put(request.getParameter("city"),false);
                param.put(request.getParameter("street"),false);
            }

            if (val.isDigit(request.getParameter("housenumber")) && !val.equalsNull(request.getParameter("housenumber")) )
            {
                param.put(request.getParameter("housenumber"),true);
                System.out.print("2");
            }
            else
                param.put(request.getParameter("housenumber"),false);

            if (val.isDigit(request.getParameter("phonenumber")) && request.getParameter("phonenumber").length() == 9 )
            {
                param.put(request.getParameter("phonenumber"),true);
                System.out.print("3");
            }

            else
                param.put(request.getParameter("phonenumber"),false);



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
