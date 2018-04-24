package filters;

import domain.LoanParameters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "PersonFilter")
public class PersonFilter implements Filter {
    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        HttpSession session = request.getSession(false);
        Validator val = new Validator();
        Map<String,Boolean> param = new HashMap<>();


        boolean loggedIn = session != null;




        Map<String, String[]> map =   request.getParameterMap();

        for (Map.Entry<String, String[]> entry : map.entrySet())
        {
            for(String obj: entry.getValue())
            {
               if(!val.equalsNull(obj) && !val.isEmpty(obj) && val.isDigit(obj) )
               {
                  param.put(obj,true);
               }
               else
                  param.put(obj,false);
            }
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
