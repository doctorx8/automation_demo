package opencart.utilities;


import opencart.TestData_Holder;

import java.util.ArrayList;
import java.util.List;

public class CsvWR  {
    public static List<String[]> createCsvDataSpecial() {
        String []emailRegister={TestData_Holder.getEmail()};
        String[] header = {"email"};
        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(emailRegister);
        return list;
    }
}
