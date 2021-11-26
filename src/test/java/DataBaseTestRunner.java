import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import opencart.BaseClass;
import opencart.TestData_Holder;
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
    @Test
    void TC1() throws SQLException {
        lineInArray=new ArrayList<>();
        String[]qw=null;
        try (CSVReader reader = new CSVReader(new FileReader("testdata.csv"))) {
       lineInArray=reader.readAll();
       qw=lineInArray.get(0);
            System.out.println(lineInArray.get(1).toString());
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
            resultSet=statement.executeQuery("select * from oc_customer where email='"+qw[0]+"'");
        System.out.println("select * from oc_customer where email='"+qw[1]+"'");
            resultSet.next();
            Assert.assertEquals(resultSet.getString("email"),TestData_Holder.getEmail());
    }
    @AfterClass
    void disconnectDataBase() throws SQLException {
        connection.close();
    }
}
