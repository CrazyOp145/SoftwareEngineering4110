package Profiles;
/*
@author Mahz Alam and Paulo Burgess and David Her
 */

import java.time.LocalDate;

public interface UserProfiles {

    String getCompanyName();

    String getCustomerID();

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