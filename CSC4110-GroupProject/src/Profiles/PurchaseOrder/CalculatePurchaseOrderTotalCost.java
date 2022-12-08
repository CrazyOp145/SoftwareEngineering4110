package Profiles.PurchaseOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class CalculatePurchaseOrderTotalCost {
    public double calculatePurchaseOrderTotalCost(String filepath){
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
                double value = Double.parseDouble(String.valueOf( values[6]));
                totalCost += value;
                System.out.println(totalCost);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return totalCost*michiganTaxRate;
    }

//    public static void main(String[] args) {
//        CalculatePurchaseOrderTotalCost cpt = new CalculatePurchaseOrderTotalCost();
//        cpt.calculatePurchaseOrderTotalCost();
//    }
}


