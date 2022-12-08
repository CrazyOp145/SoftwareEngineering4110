package Profiles.Users;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author David Her
 * Used code from Shijie Du's DeleteItemProfile
 */
public class DeleteUserProfile {
    private Scanner in;
    public void delProfile(String userInput){
        String userID = "", lName = "", fName = "", pass = "", userRole = "";
        FileWriter fW = null;
        try{
            fW = new FileWriter("UserDataTemp.csv", true);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);

            in = new Scanner(new File("UserData.csv"));
            in.useDelimiter("[,\n]");

            while (in.hasNext()){
                String data = in.nextLine();
                Object[] values = data.split(",");

                userID = String.valueOf(values[0]);
                lName = String.valueOf(values[1]);
                fName = String.valueOf(values[2]);
                pass = String.valueOf(values[3]);
                userRole = String.valueOf(values[4]);

                if(!userID.equals(userInput)){
                    pW.println(userID + "," + lName + "," + fName + "," + pass + "," + userRole + ",");
                }
            }
            in.close();
            pW.flush();
            pW.close();
            JOptionPane.showMessageDialog(null,"User has been deleted");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"Failed to delete User");
            e.printStackTrace();
        }
    }
}
