import opencart.BaseClass;
import opencart.utilities.SQLDataBase;
import org.apache.groovy.parser.antlr4.GroovyParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Arrays;


public class DataBaseTestRunner extends BaseClass {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet;
    @BeforeClass
    void connectDataBase() throws SQLException {
        connection= DriverManager.getConnection
              (properties.getProperty("dataBaseUrl"),properties.getProperty("dataBaseUser"),properties.getProperty("dataPassword"));
        System.out.println("database connected");
    }
    @Test
    public void TC1() throws SQLException {
       SQLDataBase sqlEx=new SQLDataBase();
       Assert.assertTrue(sqlEx.Sql_Execute());
    }
    @AfterClass
    void disconnectDataBase() throws SQLException {
        connection.close();

    }
}
