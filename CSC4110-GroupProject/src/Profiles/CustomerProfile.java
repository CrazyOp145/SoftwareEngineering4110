package Profiles;

public class CustomerProfile implements UserProfiles{
    private String customerID;
    private String companyName;
    private String city;
    private String streetAddress;
    private String state;
    private String phone;
    private double balance = 0;
    private double lastPaidAmount = 0;
    private String lastOrderDate = "None";
    private String pw = null;
    public CustomerProfile(){

    }
    public CustomerProfile(String customerID, String companyName, String streetAddress, String city, String state,
                           String phone){
        this.customerID = customerID;
        this.companyName = companyName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = balance;
    }
    public String getCompanyName(){return companyName;}

    public String getCustomerID() {
        return customerID;
    }

    //public void setCompanyName(String fullName) {
    //    this.companyName = companyName;
    //}

    public String getCity() {
        return city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getState() {
        return state;
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
        return (customerID +" "+ companyName+" " +streetAddress+ " "+city+" " +state+" "+ phone + " "
                + balance +" "+ lastPaidAmount + " " +lastOrderDate);
    }

    @Override
    public void setFirstName(String fName) {
        companyName = fName;
    }

    @Override
    public void setLastName(String lName) {
        lName = null;
    }

    @Override
    public void setID(String id) {
        customerID = id;
    }

    @Override
    public void setPassword(String pw) {
        this.pw = pw;
    }

    @Override
    public String getUserType() {
        return "Customer";
    }

    @Override
    public void setStreet(String street) {
        this.streetAddress = street;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }
}