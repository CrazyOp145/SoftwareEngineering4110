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
public class UpdateCustomerProfile {

    private Scanner input;

    public void updateCustomerProfile(String filePath, String customerID,
                                  String newCompanyName, String newAddress, String newCity,
                                  String newState, String newPhoneNumber,String newBalance,
                                  String newLastPurchasePrice, String newLastPurchaseDate) {

        String tempFile = "tempCustomerProfiles.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String theCustomerID;
        String companyName;
        String address;
        String city;
        String state;
        String phoneNumber;
        String balance;
        String lastPurchasePrice;
        String lastPurchaseDate;

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

                theCustomerID = String.valueOf(values[0]);
                companyName = String.valueOf(values[1]);
                address = String.valueOf(values[2]);
                city = String.valueOf(values[3]);
                state = String.valueOf(values[4]);
                phoneNumber = String.valueOf(values[5]);
                balance = String.valueOf(values[6]);
                lastPurchasePrice = String.valueOf(values[7]);
                lastPurchaseDate = String.valueOf(values[8]);

                if (!theCustomerID.equals(customerID)) {
                    pw.println(theCustomerID + "," + companyName + "," + address + "," + city
                            + "," + state + "," + phoneNumber + "," + balance + "," + lastPurchasePrice+ "," +lastPurchaseDate);
                }else{pw.println(customerID + "," + newCompanyName + "," + newAddress + "," + newCity
                        + "," + newState + "," + newPhoneNumber + "," + newBalance + "," + newLastPurchasePrice+ "," +newLastPurchaseDate);
                }
            }
            input.close();
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "The item has been Updated");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fail to update the item");
        }

    }
}