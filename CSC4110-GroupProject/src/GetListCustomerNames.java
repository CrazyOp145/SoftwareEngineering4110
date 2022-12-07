import java.util.*;
import Profiles.CustomerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetListCustomerNames {
    public static String[] getListCustomerNames(){
        String[] customerNameList = new String[50];
        int counter = 0;
        String filePath = "CustomerProfiles.csv";
        File file = new File(filePath);
        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");

                customerNameList[counter] = (String.valueOf(values[1]));
                counter++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customerNameList;
    }
}
