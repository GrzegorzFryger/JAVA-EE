package dao;

import junit.framework.TestCase;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class AbstractMapperTest  {

    //Real object
    User user;
    AbstractMapper abstractMapper;

    //Mock Object
    @Mock
    Connection connection;

    @Mock
    PreparedStatement preparedStatement;
    @Mock
    ResultSet resultSet;
    @Mock
    ResultSet resultSet2;




    @Before
    public void setUp() throws Exception
    {
        user = new User();
        user.setId(Long.valueOf(1));
        user.setAdmin(true);
        user.setEmail("test@email.com");
        user.setName("Grzgorz");
        user.setPassword("test");
        user.setPremium(true);
        user.setSurname("Kowalski");
        user.setUserName("testuser");

        MockitoAnnotations.initMocks(this);

        abstractMapper = mock(AbstractMapper.class, withSettings()
                .useConstructor(connection).defaultAnswer(CALLS_REAL_METHODS));

    }



    @Test
    public void getOne() throws SQLException {
        when(abstractMapper.findStatement()).thenReturn("Sql stmt String");
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        doNothing().when(preparedStatement).setLong(anyInt(),anyInt());

        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        when(resultSet.getLong(1)).thenReturn((long)1,(long)2);
        when(abstractMapper.doLoad(resultSet)).thenReturn(user);


        assertEquals(user,abstractMapper.getOne((long) 1));






    }

    @Test
    public void getAll() throws SQLException {
        when(abstractMapper.findStatementAll()).thenReturn("Sql stmt String");
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        doNothing().when(preparedStatement).setLong(anyInt(),anyInt());

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true,true,false);
        when(resultSet.getLong(1)).thenReturn((long)1,(long)1);
        when(abstractMapper.doLoad(resultSet)).thenReturn(user,user);


        List<User> tempList = new ArrayList<>();

        tempList.add(user);
        tempList.add(user);




        assertEquals(tempList,abstractMapper.getAll());
        Mockito.verify(abstractMapper,times(1)).doLoad(resultSet);


    }

    @Test
    public void deleteOne() {
    }

    @Test
    public void persistAdd() {
    }

    @Test
    public void persistUpdate() {
    }

    @Test
    public void load() {
    }

    @Test
    public void clearMap() {
    }
}