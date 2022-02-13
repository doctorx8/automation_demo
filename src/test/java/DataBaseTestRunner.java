import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import opencart.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
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
    }
    @Test()
    public void TC1() throws SQLException {
        lineInArray=new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("testdata.csv"))) {
       lineInArray=reader.readAll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
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
