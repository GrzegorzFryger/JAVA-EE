package filters;

import junit.framework.TestCase;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AdminFilterTest {

    HttpServletRequest request ;
    HttpServletResponse response;
    HttpSession session;
    FilterChain filterChain ;
    User user;
    AdminFilter adminFilter;
   // UserService userService;

    @Before
    public void setUp() throws Exception
    {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        filterChain = mock(FilterChain.class);
        session = mock(HttpSession.class);
        user = mock(User.class);

        adminFilter= new AdminFilter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void do_Filter_Test_Correct_Forward() throws ServletException, IOException {

        //when
        when(user.getAdmin()).thenReturn(false);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userData")).thenReturn(user);

        //then
        adminFilter.doFilter(request, response,
                filterChain);



        //check
        verify(response).sendRedirect("/user");




    }
    @Test
    public void do_Filter_Test_Correct_Forward_Negative() throws ServletException, IOException {



        //when

        when(user.getAdmin()).thenReturn(true);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userData")).thenReturn(user);

        //then

        adminFilter.doFilter(request, response,
                filterChain);


        //check
        verify(filterChain).doFilter(any(),any());




    }
}