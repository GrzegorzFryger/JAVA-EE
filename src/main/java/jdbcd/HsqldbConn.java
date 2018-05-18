package jdbcd;

import java.sql.Connection;
import java.sql.DriverManager;

public class HsqldbConn
{
    private final String URL_DB = "jdbc:hsqldb://localhost/testdb";
    private final String User = "SA";
    private final String Password = "";
    private final String DriverName = "org.hsqldb.jdbc.JDBCDriver";
    private Connection con;

    public Connection getConnection() {

        try {

            Class.forName("org.hsqldb.jdbcDriver" );
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/computerstore", "sa", "");
            if (con!= null){
                System.out.println("Connection created successfully");

            }else{
                System.out.println("Problem with creating connection");
            }

        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return con;
    }
}
