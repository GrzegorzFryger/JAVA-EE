package dao;



import model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class UserMapperImpl extends AbstractMapper<User>
{

    private static final String COLUMNS = "ID,NAME,SURNAME,USERNAME,PASSWORD,EMAIL,PREMIUM,ADMIN";
    public static final String FIND_STM = "SELECT " + COLUMNS + " FROM USERS WHERE id=?";
    public static final String FIND_ALL_STM = "SELECT " + COLUMNS + " FROM USERS ";
    public static final String INSERT_STM = "INSERT INTO USERS(NAME,SURNAME,USERNAME,PASSWORD,EMAIL,PREMIUM) VALUES(?,?,?,?,?,?)";
    public static final String UPDATE_STM = "UPDATE USERS SET NAME =?,SURNAME =?, USERNAME =?,PASSWORD=?, EMAIL = ?, PREMIUM = ? WHERE id=?";
    public static final String DELETE_STM = "DELETE FROM USERS WHERE id=?";
    public static final String FIND_EMAIL_STM = "SELECT ID, PASSWORD FROM USERS WHERE EMAIL=?";

    private static final String USERTABLE = "CREATE TABLE USERS" +
            "(" +
            "  ID       INTEGER PRIMARY KEY NOT NULL IDENTITY," +
            "  NAME     VARCHAR(50)," +
            "  SURNAME  VARCHAR(50)," +
            "  USERNAME VARCHAR(50)," +
            "  PASSWORD VARCHAR(50)," +
            "  EMAIL    VARCHAR(50)," +
            " PREMIUM BOOLEAN,  "+
            " ADMIN BOOLEAN "+
            ")";

    public UserMapperImpl(Connection connection)
    {
        super(connection);
        checkExistingTable(connection);


    }

    protected void checkExistingTable(Connection connection)
    {
        DatabaseMetaData dbm = null;
        ResultSet tables = null;

        try {
            dbm = connection.getMetaData();
          tables  = dbm.getTables(null, null, "USERS", null);

            if (!tables.next())
            {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(USERTABLE);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public Map<String,Long> searchByEmail(String email)
    {
        Map<String,Long> map = new HashMap<>();

        PreparedStatement findStatement = null;

        try {

            findStatement = connection.prepareStatement(FIND_EMAIL_STM);
            findStatement.setString(1, email);
            ResultSet rs = findStatement.executeQuery(); //
            rs.next();

            map.put(rs.getString("PASSWORD"),rs.getLong("ID"));

        } catch (SQLException e) {

            System.out.println(e.getErrorCode() + "Nie ma takiej wartości");

        }

        return map;

    }

    @Override
    protected String findStatement()
    {
        return FIND_STM;
    }

    @Override
    protected String findStatementAll() {
        return FIND_ALL_STM;
    }


    @Override
    protected String insertStatement()
    {
        return INSERT_STM ;
    }

    @Override
    protected String updateStatement()
    {
        return UPDATE_STM ;
    }

    @Override
    protected String removeStatement()
    {
        return DELETE_STM;
    }

    @Override
    protected void parametrizeInsertStatement(PreparedStatement statement, User entity) throws SQLException
    {

        statement.setString(1,entity.getName());
        statement.setString(2,entity.getSurname());
        statement.setString(3,entity.getUserName());
        statement.setString(4,entity.getPassword());
        statement.setString(5,entity.getEmail());
        statement.setBoolean(6,entity.getPremium());


    }

    @Override
    protected void parametrizeUpdateStatement(PreparedStatement statement, User entity) throws SQLException
    {

        statement.setString(1,entity.getName());
        statement.setString(2,entity.getSurname());
        statement.setString(3,entity.getUserName());
        statement.setString(4,entity.getPassword());
        statement.setString(5,entity.getEmail());
        statement.setBoolean(6,entity.getPremium());
        statement.setLong(7,entity.getId());


    }

    @Override
    protected User doLoad(ResultSet rs) throws SQLException
    {
        User user_temp = new User();
        user_temp.setId(rs.getLong("id"));
        user_temp.setName(rs.getString("NAME"));
        user_temp.setSurname(rs.getString("SURNAME"));
        user_temp.setUserName(rs.getString("USERNAME"));
        user_temp.setPassword(rs.getString("PASSWORD"));
        user_temp.setEmail(rs.getString("EMAIL"));
        user_temp.setPremium(rs.getBoolean("PREMIUM"));
        user_temp.setAdmin(rs.getBoolean("ADMIN"));


        return user_temp;

    }




}
