package ItemProfiles;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
public class UpdateItemProfile {

    private Scanner input;

    public void updateItemProfile(String filePath, String updateTerm,
                                  String newItemId, String newItemName, String newQuantity, String newSellingPrice,
                                  String newPurchasePrice, String newExpireDate,String newCategory,String newUnit) {

        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String itemId = "", itemName = "", category = "", unit = "", quantity = "", sellingPrice = "",
                purchasePrice = "", expireDate = "";
        //int quantity = "";
        //double sellingPrice = 0.0, purchasePrice = 0.0;
        //LocalDate expireDate;

        FileWriter fw = null;
        try {
            fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            input = new Scanner(new File(filePath));
            input.useDelimiter("[,\n]");

            while (input.hasNext()) {
                itemId = input.next();
                itemName = input.next();
                quantity = input.next();
                sellingPrice = input.next();
                purchasePrice = input.next();
                expireDate = input.next();
                category = input.next();
                unit = input.next();

                if (!itemId.equals(updateTerm)) {
                    pw.print(itemId + "," + itemName + "," + quantity + "," + sellingPrice
                            + "," + purchasePrice + "," + expireDate + "," + category + "," + unit);
                }else{pw.print(newItemId + "," + newItemName + "," + newQuantity + "," + newSellingPrice
                        + "," + newPurchasePrice + "," + newExpireDate + "," + newCategory + "," + newUnit);
                }
            }
            input.close();
            pw.flush();
            pw.close();
            //oldFile.delete();
            //File dump = new File(filePath);
            //newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null, "The item has been Updated");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fail to update the item");
        }

    }
}