package Profiles.Users;

import Profiles.ReadUserData;
import Profiles.UserList;
import Profiles.UserProfiles;
import csvFiles.ToUserDataCSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author David Her
 * Used code from Shijie Du's Code SearchItemController.java
 */

public class SearchUserProfileController implements Initializable {
    @FXML private TextField userIDInput;
    @FXML private TableView<UserList> table;
    @FXML private TableColumn<UserList, String> userID;
    @FXML private TableColumn<UserList, String> lName;
    @FXML private TableColumn<UserList, String> fName;
    @FXML private TableColumn<UserList, String> userRole;
    private ObservableList<UserList> dataList = FXCollections.observableArrayList();

    public void updateData(){
        ReadUserData readUserData = new ReadUserData();

        dataList = readUserData.initList();
        userID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        userRole.setCellValueFactory(new PropertyValueFactory<>("userRole"));
        table.setItems(dataList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateData();
        FilteredList<UserList> filteredData = new FilteredList<>(dataList, b -> true);
        userIDInput.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(UserList -> {
                // If filter text is empty, display all
                if (newValue == null || newValue.isEmpty()) return true;

                // Compare every column with the
                String lowerCaseFilter = newValue.toLowerCase();

                if (UserList.getUserID().contains(lowerCaseFilter))
                    return true; // Filter matches userID

                else if (UserList.getLastName().toLowerCase().contains(lowerCaseFilter))
                    return true; // Filter matches last name

                else if (UserList.getFirstName().toLowerCase().contains(lowerCaseFilter))
                    return true; // Filter matches first name

                else return String.valueOf(UserList.getUserRole()).contains(lowerCaseFilter); // Filter matches user Role
            });
            table.setPlaceholder(new Label("The User "+ newValue +" was not found"));
        });
        SortedList<UserList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    public void switchBackToMenuButton(ActionEvent e) throws IOException {
        Parent Root = FXMLLoader.load(getClass().getResource("../../UserMenu.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }
}
