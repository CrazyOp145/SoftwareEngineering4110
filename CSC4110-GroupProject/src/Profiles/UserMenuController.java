package Profiles;

import Profiles.Login.LoginValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class UserMenuController implements Initializable {
    String currentUserType;

    @FXML
    MenuItem CreatePurchaseOrderButton;
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
        Root = FXMLLoader.load(getClass().getResource("Customers/CreateCustomerProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchToCreateVendorProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreateVendorProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
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
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchCreateCustomerOrder(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Customers/CreateCustomerOrder.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToDeleteUserProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("Users/DeleteUserProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        LoginValidation.loginCheckRole(LoginValidation.getUserID());
        //System.out.println(currentUserType);
        if(currentUserType == "owner"){
            CreatePurchaseOrderButton.setDisable(true);
        }
    }

    public void getUsertype(String user){
        currentUserType = user;
    }
}
