
import Profiles.CustomerProfile;
//import csvFiles.WriteToCustomerProfileCSV;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CreateCustomerProfileController implements Initializable {
    String filePath = "CustomerProfiles.csv";
    @FXML
    private TextField companyNameTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField cityTF;
    @FXML
    private ChoiceBox<String> stateCB;
    @FXML
    private TextField phoneNumberTF;
    @FXML
    private Label errorMessage;
    private String[] stateArray = {"AL", "AK", "AZ", "AR", "CA",
            "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
            "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    private String companyName;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private boolean validityChecker;
    private Stage Stage;
    private Scene Scene;
    private Parent Root;
    public CreateCustomerProfileController(){
        stateCB = new ChoiceBox<>(FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA",
                "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
                "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
        stateCB.getItems();
    }
    public void submitCustomerProfile(ActionEvent event) throws IOException {
        validityChecker = true;
        Random randID = new Random();
        String customerID = String.valueOf(randID.nextInt(999999));
        Pattern phonePattern = Pattern.compile("^([0-9]{3}-){2}[0-9]{4}$");
        companyName = companyNameTF.getText();
        address = addressTF.getText();
        city = cityTF.getText();
        phoneNumber = phoneNumberTF.getText();
        state = stateCB.getValue();
        if ((companyName.length() > 21 && companyName.length() == 0)) {
            validityChecker = false;
            errorMessage.setText("Error: Company Name too Long");
            System.out.println("Name too long please enter a name that is less than 20 characters.");
        }
        if (address.length() > 21 && address.length() == 0) {
            validityChecker = false;
            errorMessage.setText("Error: address too Long");
            System.out.println("Address did not meet requirements.");
        }
        if (city.length() > 21 && city.length() == 0) {
            validityChecker = false;
            errorMessage.setText("Error: City name too Long");
            System.out.println("City name did not meet requirements.");
        }
        if (state == null) {
            validityChecker = false;
            errorMessage.setText("Error: Please Select A State");
            System.out.println("State too long please enter a state that is less than 20 characters.");
        }
        if (phoneNumber.matches(phonePattern.pattern())) {
        } else {
            validityChecker = false;
            errorMessage.setText("Error: Phone number format incorrect");
            System.out.println("Phone Number format incorrect. Please enter a valid phone number.");
        }
        if (validityChecker){
            CustomerProfile newProfile = new CustomerProfile(customerID, companyName, address, city, state, phoneNumber);
            System.out.println(newProfile.toString());
            String[] CustomerProfileData = {newProfile.getCustomerID(), newProfile.getCompanyName(), newProfile.getCity(),
                newProfile.getState(), newProfile.getStreetAddress(), newProfile.getPhone(), Double.toString(newProfile.getBalance()),
                Double.toString(newProfile.getLastPaidAmount()), newProfile.getLastOrderDate()};
            FileWriter fw = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(newProfile.getCustomerID()+","+newProfile.getCompanyName()+","+newProfile.getStreetAddress()+","+ newProfile.getCity()
                    +","+newProfile.getState()+","+newProfile.getPhone()+","+ newProfile.getBalance() +","+newProfile.getLastPaidAmount()+","+newProfile.getLastOrderDate());
            pw.flush();
            pw.close();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stateCB.getItems().addAll(stateArray);
    }
    public void switchToUserMenuScene(javafx.event.ActionEvent event) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource(""))
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
}
