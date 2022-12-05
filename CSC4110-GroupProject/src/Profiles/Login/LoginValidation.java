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
            Scanner userData = new Scanner(new File("UserData.csv"));
            userData.useDelimiter(",");

            List<String[]> data = new ArrayList<>();
            while(userData.hasNextLine()){
                data.add(userData.next().replaceAll("[,\n]","").split(","));
            }

            int index1 = 0;
            for(int i = 0; i < data.size(); i++) {
                //Check if Index1 is larger than data size
                if(index1 < data.size()) {
                    //Check if UserID matches data
                    if (userID.equals(Arrays.toString(data.get(index1)).replaceAll("[\\[\\]\n]", ""))) {
                        System.out.println(Arrays.toString(data.get(index1)).replaceAll("[\\[\\]\n]", ""));
                        System.out.println("USER ID MATCH");

                        int index2 = index1 + 3;    //Index of where password for UserID is
                        //Check if Password matches UserPass
                        if (password.equals(Arrays.toString(data.get(index2)).replaceAll("[\\[\\]\n]", ""))) {
                            System.out.println("PASSWORD MATCH");
                            return true;
                        }
                        else {
                            System.out.println(Arrays.toString(data.get(index2)).replaceAll("[\\[\\]\n]", ""));
                            System.out.println("Password Does Not Match");
                            return false;
                        }
                    }
                    else {
                        System.out.println(Arrays.toString(data.get(index1)).replaceAll("[\\[\\]\n]", ""));
                        System.out.println("UserID Not Found");
                        index1 += 5;
                    }

                }
                //Break out of loop
                else
                    break;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
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
