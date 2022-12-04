package Profiles;

//import csvFiles.WriteToCSVs;
import java.util.Scanner;

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
        setUserID(checkUserIDInput(cUserProfile, "Enter in UserID (Max 6 Characters:"));
        setPassword(checkPasswordInput(cUserProfile,"Enter in Password (Min 8 Characters & Max 16 Characters):"));
        System.out.println("Enter in User Role:");
        setUserRole(cUserProfile.nextLine());

        String[] data = {getLastName(), getFirstName(), getUserID(), getPassword(), getUserRole()};
        //WriteToCSVs.csvWriter("UserData.csv", data);
    }

    // Check the input length for Names
    public static String checkNameInput(Scanner in, String prompt){
        System.out.println(prompt);
        String output = "";

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
        String output = "";

        while(true){
            output = in.nextLine();
            if(output.length() <= 6 && output.length() != 0){
                break;
            }
            System.out.println("Error: Invalid Character Length, Please " + prompt);
        }
        return output;
    }

    // Check the input length for Passwords
    public static String checkPasswordInput(Scanner in, String prompt){
        System.out.println(prompt);
        String output = "";

        while(true){
            output = in.nextLine();
            if(output.length() >= 8 && output.length() <= 16){
                break;
            }
            System.out.println("Error: Invalid Character Length, Please " + prompt);
        }
        return output;
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
