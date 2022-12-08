package Profiles.Users;

import Profiles.Login.LoginValidation;
import Profiles.ReadUserData;
import Profiles.UserList;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author David Her
 * Used code from Shijie Du's DeleteItemController
 */
public class DeleteUserProfileController implements Initializable {

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

    public void clearData(){
        dataList.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateData();
    }

    File oldFile = new File("UserData.csv");
    File tempFile = new File("UserDataTemp.csv");
    DeleteUserProfile deleteProfile = new DeleteUserProfile();
    public void confirmDeleteOnAction(ActionEvent e){

        //LoginValidation.deleteUserProfile(userInput);
        deleteProfile.delProfile(userIDInput.getText());

        oldFile.delete();
        File dump = new File("UserData.csv");
        tempFile.renameTo(dump);
        clearData();
        updateData();
    }

    public void switchBackToMenuButton(ActionEvent e) throws IOException {
        Parent Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }
}
