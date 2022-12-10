package Profiles.PurchaseOrder;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class UpdateVendorBalance {

    public static void updateVendorBalance(String filePath, String updateTerm, double newBalance)  {

        Scanner input;
        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String vendorId;
        String vendorName;
        String address;
        String city;
        String state;
        String payDate;
        String payAmount;
        String vendorDate;
        String balance;

        FileWriter fw = null;

        try {
            fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            input = new Scanner(oldFile);
            input.useDelimiter("[,\n]");

            while (input.hasNext()) {
                String data = input.nextLine();
                Object[] values = data.split(",");

                vendorId = String.valueOf(values[0]);
                vendorName = String.valueOf(values[1]);
                address = String.valueOf(values[2]);
                city = String.valueOf(values[3]);
                state = String.valueOf(values[4]);
                payDate = String.valueOf(values[5]);
                payAmount = String.valueOf(values[6]);
                vendorDate = String.valueOf(values[7]);
                balance = String.valueOf(values[8]);
                if (!vendorId.equals(updateTerm)) {
                    pw.println(vendorId + "," + vendorName + "," + address + "," + city
                            + "," + state + "," + payDate + "," + payAmount + "," + vendorDate + "," + balance);
                } else {
                    pw.println(vendorId + "," + vendorName + "," +address + "," + city
                            + "," + state + "," + payDate + "," + payAmount + "," + vendorDate + "," + Double.toString(Double.parseDouble(balance) + newBalance));
                }
            }
            input.close();
            pw.flush();
            pw.close();
            fw = new FileWriter(filePath);
            BufferedWriter nbw = new BufferedWriter(fw);
            PrintWriter npw = new PrintWriter(nbw);
            Scanner tempInput = new Scanner(new File(tempFile));
            while (tempInput.hasNext()) {
                String data = tempInput.nextLine();
                Object[] values = data.split(",");

                vendorId = String.valueOf(values[0]);
                vendorName = String.valueOf(values[1]);
                address = String.valueOf(values[2]);
                city = String.valueOf(values[3]);
                state = String.valueOf(values[4]);
                payDate = String.valueOf(values[5]);
                payAmount = String.valueOf(values[6]);
                vendorDate = String.valueOf(values[7]);
                balance = String.valueOf(values[8]);
                npw.println(vendorId + "," + vendorName + "," + address + "," + city
                        + "," + state + "," + payDate + "," + payAmount + "," + vendorDate + "," + balance);
            }
            tempInput.close();
            npw.flush();
            npw.close();
            newFile.delete();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fail to update the balance");
        }

    }
}
