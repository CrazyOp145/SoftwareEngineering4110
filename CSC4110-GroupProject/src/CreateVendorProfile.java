import Profiles.ProfilesFactory;
import Profiles.UserProfiles;
import Profiles.VendorProfile;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

// @author Mahz Alam

public class CreateVendorProfile implements Initializable {
    String filePath = "VendorFile.csv";

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

    public void createVendorProfile(ActionEvent actionEvent) {
        ProfilesFactory profFactory = new ProfilesFactory();
        String vendName = vendorName.getText();
        String str = street.getText();
        String c = city.getText();
        String ste = state.getText();
        //double bal = balance.getText();

        UserProfiles vendor = profFactory.createProfile("VENDOR");
        vendor.setFirstName(vendName);
        vendor.setStreet(str);
        vendor.setCity(c);
        vendor.setState(ste);

        try{
            FileWriter fileWrite = new FileWriter(filePath, true);
            BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
            PrintWriter printW = new PrintWriter(bufferWrite);

            printW.println(vendor.getCustomerID() + "," + vendor.getCompanyName() + "," + vendor.getStreetAddress()
                   + " " + vendor.getCity() + " " + vendor.getState());
            printW.flush();
            printW.close();
            JOptionPane.showMessageDialog(null, "Vendor Account Created");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Failed To Create Vendor Account");
        }
    }

    public void switchToUserMenuScene(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
