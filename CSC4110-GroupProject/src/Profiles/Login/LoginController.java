package Profiles.Login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.io.IOException;
/**
 * @author David Her
 */
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

    public void loginButtonOnAction(ActionEvent event) throws IOException {

        String userIDInput = userIDTextField.getText();
        String passwordInput = passwordTextField.getText();



        boolean LoginCheck = LoginValidation.loginCheck(userIDInput,passwordInput);
        if(LoginCheck){
            loginMessageLabel.setText("Login Successful");
            Parent root = FXMLLoader.load(getClass().getResource("../../UserMenu.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            loginMessageLabel.setText("Error: Invalid User ID or Password");
        }
    }
}
