package Profiles.Vendor;

import javafx.beans.property.SimpleStringProperty;

public class VendorList {
    private SimpleStringProperty vendID, vendName,streetAddress, city, state, phoneNumber,balance,
            lastPaidAmount, lastOrderDate, seasDiscDate;
    public String getID() {
        return vendID.get();
    }
    public String getCompanyName() {
        return vendName.get();
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
    public String getPhone() {
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
    public String getSeasDiscDate(){return seasDiscDate.get();}

    public VendorList(String vendID, String vendName, String address, String city, String state, String phoneNumber,
                        String balance, String lastPaidAmount, String lastOrderDate, String seasDiscDate) {
        this.vendID = new SimpleStringProperty(vendID);
        this.vendName = new SimpleStringProperty(vendName);
        this.streetAddress = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.balance = new SimpleStringProperty(balance);
        this.lastPaidAmount = new SimpleStringProperty(lastPaidAmount);
        this.lastOrderDate = new SimpleStringProperty(lastOrderDate);
        this.seasDiscDate = new SimpleStringProperty(seasDiscDate);
    }
}
