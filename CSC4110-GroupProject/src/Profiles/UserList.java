package Profiles;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author David Her
 * Used code from Shijie Du's ItemList.java
 */
public class UserList {
    private SimpleStringProperty userID, lastName, firstName, userRole;

    public String getUserID() {
        return userID.get();
    }
    public String getLastName() {
        return lastName.get();
    }
    public String getFirstName() {
        return firstName.get();
    }
    public String getUserRole() {
        return userRole.get();
    }

    UserList(String userID, String lastName, String firstName, String userRole){
        this.userID = new SimpleStringProperty(userID);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.userRole = new SimpleStringProperty(userRole);
    }
}
