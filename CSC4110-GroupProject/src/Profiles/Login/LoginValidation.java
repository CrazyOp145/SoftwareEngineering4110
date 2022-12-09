package Profiles.Login;

import WriteTocsvFiles.ToUserDataCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author David Her
 */

public class LoginValidation {
    private static String userID;
    private static String firstName;
    private static String lastName;
    private static String password;
    private static String userRole;

    //Login Functions
    public static boolean loginCheck(String userID, String password){
        //Read User Data
        try {
            FileReader fr = new FileReader("CSC4110-GroupProject/UserData.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] data;

            while((line = br.readLine()) != null){
                data = line.split(",");
                System.out.println(data[0]);
                System.out.println(data[3]);
                if(data[0].equals(userID) && data[3].equals(password)){
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Login Role
    public static String loginCheckRole(String userID){
        //Read User Data
        try {
            FileReader fr = new FileReader("CSC4110-GroupProject/UserData.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] data;

            while((line = br.readLine()) != null){
                data = line.split(",");
                if(data[0].equals(userID)){
                    return data[4];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Enable Owner and Administrator users to create User Profiles
    public static void createUserProfiles(String userID, String lastName, String firstName, String password, String userRole){
        setUserID(userID);
        setLastName(lastName);
        setFirstName(firstName);
        setPassword(password);
        setUserRole(userRole);

        String[] data = {getUserID(), getLastName(), getFirstName(), getPassword(), getUserRole()};
        ToUserDataCSV.addToUserData("UserData.csv", data);
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        LoginValidation.lastName = lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        LoginValidation.firstName = firstName;
    }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        LoginValidation.userID = userID;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LoginValidation.password = password;
    }

    public static String getUserRole() {
        return userRole;
    }

    public static void setUserRole(String userRole) {
        LoginValidation.userRole = userRole;
    }
}
