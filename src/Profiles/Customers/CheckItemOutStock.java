package Profiles.Customers;

import Oberver.ItemGrabber;
import Oberver.StockObserver;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class CheckItemOutStock {
    public Boolean checkItemOutStock(){
        int counter= 0;
        String quantity;
        String filePath = "ItemProfile.csv";
        File items = new File(filePath);
        try{
            Scanner input = new Scanner(items);
            while (input.hasNext()) {
                String data = input.nextLine();
                Object[] values = data.split(",");
                quantity = String.valueOf(values[2]);
                if (Double.parseDouble(quantity) <= 0){
                    counter++;
                }
            }
        }
        catch(Exception e){
        }
        if(counter >=2){
            return true;
        }
        return false;
    }

}
