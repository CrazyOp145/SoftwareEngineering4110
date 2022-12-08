package Profiles.Customers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CalculateCustomerOrderTotal {
    public double calculateCustomerOrderTotal(String filepath){
        double totalCost = 0;
        double michiganTaxRate = 1.06;
        String filePath = filepath;
        File file = new File(filePath);

        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");
                try {
                    double value = Double.parseDouble(String.valueOf(values[6]));
                    totalCost += value;
                }
                catch (Exception e){
                    System.out.println("Header or Footer of the Order. Has no subtotal");
                }
                System.out.println(totalCost);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return totalCost*michiganTaxRate;
    }
}


