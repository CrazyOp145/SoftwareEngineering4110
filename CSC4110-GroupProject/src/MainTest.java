import Profiles.LoginValidation;
import csvFiles.WriteToCSVs;

import java.util.Scanner;



public class MainTest {
    public static void main(String[] args){

        String vName;

        Scanner scanner = new Scanner(System.in);
        LoginValidation.createUserProfiles();


        System.out.println("Please input a name for the Vendor: ");
        vName = scanner.nextLine();
        vName = characterLimit(20, vName);
        System.out.println("You inputted: " + vName);

    }

    public static String characterLimit(int limit, String stringToLimit){
        String cutName = stringToLimit.substring(0, limit);
        if(stringToLimit.length() > limit){
            stringToLimit = cutName;
        }
        return stringToLimit;
    }
}