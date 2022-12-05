package Profiles.Login;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.*;

public class LoginController {

    @FXML private Button exitButton;
    @FXML private Button loginButton;
    @FXML private TextField userIDTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Text loginMessageLabel;

    public void exitButtonOnAction(ActionEvent e){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent e){

        String userIDInput = userIDTextField.getText();
        String passwordInput = passwordTextField.getText();

        boolean LoginCheck = LoginValidation.loginCheck(userIDInput,passwordInput);
        if(LoginCheck){
            loginMessageLabel.setText("Login Successful");
        }
        else {
            loginMessageLabel.setText("Error: Invalid User ID or Password");
        }
    }
}
