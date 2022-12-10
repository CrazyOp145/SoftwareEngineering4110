package Profiles.Customers;

import Profiles.CustomerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Scanner;
//@author Mahz Alam
//NOTES: Customer Order csv file needs re-ordering. Logic wont read past CustomerName:....WHYYYYYYYY!!!
public class ReadCustomerOrder {
    private static ObservableList<CustomerList> dataList = FXCollections.observableArrayList();

    public static void initList(String customer) {
        String filePath = "CustomerOrders.csv";
        String custName = null;
        File file = new File(filePath);

        try {
            Scanner input = new Scanner(file);
            while ((input.hasNext())) {
                String data = input.nextLine();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");
                if (String.valueOf(values[0]).equals("CustomerName:")) {
                    custName = String.valueOf(values[1]);
                    System.out.println("Bruh");
                    System.out.println(custName);
                }
                if(custName.equals(customer)) {
                    if (!String.valueOf(values[0]).equals("CustomerName:") || !String.valueOf(values[0]).equals("OrderNumber:")) {
                        if(!String.valueOf(values[0]).equals("OrderSubtotal:") || !String.valueOf(values[0]).equals("")) {
                            dataList.add(new CustomerList(custName, String.valueOf(values[0]), String.valueOf(values[1]),
                                    String.valueOf(values[2]), String.valueOf(values[3]), String.valueOf(values[4]),
                                    String.valueOf(values[5])));
                            try {
                                String invoiceFile = "CustomerInvoice.csv";
                                FileWriter fw = new FileWriter(invoiceFile);
                                BufferedWriter bw = new BufferedWriter(fw);
                                PrintWriter pw = new PrintWriter(bw);

                                pw.println(custName + "," + String.valueOf(values[0]) + "," +
                                        String.valueOf(values[1]) + "," + String.valueOf(values[2]) + "," + String.valueOf(values[3]) + ","
                                        + String.valueOf(values[4]) + "," + String.valueOf(values[5]) + ",");
                                pw.flush();
                                pw.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else{ continue;}
                    }
                }else{
                    custName = null;
                    System.out.println("Customer not in invoice");
                }

            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


