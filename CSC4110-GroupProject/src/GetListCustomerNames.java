import java.util.*;
import Profiles.CustomerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class GetListCustomerNames {
    public static String[] getListCustomerNames(){
        List<String> customerNameList = new ArrayList<String>();
        int counter = 0;
        String filePath = "CustomerProfiles.csv";
        File file = new File(filePath);
        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");

                customerNameList.add(String.valueOf(values[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] customerNamesArray = new String[customerNameList.size()];
        return customerNameList.toArray(customerNamesArray);
    }
}
