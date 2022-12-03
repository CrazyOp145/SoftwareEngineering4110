import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class DeleteItemProfile {
    private Scanner input;
    public void deleteItemProfile(String filePath, String removeTerm){

        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String itemId = "", itemName = "", category = "", unit = "",quantity = "",sellingPrice ="",
                purchasePrice ="", expireDate = "";
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

            while(input.hasNext()){
                String data = input.nextLine();
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
//                itemId = input.next();
//                itemName = input.next();
//                quantity = input.next();
//                sellingPrice = input.next();
//                purchasePrice = input.next();
//                expireDate = input.next();
//                category = input.next();
//                unit = input.next();

                if(!itemId.equals(removeTerm)){
                    pw.println(itemId + ","+itemName+","+quantity+","+sellingPrice
                            +","+purchasePrice+","+expireDate+","+category+","+unit);
                }
            }
            input.close();
            pw.flush();
            pw.close();
            //oldFile.delete();
            //File dump = new File(filePath);
            //newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null,"The item has been deleted");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Fail to delete item");
        }



    }
}
