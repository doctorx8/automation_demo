import opencart.BaseClass;
import opencart.utilities.SQLDataBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

public class DataBaseTestRunner extends BaseClass {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet;
    List<String[]> lineInArray;
    @BeforeClass
    void connectDataBase() throws SQLException {
        connection= DriverManager.getConnection
              (properties.getProperty("dataBaseUrl"),properties.getProperty("dataBaseUser"),properties.getProperty("dataPassword"));
        System.out.println("database connected");
    }
    @Test
    public void TC1() throws SQLException {
       SQLDataBase sqlEx=new SQLDataBase();
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select * from oc_customer where email='"+Arrays.toString(lineInArray.get(1)).replace("[","").replace("]","")+"'");
        resultSet.next();
        Assert.assertEquals(resultSet.getString("email"),(Arrays.toString(lineInArray.get(1)).replace("[","").replace("]","")));
    }
    @AfterClass
    void disconnectDataBase() throws SQLException {
        connection.close();

    }
}
