package Profiles.Users;

import Profiles.Login.LoginValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Profiles.Login.CheckInputs.*;
/**
 * @author David Her
 */
public class CreateUserProfileController implements Initializable {
    @FXML private TextField userIDTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField passwordTextField;
    @FXML private ChoiceBox<String> userRoleChoiceBox;
    @FXML private Text userIDChecks;
    @FXML private Text lastNameChecks;
    @FXML private Text firstNameChecks;
    @FXML private Text passwordChecks;
    @FXML private Text userRoleChecks;
    private String[] role =
            {UserRoles.owner.name(), UserRoles.administrator.name(),
                    UserRoles.inventoryManager.name(), UserRoles.purchaser.name(),
                    UserRoles.salesperson.name(), UserRoles.accountant.name()};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        userRoleChoiceBox.getItems().addAll(role);
    }

    public void cancelButtonOnAction(ActionEvent event) throws IOException {
        Parent Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }

    public void confirmButtonOnAction(ActionEvent event) throws IOException{
        String userIDInput = userIDTextField.getText();
        String lastNameInput = lastNameTextField.getText();
        String firstNameInput = firstNameTextField.getText();
        String passwordInput = passwordTextField.getText();
        String userRoleInput = userRoleChoiceBox.getValue();

        boolean userIDCheck = checkUserIDInput(userIDInput);
        boolean lastNameCheck = checkNameInput(lastNameInput);
        boolean firstNameCheck = checkNameInput(firstNameInput);
        boolean passwordCheck = checkPasswordInput(passwordInput);

        if(userIDCheck && lastNameCheck && firstNameCheck && passwordCheck && userRoleInput != null) {
            LoginValidation.createUserProfiles(userIDInput,
                    lastNameInput,
                    firstNameInput,
                    passwordInput,
                    userRoleInput);
            JOptionPane.showMessageDialog(null, "User has been created!");
            userIDTextField.clear();
            lastNameTextField.clear();
            firstNameTextField.clear();
            passwordTextField.clear();
            userRoleChoiceBox.getItems().clear();
            userIDChecks.setText("");
            lastNameChecks.setText("");
            firstNameChecks.setText("");
            passwordChecks.setText("");
            userRoleChecks.setText("");
        }
        else if(!userIDCheck){
            userIDChecks.setText("Error: Invalid User ID");
            lastNameChecks.setText("");
            firstNameChecks.setText("");
            passwordChecks.setText("");
            userRoleChecks.setText("");
        }
        else if(!lastNameCheck){
            lastNameChecks.setText("Error: Invalid Last Name");
            userIDChecks.setText("");
            firstNameChecks.setText("");
            passwordChecks.setText("");
            userRoleChecks.setText("");
        }
        else if(!firstNameCheck){
            firstNameChecks.setText("Error: Invalid First Name");
            userIDChecks.setText("");
            lastNameChecks.setText("");
            passwordChecks.setText("");
            userRoleChecks.setText("");
        }
        else if(!passwordCheck){
            passwordChecks.setText("Error: Invalid Password");
            userIDChecks.setText("");
            lastNameChecks.setText("");
            firstNameChecks.setText("");
            userRoleChecks.setText("");
        }
        else if(userRoleInput == null){
            userRoleChecks.setText("Error: Invalid User Role");
            userIDChecks.setText("");
            lastNameChecks.setText("");
            firstNameChecks.setText("");
            passwordChecks.setText("");
        }
    }
}
