package Profiles;

import java.util.*;
import java.util.regex.Pattern;

public class ProfilesFactory {
    public static UserProfiles createProfile(String profileType){
        switch (profileType.toUpperCase()) {
            case "CUSTOMER PROFILE":
                return new CustomerProfile();
            case "ADMINISTRATOR":
                return new Administrator();
            case "OWNER":
                return new Owner();
            case "INVENTORY MANAGER":
                return new InventoryManager();
            case "PURCHASER":
                return new Purchaser();
            case "ACCOUNTANT":
                return new Accountant();
            case "SALESPERSON":
                return new Salesperson();
            case "VENDOR PROFILE":
                return new VendorProfile();
            default:
                throw new IllegalArgumentException("Unknown profile type "+ profileType);
        }
    }
    public static CustomerProfile createCustomerProfile(){
        System.out.println("Creating new Customer Profile");
        Scanner scan = new Scanner(System.in);
        Random randID = new Random();
        String customerID = String.valueOf(randID.nextInt(999999));
        Pattern phonePattern = Pattern.compile("^([0-9]{3}-){2}[0-9]{4}$");
        String fullName,address,city,state,phoneNum;
        while(true) {
            System.out.println("Please enter the customers full name (max 20 characters): ");
            fullName = scan.nextLine();
            if(fullName.length() < 21 && fullName.length() > 0){
                break;
            }
            else{
                System.out.println("Name too long please enter a name that is less than 20 characters.");
            }
        }
        while(true) {
            System.out.println("Please enter customers address (max 20 characters): ");
            address = scan.nextLine();
            if (address.length() < 21 && address.length() > 0) {
                break;
            } else {
                System.out.println("Address did not meet requirements.");
            }
        }
        while(true) {
            System.out.println("Please enter the customers city (max 20 characters): ");
            city = scan.nextLine();
            if (city.length() < 21 && city.length() > 0) {
                break;
            } else {
                System.out.println("City name did not meet requirements.");
            }
        }
        while(true) {
            System.out.println("Please enter the customers State (max 2 characters): ");
            state = scan.nextLine();
            if (state.length() < 3 && state.length() > 0) {
                break;
            } else {
                System.out.println("State too long please enter a state that is less than 20 characters.");
            }
        }
        while(true) {
            System.out.println("Please enter the customers phone number (xxx-xxx-xxxx): ");
            phoneNum = scan.nextLine();
            if (phoneNum.matches(phonePattern.pattern())){
                break;
            } else {
                System.out.println("Phone Number format incorrect. Please enter a valid phone number.");
            }
        }
        return new CustomerProfile(customerID,fullName, address,city,state,phoneNum);
    }
}