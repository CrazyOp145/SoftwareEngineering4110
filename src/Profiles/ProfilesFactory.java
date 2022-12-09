package Profiles;

/**
 *
 * @author Paulo Burgess GN7231
 *
 */
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
            case "VENDOR":
                return new VendorProfile();
            default:
                throw new IllegalArgumentException("Unknown profile type "+ profileType);
        }
    }
}