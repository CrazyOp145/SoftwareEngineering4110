import Profiles.LoginValidation;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args){
        LoginValidation.createUserProfiles();

        System.out.println("Please input a name for the Vendor: ");
        vName = scanner.nextLine();
        vName = characterLimit(20, vName);
        System.out.println("You inputted: " + vName);
        
        String customer = "Customer Profile";
        UserProfiles profile1 = ProfilesFactory.createProfile(customer);
        System.out.println(profile1.toString());
    }

    public static String characterLimit(int limit, String stringToLimit) {
        String cutName = stringToLimit.substring(0, limit);
        if (stringToLimit.length() > limit) {
            stringToLimit = cutName;
        }
    }