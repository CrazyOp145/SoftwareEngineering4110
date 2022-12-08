package Profiles.Vendor;

import Profiles.ProfilesFactory;
import Profiles.UserProfiles;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateVendorProfile implements Initializable {
    String filePath = "ItemProfile.csv";

    @FXML
    private TextField vendorName;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private TextField state;
    @FXML
    private TextField balance;


    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public void create(ActionEvent actionEvent) {
        ProfilesFactory profFactory = new ProfilesFactory();
        String vendName = vendorName.getText();
        String str = street.getText();
        String c = city.getText();
        String ste = state.getText();
        double bal;

        UserProfiles vendor = profFactory.createProfile("VENDOR");
        vendor.setFirstName(vendName);
        vendor.setStreet(str);
        vendor.setCity(c);
        vendor.setState(ste);
        


    }

    public void switchToUserMenuScene(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
