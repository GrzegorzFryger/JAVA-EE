package jdbcd;

import java.sql.*;

public class usr
{
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

}
