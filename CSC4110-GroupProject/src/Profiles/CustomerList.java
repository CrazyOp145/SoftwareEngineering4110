package Profiles;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CustomerList {
    private SimpleStringProperty customerID, companyName,streetAddress, city, state, phoneNumber,balance,lastPaidAmount, lastOrderDate;
    public String getCustomerID() {
        return customerID.get();
    }
    public String getCompanyName() {
        return companyName.get();
    }
    public String getStreetAddress() {
        return streetAddress.get();
    }
    public String getCity() {
        return city.get();
    }
    public String getState() {
        return state.get();
    }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public String getBalance() {
        return balance.get();
    }
    public String getLastPaidAmount() {
        return lastPaidAmount.get();
    }
    public String getLastOrderDate() {
        return lastOrderDate.get();
    }


    public CustomerList(String customerID, String companyName, String address, String city, String state, String phoneNumber,
                        String balance, String lastPaidAmount, String lastOrderDate) {
        this.customerID = new SimpleStringProperty(customerID);
        this.companyName = new SimpleStringProperty(companyName);
        this.streetAddress = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.balance = new SimpleStringProperty(balance);
        this.lastPaidAmount = new SimpleStringProperty(lastPaidAmount);
        this.lastOrderDate = new SimpleStringProperty(lastOrderDate);
    }


}