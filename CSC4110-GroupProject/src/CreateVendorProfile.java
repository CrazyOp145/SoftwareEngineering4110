import Profiles.ProfilesFactory;
import Profiles.VendorProfile;
import Profiles.UserProfiles;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

// @author Mahz Alam

public class CreateVendorProfile implements Initializable {
    String filePath = "VendorFile.csv";

    private String[] stateArray = {"AL", "AK", "AZ", "AR", "CA",
            "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
            "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

    @FXML
    private TextField vendorName;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private ChoiceBox<String> state;
    @FXML
    private TextField balance;
    @FXML
    private TextField phone;
    @FXML
    private Label errorMessage;


    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public CreateVendorProfile(){
        state = new ChoiceBox<>(FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA",
                "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
                "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
        state.getItems();
    }

    public void createVendorProfile(ActionEvent actionEvent) throws IOException {
        ProfilesFactory profFactory = new ProfilesFactory();
        Random random = new Random(); //Random functionality borrowed from David Her
        String vendID = "v" + String.valueOf((random.nextInt(99999)));
        String vendName = vendorName.getText();
        String str = street.getText();
        String c = city.getText();
        String ste = state.getValue();
        String ph = phone.getText();
        //double bal = balance.getText();


        boolean correct = false;

        Pattern phonePattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");

       /* int incorrectCount = 0;
        if (vendName.length() > 20 || vendName.length() == 0) {
            incorrectCount++;
            errorM.setText("Company Name Invalid, must be between 1 to 20 Characters");
        }else{
            incorrectCount--;
        }
        if(str.length() > 20 || str.length() == 0){
            incorrectCount++;
            errorM.setText("Street Invalid, must be between 1 to 20 Characters");
        }else{
            incorrectCount--;
        }
        if(ph.matches(phonePattern.pattern())){
            incorrectCount--;
        }else{
            incorrectCount++;
        }
*/
        UserProfiles vendorTemp = profFactory.createProfile("VENDOR");
        if(vendorTemp instanceof VendorProfile) {
            VendorProfile vendor = new VendorProfile();

            vendor.setID(vendID);
            vendor.setFirstName(vendName);
            vendor.setStreet(str);
            vendor.setCity(c);
            vendor.setState(ste);
            vendor.setPhone(ph);

            FileWriter fileWrite = new FileWriter(filePath, true);
            BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
            PrintWriter printW = new PrintWriter(bufferWrite);
            printW.println(vendor.getCustomerID() + "," + vendor.getCompanyName() + "," + vendor.getStreetAddress()
                    + "," + vendor.getCity() + "," + vendor.getState() + ",");
            System.out.println(vendor.getState());
            printW.flush();
            printW.close();
            JOptionPane.showMessageDialog(null, "Vendor Account Created");
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
        state.getItems().addAll(stateArray);
    }
}
