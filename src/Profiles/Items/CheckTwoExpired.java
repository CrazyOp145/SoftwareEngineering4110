package Profiles.Items;

import javax.swing.*;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CheckTwoExpired {
    public static Boolean checkTwoExpired(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        int expiredCounter= 0;
        String tempExpireDate;
        String filePath = "ItemProfile.csv";
        File items = new File(filePath);
        try{
            Scanner input = new Scanner(items);
            input.useDelimiter("[,\n]");
            while (input.hasNext()) {
                String data = input.nextLine();
                input.useDelimiter(",");
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");
                tempExpireDate = String.valueOf(values[5]);
                if (LocalDate.parse(tempExpireDate,formatter).compareTo(LocalDate.now()) < 0){
                    expiredCounter++;
                }
            }
        }
        catch(Exception e){

        }
        if(expiredCounter >=2){
            return true;
        }
        return false;
    }
}
