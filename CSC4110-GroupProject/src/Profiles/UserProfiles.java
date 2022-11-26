package Profiles;

public abstract class UserProfiles {
    private String firstName;
    private String lastName;
    private String ID;
    private String password;

    public UserProfiles(){

    }
    public UserProfiles(String firstName, String lastName, String ID, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }
}