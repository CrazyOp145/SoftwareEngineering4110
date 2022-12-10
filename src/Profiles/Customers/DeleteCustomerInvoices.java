package Profiles.Customers;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class DeleteCustomerInvoices {
        public static void deleteCustomerInvoices(String removeTerm){
            Scanner input;
            String filePath = "customerInvoicesTest.csv";
            Boolean searchInFile = false;
            String tempFile = "tempInvoices.csv";
            String customerID;
            File oldFile = new File(filePath);
            File newFile = new File(tempFile);
            FileWriter fw = null;
            try {
                fw = new FileWriter(tempFile);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                input = new Scanner(oldFile);
                input.useDelimiter("[,\n]");

                while(input.hasNext()){
                    String data = input.nextLine();
                    Object[] values = data.split(",");
                    Object[] valuesLine = data.split("\n");

                    customerID = String.valueOf(values[0]);
                    if(!customerID.equals(removeTerm)){
                            pw.println(data);
                        }
                    else{
                        searchInFile = true;
                    }
                }
                if(!searchInFile){
                    JOptionPane.showMessageDialog(null,"The Customer Has no associated invoices.");
                }
                else{
                    JOptionPane.showMessageDialog(null,"All related Invoices have been Deleted.");
                }
                input.close();
                pw.flush();
                pw.close();
                fw = new FileWriter(filePath);
                BufferedWriter bw2 = new BufferedWriter(fw);
                PrintWriter pw2 = new PrintWriter(bw2);
                Scanner tempFileInput = new Scanner(new File(tempFile));
                tempFileInput.useDelimiter("[,\n]");
                while(tempFileInput.hasNext()){
                    String data = tempFileInput.nextLine();
                    Object[] values = data.split(",");
                    Object[] valuesLine = data.split("\n");

                    pw2.println(data);
                }
                tempFileInput.close();
                pw2.flush();
                pw2.close();
                newFile.delete();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Failed to delete Customer Profile");
            }



        }
    }
