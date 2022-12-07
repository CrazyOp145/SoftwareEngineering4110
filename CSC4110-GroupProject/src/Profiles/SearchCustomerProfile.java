package Profiles;

//import com.opencsv.exceptions.CsvException;
//import csvFiles.ReadFromCSVs;
//import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class SearchCustomerProfile {
    public static String[] SearchCustomerProfile(String searchTerm) throws IOException {
        Scanner customerInfo = new Scanner(new File("CustomerProfiles.csv"));
        customerInfo.useDelimiter(",");
        while (customerInfo.hasNext()){
            String tempUserInfo = customerInfo.nextLine();
            String[] tempUserInfoArray = tempUserInfo.split(",");
            if(searchTerm.equals(tempUserInfoArray[0]) || searchTerm.equals(tempUserInfoArray[1])){
                return tempUserInfoArray;
            }
        }
        return null;
    }
}
