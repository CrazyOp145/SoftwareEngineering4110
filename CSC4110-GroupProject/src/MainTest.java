import Profiles.*;
import com.opencsv.exceptions.CsvException;
import csvFiles.WriteToCustomerProfileCSV;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainTest {
    public static void main(String[] args) throws IOException, CsvException {
        Owner currentUser = new Owner();
        //LoginValidation.createUserProfiles();
        //File customerProfilesFile = new File("CustomerProfiles.csv");
        //System.out.println("Please input a name for the Vendor: ");
        // String vName = Scanner.nextLine();
        //vName = characterLimit(20, vName);
        //System.out.println("You inputted: " + vName);

        String customer = "Customer Profile";
        UserProfiles profile1 = ProfilesFactory.createProfile(customer);
        if(profile1 instanceof CustomerProfile) {
            if (currentUser.getUserType().equals("Owner")) {
                System.out.println("Creating new Customer Profile");
                Scanner scan = new Scanner(System.in);
                Random randID = new Random();
                String customerID = String.valueOf(randID.nextInt(999999));
                Pattern phonePattern = Pattern.compile("^([0-9]{3}-){2}[0-9]{4}$");
                String companyName, address, city, state, phoneNum;
                while (true) {
                    System.out.println("Please enter the customers Company Name (max 20 characters): ");
                    companyName = scan.nextLine();
                    if (companyName.length() < 21 && companyName.length() > 0) {
                        break;
                    } else {
                        System.out.println("Name too long please enter a name that is less than 20 characters.");
                    }
                }
                while (true) {
                    System.out.println("Please enter customers address (max 20 characters): ");
                    address = scan.nextLine();
                    if (address.length() < 21 && address.length() > 0) {
                        break;
                    } else {
                        System.out.println("Address did not meet requirements.");
                    }
                }
                while (true) {
                    System.out.println("Please enter the customers city (max 20 characters): ");
                    city = scan.nextLine();
                    if (city.length() < 21 && city.length() > 0) {
                        break;
                    } else {
                        System.out.println("City name did not meet requirements.");
                    }
                }
                while (true) {
                    System.out.println("Please enter the customers State (max 2 characters): ");
                    state = scan.nextLine();
                    if (state.length() < 3 && state.length() > 0) {
                        break;
                    } else {
                        System.out.println("State too long please enter a state that is less than 20 characters.");
                    }
                }
                while (true) {
                    System.out.println("Please enter the customers phone number (xxx-xxx-xxxx): ");
                    phoneNum = scan.nextLine();
                    if (phoneNum.matches(phonePattern.pattern())) {
                        break;
                    } else {
                        System.out.println("Phone Number format incorrect. Please enter a valid phone number.");
                    }
                }
                CustomerProfile newProfile = new CustomerProfile(customerID, companyName, address, city, state, phoneNum);
                System.out.println(newProfile.toString());
                String[] CustomerProfileData = {newProfile.getCustomerID(), newProfile.getCompanyName(), newProfile.getCity(),
                        newProfile.getState(), newProfile.getStreetAddress(), newProfile.getPhone(), Double.toString(newProfile.getBalance()),
                        Double.toString(newProfile.getLastPaidAmount()), newProfile.getLastOrderDate()};
                WriteToCustomerProfileCSV.csvCustomerProfileWriter(CustomerProfileData);
            }
            else{
                System.out.println("User type incorrect: Now an Owner.");
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the Customer Profile ID or Company Name you are searching for: ");
        String customerProfileSearch = scan.nextLine();
       String[] testing =  SearchCustomerProfile.SearchCustomerProfile(customerProfileSearch);
       if(testing == null){
           System.out.println("Customer Profile not found.");
       }
       else{
           for(int i = 0; i < testing.length; i++){
               System.out.println(testing[i]);
           }
       }
    }

    //public static String characterLimit(int limit, String stringToLimit) {
        //String cutName = stringToLimit.substring(0, limit);
        //if (stringToLimit.length() > limit) {
            //stringToLimit = cutName;
       // }
   // }
}