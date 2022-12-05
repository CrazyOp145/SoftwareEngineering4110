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
    @Override
    public String getCompanyName(){return companyName;}
    @Override
    public String getCustomerID() {
        return customerID;
    }

    //public void setCompanyName(String fullName) {
    //    this.companyName = companyName;
    //}
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public String getStreetAddress() {
        return streetAddress;
    }
    @Override
    public String getState() {
        return state;
    }
    @Override
    public String getPhone() {
        return phone;
    }
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public double getBalance() {
        return balance;
    }
    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public double getLastPaidAmount() {
        return lastPaidAmount;
    }
    @Override
    public void setLastPaidAmount(double lastPaidAmount) {
        this.lastPaidAmount = lastPaidAmount;
    }
    @Override
    public String getLastOrderDate() {
        return lastOrderDate;
    }
    @Override
    public void setLastOrderDate(String lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }
    @Override
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