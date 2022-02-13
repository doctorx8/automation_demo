package opencart.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLDataBase {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet;
public Boolean Sql_Execute() throws SQLException {
    List<String[]>lineInArray=new ArrayList<>();

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
    try {
        statement=connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        resultSet=statement.executeQuery("select * from oc_customer where email='"+
                Arrays.toString(lineInArray.get(1)).replace("[","").replace("]","")+"'");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        resultSet.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }

return resultSet.getString("email")
        .equals(Arrays.toString(lineInArray.get(1))
                .replace("[","").replace("]",""));

}

}
