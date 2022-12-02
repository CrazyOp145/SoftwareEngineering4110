package Profiles.Login;

import java.util.*;

/**
 * @author David Her
 */

public class CheckInputs {

    // Check the input length for Names
    public static String checkNameInput(Scanner in, String prompt){
        System.out.println(prompt);
        String output;

        while(true){
            output = in.nextLine();
            if(output.length() <= 15 && output.length() != 0){
                break;
            }
            System.out.println("Error: Invalid Character Length, Please " + prompt);
        }
        return output;
    }

    // Check the input length for UserIDs
    public static String checkUserIDInput(Scanner in, String prompt){
        System.out.println(prompt);
        String output;
        while(true){
            output = in.nextLine();
            if(output.length() <= 6 && output.length() != 0){
                break;
            }
            System.out.println("Error: Invalid UserID, Please " + prompt);
        }
        return output;
    }

    // Check the input length for Passwords
    public static String checkPasswordInput(Scanner in, String prompt){
        System.out.println(prompt);
        String output;

        while(true){
            output = in.nextLine();
            if(output.length() >= 8 && output.length() <= 16){
                break;
            }
            System.out.println("Error: Invalid Character Length, Please " + prompt);
        }
        return output;
    }
}
