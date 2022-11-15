import java.util.Scanner;

public class LoginValidation {
    private String userID;
    private String firstName;
    private String lastName;
    private String password;
    private String userRole;

    // Enable Owner and Administrator users to create User Profiles
    public static void createUserProfiles(){
        Scanner cUserProfile = new Scanner(System.in);
        String lName = checkNameInput(cUserProfile, "Enter in Last Name:");
        String fName = checkNameInput(cUserProfile, "Enter in First Name:");
        String uID = checkUserIDInput(cUserProfile, "Enter in UserID:");
        String pass = checkPasswordInput(cUserProfile,"Enter in Password:");
        System.out.println("Enter in User Role:");
        String uRole = cUserProfile.nextLine();
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
}
