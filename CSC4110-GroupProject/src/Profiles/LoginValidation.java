package Profiles;

import csvFiles.ToCSV;
import java.util.Scanner;
import static Profiles.checkLength.*;

public class LoginValidation {
    private static String userID;
    private static String firstName;
    private static String lastName;
    private static String password;
    private static String userRole;

    // Enable Owner and Administrator users to create User Profiles
    public static void createUserProfiles(){
        Scanner cUserProfile = new Scanner(System.in);
        setLastName(checkNameInput(cUserProfile, "Enter in Last Name (Max 15 Characters):"));
        setFirstName(checkNameInput(cUserProfile, "Enter in First Name (Max 15 Characters):"));
        setUserID(checkUserIDInput(cUserProfile, "Enter in UserID (Max 6 Characters):"));
        setPassword(checkPasswordInput(cUserProfile,"Enter in Password (Min 8 Characters & Max 16 Characters):"));
        System.out.println("Enter in User Role:");
        setUserRole(cUserProfile.nextLine());

        String[] data = {getLastName(), getFirstName(), getUserID(), getPassword(), getUserRole()};
        String[] header={"LastName", "FirstName", "UserID", "Password", "UserRole"};
        //ToCSV.createCsv("UserData.csv",header);
        ToCSV.addToUserData("UserData.csv", data);
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
