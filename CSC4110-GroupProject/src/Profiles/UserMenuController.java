package Profiles;

import Profiles.Items.CheckTwoExpired;
import Profiles.Login.LoginValidation;
import Profiles.Login.LoginValidationGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class UserMenuController implements Initializable {
    String currentUserType = LoginValidationGUI.currentUserType;
    @FXML
    MenuItem createPurchaseOrderButton;
    @FXML
    MenuItem searchItemButton;
    @FXML
    MenuItem searchPurchaseOrderButton;
    @FXML
    MenuItem createItemButton;
    @FXML
    MenuItem deleteItemButton;
    @FXML
    MenuItem updateItemButton;
    @FXML
    MenuItem editCustomerButton;
    @FXML
    MenuItem createCustomerButton;
    @FXML
    MenuItem createCustomerOrderButton;
    @FXML
    MenuItem searchCustomerButton;
    @FXML
    MenuItem deleteCustomerButton;
    @FXML
    Button logoutButton;
    @FXML
    private MenuBar myMenuBar;
    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public void switchToCreateItemProfileSceneMenuBar(ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Items/CreateItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToSearchItemMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Items/SearchItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToDeleteItemMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Items/DeleteItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToUpdateItemMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Items/UpdateItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToPurchaseOrderMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("PurchaseOrder/CreatePurchaseOrder.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToPurchaseOrderViewMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("PurchaseOrder/PurchaseOrderView.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchCreateCustomerProfile(javafx.event.ActionEvent event) throws IOException {
        if(currentUserType.toUpperCase().equals("OWNER")) {
            Root = FXMLLoader.load(getClass().getResource("Customers/CreateCustomerProfile.fxml"));
            Stage = (Stage) myMenuBar.getScene().getWindow();
            Scene = new Scene(Root);
            Stage.setScene(Scene);
            Stage.show();
        }
        else{
            System.out.println("Incorrect User Type Access Denied");
            System.out.println(currentUserType);
        }
    }
    public void switchSearchCustomerProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Customers/SearchCustomerProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchDeleteCustomerProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Customers/DeleteCustomerProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchUpdateCustomerProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Customers/UpdateCustomerProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchCreateCustomerOrder(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Customers/CreateCustomerOrder.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToCreateUserProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Users/CreateUserProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToLoginValidation(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Login/Login.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToSearchUserProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Users/SearchUserProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToDeleteUserProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Users/DeleteUserProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToUpdateUserProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Users/UpdateUserProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToCreateItemProfileScene(ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../Items/CreateItemProfile.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToSearchItem(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../Items/SearchItemProfile.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //currentUserType = LoginValidation.loginCheckRole(LoginValidation.getUserID());
        LoginValidation.loginCheckRole(LoginValidation.getUserID());
        System.out.println(currentUserType);
        if(LoginValidationGUI.currentUserType.toUpperCase().equals("SALESPERSON")) {
            Boolean twoExpired = CheckTwoExpired.checkTwoExpired();
            if (twoExpired) {
                JOptionPane.showMessageDialog(null, "Two Or More Items are Expired.");
            }
        }
        switch(currentUserType){
            case "owner":
                System.out.println("user is owner");
                createCustomerButton.setDisable(false);
                editCustomerButton.setDisable(false);
                deleteCustomerButton.setDisable(false);
                searchCustomerButton.setDisable(false);
                createItemButton.setDisable(false);
                updateItemButton.setDisable(false);
                deleteItemButton.setDisable(false);
                searchItemButton.setDisable(false);
                break;
            case "administrator":
                System.out.println("user is administrator");
                searchItemButton.setDisable(false);
                break;
            case "inventoryManager":
                System.out.println("user is inventoryManager");
                createItemButton.setDisable(false);
                deleteItemButton.setDisable(false);
                break;
            case "purchaser":
                System.out.println("user is purchaser");
                createItemButton.setDisable(false);
                updateItemButton.setDisable(false);
                deleteItemButton.setDisable(false);
                searchItemButton.setDisable(false);
                searchPurchaseOrderButton.setDisable(false);
                createPurchaseOrderButton.setDisable(false);
                break;
            case "accountant":
                System.out.println("user is accountant");
                searchItemButton.setDisable(false);
                break;
            case "salesperson":
                System.out.println("user is salesperson");
                createCustomerOrderButton.setDisable(false);
                searchItemButton.setDisable(false);
                break;
            case "vendor":
                System.out.println("user is vendor");
                searchItemButton.setDisable(false);
                break;
            case "customer":
                System.out.println("user is customer");
                searchItemButton.setDisable(false);
                break;
            default:


        }

    }
}
