package jdbcd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class usrTest {

    usr usr = new usr();
    HsqldbConn conn = new HsqldbConn();


    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void checkExistingTable()
    {
        usr.checkExistingTable(conn.getConnection());
    }
}