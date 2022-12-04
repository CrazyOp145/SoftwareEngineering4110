import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class CalculatePurchaseOrderTotalCost {
    public double calculatePurchaseOrderTotalCost(){
        double totalCost = 0;
        String filePath = "PurchaseOrder500001.csv";
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

        return totalCost;
    }

//    public static void main(String[] args) {
//        CalculatePurchaseOrderTotalCost cpt = new CalculatePurchaseOrderTotalCost();
//        cpt.calculatePurchaseOrderTotalCost();
//    }
}


