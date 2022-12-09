package Profiles.Users;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author David Her
 * Used code from Paulo and Shijie's Update files
 */
public class UpdateUserProfile {
    private Scanner in;
    public void updateProfile(String userID, String lastName,
                                     String firstName, String password, String userRole){

        String uID = "", lName = "", fName = "", pass = "", uRole = "";

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

                uID = String.valueOf(values[0]);
                lName = String.valueOf(values[1]);
                fName = String.valueOf(values[2]);
                pass = String.valueOf(values[3]);
                uRole = String.valueOf(values[4]);

                if(userID.equals(uID)){
                    pW.println(userID + "," + lastName + "," + firstName + "," + password + "," + userRole + ",");
                }
                else{
                    pW.println(uID + "," + lName + "," + fName + "," + pass + "," + uRole + ",");
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
