package Profiles;

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

    public void setFirstName(String fName);

    public void setLastName(String lName);

    public void setID(String id);

    public void setPassword(String pw);

    public String getUserType();

    public void setStreet(String street);

    public void setState(String state);

    public void setCity(String city);
}