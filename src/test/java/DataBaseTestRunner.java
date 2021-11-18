
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.sql.*;
import java.util.Properties;

public class DataBaseTestRunner {
    Connection connection=null;
    Properties properties=new Properties();
    Statement statement=null;
    ResultSet resultSet;
    @BeforeClass
    public void connectDataBase() throws SQLException {

      connection= DriverManager.getConnection(properties.getProperty("dataBaseUrl"),properties.getProperty("dataBaseUser"),properties.getProperty(""));
    }
    @Test
    void TC1() throws SQLException {

            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from oc_customer where email='IuNqB@faSYw.com';");
            resultSet.next();
            Assert.assertEquals(resultSet.getString("email"),"IuNqB@faSYw.com");

    }
    @AfterClass
    public void disconnectDataBase() throws SQLException {

            connection.close();

    }
}
