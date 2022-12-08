package Profiles.Customers;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class UpdateItemQuantity {

    private Scanner input;

    public static void updateItemQuantity(String filePath, String updateTerm,
                                           String newQuantity)  {
        Scanner input;
        String tempFile = "tempItemProfiles.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String itemId;
        String itemName;
        String quantity;
        String sellingPrice;
        String purchasePrice;
        String expireDate;
        String category;
        String unit;
        String vendorId;

        FileWriter fw = null;

        try {
            fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            input = new Scanner(oldFile);
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
                if (!itemId.equals(updateTerm)) {
                    pw.println(itemId + "," + itemName + "," + quantity + "," + sellingPrice
                            + "," + purchasePrice + "," + expireDate + "," + category + "," + unit + "," + vendorId);
                } else {
                    pw.println(itemId + "," + itemName + "," + Double.toString(Double.parseDouble(quantity) - Double.parseDouble(newQuantity)) + "," + sellingPrice
                            + "," + purchasePrice + "," + expireDate + "," + category + "," + unit + "," + vendorId);
                }
            }
            input.close();
            pw.flush();
            pw.close();
            fw = new FileWriter(filePath);
            BufferedWriter bw2 = new BufferedWriter(fw);
            PrintWriter pw2 = new PrintWriter(bw2);
            Scanner tempFileInput = new Scanner(new File(tempFile));
            tempFileInput.useDelimiter("[,\n]");
            while (tempFileInput.hasNext()) {
                String data = tempFileInput.nextLine();
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
                pw2.println(itemId + "," + itemName + "," + quantity + "," + sellingPrice
                        + "," + purchasePrice + "," + expireDate + "," + category + "," + unit + "," + vendorId);
                }
            tempFileInput.close();
            pw2.flush();
            pw2.close();
            }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fail to update the item");
        }

    }
}