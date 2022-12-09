package Profiles.Users;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author David Her
 * Used code from Shijie Du's ItemList.java
 */
public class UserList {
    private SimpleStringProperty userID, lastName, firstName, password, userRole;

    public String getUserID() {
        return userID.get();
    }
    public String getLastName() {
        return lastName.get();
    }
    public String getFirstName() {
        return firstName.get();
    }
    public String getPassword() {
        return password.get();
    }
    public String getUserRole() {
        return userRole.get();
    }

    public UserList(String userID, String lastName, String firstName,String password,String userRole){
        this.userID = new SimpleStringProperty(userID);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.password = new SimpleStringProperty(password);
        this.userRole = new SimpleStringProperty(userRole);
    }
}
