package Profiles.Items;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class UpdateItemProfile {

    private static Scanner input;

    public static void updateItemProfile(String filePath, String updateTerm,
                                         String newItemId, String newItemName, String newQuantity, String newSellingPrice,
                                         String newPurchasePrice, String newExpireDate, String newCategory, String newUnit, String newVendorId) {

        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String itemId = "", itemName = "", category = "", unit = "", quantity = "", sellingPrice = "",
                purchasePrice = "", expireDate = "", vendorId;
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
                String data = input.nextLine();
                input.useDelimiter(",");
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");

                itemId = String.valueOf(values[0]);
                itemName = String.valueOf(values[1]);
                quantity = String.valueOf(values[2]);
                sellingPrice = String.valueOf(values[3]);
                purchasePrice = String.valueOf(values[4]);
                expireDate = String.valueOf(values[5]);
                category = String.valueOf(values[6]);
                unit = String.valueOf(values[7]);
                vendorId = String.valueOf(values[8]);
//                itemId = input.next();
//                itemName = input.next();
//                quantity = input.next();
//                sellingPrice = input.next();
//                purchasePrice = input.next();
//                expireDate = input.next();
//                category = input.next();
//                unit = input.next();

                if (!itemId.equals(updateTerm)) {
                    pw.println(itemId + "," + itemName + "," + quantity + "," + sellingPrice
                            + "," + purchasePrice + "," + expireDate + "," + category + "," + unit+ "," +vendorId);
                }else{pw.println(newItemId + "," + newItemName + "," + newQuantity + "," + newSellingPrice
                        + "," + newPurchasePrice + "," + newExpireDate + "," + newCategory + "," + newUnit+ "," + newVendorId);
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