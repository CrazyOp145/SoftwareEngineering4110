import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class DeleteCustomerProfile {
    private Scanner input;
    public void deleteCustomerProfile(String filePath, String removeTerm){

        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String customerID;
        String companyName;
        String city;
        String address;
        String state;
        String phoneNumber;
        String balance;
        String lastPaidAmount;
        String lastOrderDate;

        FileWriter fw = null;
        try {
            fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            input = new Scanner(new File(filePath));
            input.useDelimiter("[,\n]");

            while(input.hasNext()){
                String data = input.nextLine();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");

                customerID = String.valueOf(values[0]);
                companyName = String.valueOf(values[1]);
                address = String.valueOf(values[2]);
                city = String.valueOf(values[3]);
                state = String.valueOf(values[4]);
                phoneNumber = String.valueOf(values[5]);
                balance = String.valueOf(values[6]);
                lastPaidAmount = String.valueOf(values[7]);
                lastOrderDate = String.valueOf(values[8]);

                if(!customerID.equals(removeTerm)){
                    pw.println(customerID + ","+companyName+","+address+","+city
                            +","+state+","+phoneNumber+","+balance+","+lastPaidAmount+","+lastOrderDate);
                }
            }
            input.close();
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null,"The item has been deleted");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Fail to delete item");
        }



    }
}
