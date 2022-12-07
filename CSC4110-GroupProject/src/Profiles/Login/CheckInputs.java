package Profiles.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author David Her
 */

public class CheckInputs {

    // Check the input length for Names
    public static boolean checkNameInput(String input){
        return input.length() <= 15 && input.length() != 0;
    }

    // Check the input length for UserIDs
    public static boolean checkUserIDInput(String input){
        try {
            FileReader fr = new FileReader("UserData.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] data;

            while((line = br.readLine()) != null){
                data = line.split(",");
                if(data[0].equals(input)){
                    return false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input.length() <= 6 && input.length() != 0;
    }

    // Check the input length for Passwords
    public static boolean checkPasswordInput(String input){
        return input.length() >= 8 && input.length() <= 16;
    }
}
