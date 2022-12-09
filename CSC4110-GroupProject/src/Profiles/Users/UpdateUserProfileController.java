package Profiles.Users;

import Profiles.Login.CheckInputs;
import Profiles.ReadUserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUserProfileController implements Initializable {

    @FXML private TextField lName;
    @FXML private TextField fName;
    @FXML private TextField password;
    @FXML private ChoiceBox<String> userRole;
    @FXML private Text message;
    @FXML private TableView<UserList> table;
    @FXML private TableColumn<UserList, String> userIDCol;
    @FXML private TableColumn<UserList, String> lastNameCol;
    @FXML private TableColumn<UserList, String> firstNameCol;
    @FXML private TableColumn<UserList, String> passwordCol;
    @FXML private TableColumn<UserList, String> userRoleCol;
    private ObservableList<UserList> dataList = FXCollections.observableArrayList();
    private UserList userList;
    String[] roles =
            {UserRoles.owner.name(), UserRoles.administrator.name(),
                    UserRoles.inventoryManager.name(), UserRoles.purchaser.name(),
                    UserRoles.salesperson.name(), UserRoles.accountant.name()};
    private String lNameInput,fNameInput,passwordInput,userRoleInput;

    File oldFile = new File("UserData.csv");
    File tempFile = new File("UserDataTemp.csv");

    public void updateOnAction(ActionEvent e){
        if(this.userList == null){
            JOptionPane.showMessageDialog(null, "You have to select a Customer Profile to change.");
            return;
        }

        lNameInput = lName.getText();
        fNameInput = fName.getText();
        passwordInput = password.getText();
        userRoleInput = userRole.getValue();

        boolean lastNameCheck = CheckInputs.checkNameInput(lNameInput);
        boolean firstNameCheck = CheckInputs.checkNameInput(fNameInput);
        boolean passwordCheck = CheckInputs.checkPasswordInput(passwordInput);

        if(lastNameCheck && firstNameCheck && passwordCheck){
            UpdateUserProfile updateUserProfile = new UpdateUserProfile();
            updateUserProfile.updateProfile(userList.getUserID(),lNameInput, fNameInput, passwordInput, userRoleInput);
        }
        else if(!lastNameCheck){
            message.setText("Error: Invalid Last Name");
        }
        else if(!firstNameCheck){
            message.setText("Error: Invalid First Name");
        }
        else if(!passwordCheck){
            message.setText("Error: Invalid Password");
        }
        else{
            message.setText("Error: Invalid User Role");
        }
        oldFile.delete();
        File dump = new File("UserData.csv");
        tempFile.renameTo(dump);
        clearData();
        updateData();
    }

    public void updateData(){
        ReadUserData readUserData = new ReadUserData();
        dataList = readUserData.initList();
        userIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        userRoleCol.setCellValueFactory(new PropertyValueFactory<>("userRole"));
        table.setItems(dataList);
    }

    public void clearData(){
        dataList.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateData();
        userRole.getItems().addAll(roles);
    }

    public void selectCell(){
        userList = table.getSelectionModel().getSelectedItem();
    }

    public void switchBackToMenuButton(ActionEvent e) throws IOException {
        Parent Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }
}
