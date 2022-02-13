package opencart.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SQLDataBase {
public List<String[]>Sql_Execute(){
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
return lineInArray;
}

}
