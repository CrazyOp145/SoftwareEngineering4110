package Profiles;
/*
@author Mahz Alam and Paulo Burgess and David Her
 */

import java.time.LocalDate;

public interface UserProfiles {
   /* private String firstName;
    private String lastName;
    private String ID;
    private String password;

    UserProfiles(){
    }

    public UserProfiles(String firstName, String lastName, String ID, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
    }*/

    String getCompanyName();

    String getCustomerID();

    //public void setCompanyName(String fullName) {
    //    this.companyName = companyName;
    //}
    String getCity();

    String getStreetAddress();

    String getState();

    String getPhone();

    void setPhone(String phone);

    double getBalance();

    void setBalance(double balance);

    double getLastPaidAmount();

    void setLastPaidAmount(double lastPaidAmount);

    LocalDate getLastOrderDate();

    void setLastOrderDate(LocalDate lastOrderDate);

    public void setFirstName(String fName);

    public void setLastName(String lName);

    public void setID(String id);

    public void setPassword(String pw);

    public String getUserType();

    public void setStreet(String street);

    public void setState(String state);

    public void setCity(String city);
}