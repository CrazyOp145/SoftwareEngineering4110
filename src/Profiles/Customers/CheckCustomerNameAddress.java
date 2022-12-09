package Profiles.Customers;

import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CheckCustomerNameAddress {
    public static Boolean checkCustomerNameAddress(String customerName,String customerAddress){
        String filePath = "CustomerProfiles.csv";
        File customers = new File(filePath);
        String tempName;
        String tempAddress;
        try {
            Scanner input = new Scanner(customers);
            input.useDelimiter("[,\n]");
            while (input.hasNext()) {
                String data = input.nextLine();
                input.useDelimiter(",");
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");
                tempName = String.valueOf(values[1]);
                tempAddress = String.valueOf(values[2]);
                if(tempName.toUpperCase().equals(customerName.toUpperCase()) &&
                        tempAddress.toUpperCase().equals(customerAddress.toUpperCase())){
                    return true;
                }
            }
        }
        catch(Exception e){

        }
        return false;
    }
}
