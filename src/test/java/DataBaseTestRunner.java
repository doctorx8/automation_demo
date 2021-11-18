

import opencart.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;
import java.sql.DriverManager;

public class DataBaseTestRunner extends BaseClass {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet;
    @BeforeClass
    void connectDataBase() throws SQLException {

      connection= DriverManager.getConnection
              (properties.getProperty("dataBaseUrl"),properties.getProperty("dataBaseUser"),properties.getProperty("dataPassword"));
    }
    @Test
    void TC1() throws SQLException {

            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from oc_customer where email='IuNqB@faSYw.com'");
            resultSet.next();
            Assert.assertEquals(resultSet.getString("email"),"IuNqB@faSYw.com");

    }
    @AfterClass
    void disconnectDataBase() throws SQLException {

            connection.close();

    }
}
