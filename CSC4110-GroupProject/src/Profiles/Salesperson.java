package Profiles;

public class Salesperson implements UserProfiles{
    private String firstName;
    private String lastName;
    private String ID;
    private String password;
    private String userType = "Salesperson";

    public Salesperson() {

    }

    public Salesperson(String firstName, String lastName, String ID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getCompanyName() {
        return null;
    }

    @Override
    public String getCustomerID() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getStreetAddress() {
        return null;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }

    @Override
    public void setPhone(String phone) {

    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void setBalance(double balance) {

    }

    @Override
    public double getLastPaidAmount() {
        return 0;
    }

    @Override
    public void setLastPaidAmount(double lastPaidAmount) {

    }

    @Override
    public String getLastOrderDate() {
        return null;
    }

    @Override
    public void setLastOrderDate(String lastOrderDate) {

    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public void setStreet(String street) {
        street = null;
    }

    @Override
    public void setState(String state) {
        state = null;
    }

    @Override
    public void setCity(String city) {
        city = null;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}