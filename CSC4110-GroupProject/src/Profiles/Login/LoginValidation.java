package Profiles.Login;

import csvFiles.ToCSV;

import java.io.*;
import java.util.*;

import static Profiles.Login.CheckInputs.*;

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
            FileReader fr = new FileReader("UserData.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] data;

            while((line = br.readLine()) != null){
                data = line.split(",");
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
            FileReader fr = new FileReader("UserData.csv");
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
    public static void createUserProfiles(){
        Scanner cUserProfile = new Scanner(System.in);
        setUserID(checkUserIDInput(cUserProfile, "Enter in UserID (Max 6 Characters):"));
        setLastName(checkNameInput(cUserProfile, "Enter in Last Name (Max 15 Characters):"));
        setFirstName(checkNameInput(cUserProfile, "Enter in First Name (Max 15 Characters):"));
        setPassword(checkPasswordInput(cUserProfile,"Enter in Password (Min 8 Characters & Max 16 Characters):"));
        System.out.println("Enter in User Role:");
        setUserRole(cUserProfile.nextLine());

        String[] data = {getUserID(), getLastName(), getFirstName(), getPassword(), getUserRole()};
        String[] header={"UserID", "LastName", "FirstName", "Password", "UserRole"};
        //ToCSV.createCsv("UserData.csv",header);
        ToCSV.addToUserData("UserData.csv", data);
    }

    //Delete User Profile
    public static void deleteUserProfile(){
        Scanner dUserProfile = new Scanner(System.in);
        String deleteUserInput = checkUserIDInput(dUserProfile, "Enter in User ID to Delete:");
        try {
            //Scanner
            Scanner userData = new Scanner(new File("UserData.csv"));
            userData.useDelimiter("[,\n]");
            List<String> oldData = new ArrayList<>();
            String userID,lName,fName,pass,uRole;

            //Put Old Data into List
            while(userData.hasNext()){
                userID = userData.next();
                lName = userData.next();
                fName = userData.next();
                pass = userData.next();
                uRole = userData.next();

                if(!userID.equals(deleteUserInput)) {
                    oldData.add(userID);
                    oldData.add(lName);
                    oldData.add(fName);
                    oldData.add(pass);
                    oldData.add(uRole);
                }
            }

            //FileWriters
            FileWriter file = new FileWriter("UserData.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            //Write Data into File
            printWriter.print(oldData.toString().substring(1,oldData.toString().length()-1).replaceAll(" ", ""));

            //Close Writers
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
