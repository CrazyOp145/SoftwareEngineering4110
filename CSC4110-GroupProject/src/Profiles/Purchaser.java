package Profiles;

public class Purchaser implements UserProfiles{
    private String firstName;
    private String lastName;
    private String ID;
    private String password;
    private String userType = "Purchaser";

    public Purchaser() {

    }

    public Purchaser(String firstName, String lastName, String ID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
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

    @Override
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

}
