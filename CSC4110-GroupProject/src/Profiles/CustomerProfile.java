package Profiles;

public class CustomerProfile extends UserProfiles{
    private String customerID;
    private String fullName;
    private String city;
    private String streetAddress;
    private String state;
    private String phone;
    private double balance = 0;
    private double lastPaidAmount = 0;
    private String lastOrderDate = "";

    public CustomerProfile(String customerID, String fullName, String streetAddress, String city, String state,
                           String phone){
        this.customerID = customerID;
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = balance;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLastPaidAmount() {
        return lastPaidAmount;
    }

    public void setLastPaidAmount(double lastPaidAmount) {
        this.lastPaidAmount = lastPaidAmount;
    }

    public String getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(String lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }
    public String toString(){
        return (customerID+ fullName+ streetAddress+city+ state+phone);
    }
}