package Profiles;

public class Purchaser extends UserProfiles{
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

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
