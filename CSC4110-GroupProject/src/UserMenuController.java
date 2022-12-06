import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;



/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class UserMenuController {
    @FXML
    private MenuBar myMenuBar;
    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public void switchToCreateItemProfileSceneMenuBar(ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreateItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToSearchItemMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("SearchItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToDeleteItemMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("DeleteItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToUpdateItemMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UpdateItemProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToPurchaseOrderMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreatePurchaseOrder.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToPurchaseOrderViewMenuBar(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("PurchaseOrderView.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchCreateCustomerProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreateCustomerProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchToVendorProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreateVendorProfile.fxml"));
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchSearchCustomerProfile(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("SearchCustomerProfile.fxml"));
        //Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage = (Stage)myMenuBar.getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void switchToCreateItemProfileScene(ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreateItemProfile.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public void switchToSearchItem(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("SearchItemProfile.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

}
