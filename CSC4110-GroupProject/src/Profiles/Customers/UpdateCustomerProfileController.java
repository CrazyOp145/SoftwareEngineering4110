package Profiles.Customers;

import Profiles.CustomerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class UpdateCustomerProfileController implements Initializable {
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
    private TextField balanceFT;
    @FXML
    private DatePicker lastPurchaseDateDP;
    @FXML
    private TextField lastPurchasePriceTF;
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
    private String balance;
    private String lastPurchasePrice;
    private String lastPurchaseDate;
    private boolean validityChecker;
    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;
    //list view variables
    @FXML
    private TableView<CustomerList> tableView;
    @FXML
    private TableColumn<CustomerList, String> customerID;
    @FXML
    private TableColumn<CustomerList, String> companyNameT;
    @FXML
    private TableColumn<CustomerList, String>  streetAddressT;
    @FXML
    private TableColumn<CustomerList, String>  cityT;
    @FXML
    private TableColumn<CustomerList, String>  stateT;
    @FXML
    private TableColumn<CustomerList, String>  phoneNumberT;
    @FXML
    private TableColumn<CustomerList, String>  balanceT;
    @FXML
    private TableColumn<CustomerList, String>  lastPaidAmountT;
    @FXML
    private TableColumn<CustomerList, String>  lastOrderDateT;
    private ObservableList<CustomerList> dataList = FXCollections.observableArrayList();
    String temp = "tempCustomerProfiles.csv";
    private CustomerList customer;

    ReadCustomerProfile readCustomerProfile = new ReadCustomerProfile();

    UpdateCustomerProfile updateCustomerProfile = new UpdateCustomerProfile();


    File oldFile = new File(filePath);
    File newFile = new File(temp);

    public void updateProfile() {
        if(this.customer == null){
            JOptionPane.showMessageDialog(null, "You have to select a Customer Profile to change.");
            return;
        }
        validityChecker = true;
        Pattern phonePattern = Pattern.compile("^([0-9]{3}-){2}[0-9]{4}$");
        companyName = companyNameTF.getText();
        address = addressTF.getText();
        city = cityTF.getText();
        phoneNumber = phoneNumberTF.getText();
        state = stateCB.getValue();
        balance = balanceFT.getText();
        lastPurchasePrice = lastPurchasePriceTF.getText();
        lastPurchaseDate = String.valueOf(lastPurchaseDateDP.getValue());
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
        if (phoneNumber.matches(phonePattern.pattern()) && phoneNumber != null) {
        } else {
            validityChecker = false;
            errorMessage.setText("Error: Phone number format incorrect");
            System.out.println("Phone Number format incorrect. Please enter a valid phone number.");
        }
        if(lastPurchaseDate == null){
            validityChecker = false;
            errorMessage.setText("Error: Enter a last purchase date format incorrect");
        }
        try
        {
            Double.parseDouble(balance);
        }
        catch(NumberFormatException e)
        {
            validityChecker = false;
            errorMessage.setText("Error: Enter a double please. for balance please.");
        }
        try
        {
            Double.parseDouble(lastPurchasePrice);
        }
        catch(NumberFormatException e)
        {
            validityChecker = false;
            errorMessage.setText("Error: Enter a double please. for last purchase price please.");
        }
        if(validityChecker) {
            updateCustomerProfile.updateCustomerProfile(filePath,customer.getCustomerID(),companyName,address,city,state,
                    phoneNumber,balance,lastPurchasePrice,lastPurchaseDate);
        }
        File dump = new File(filePath);
        newFile.renameTo(dump);
        clearList();
        updateList();
    }

    public void updateList(){
        dataList = ReadCustomerProfile.initList();
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        companyNameT.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        streetAddressT.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        cityT.setCellValueFactory(new PropertyValueFactory<>("city"));
        stateT.setCellValueFactory(new PropertyValueFactory<>("state"));
        phoneNumberT.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        balanceT.setCellValueFactory(new PropertyValueFactory<>("balance"));
        lastPaidAmountT.setCellValueFactory(new PropertyValueFactory<>("lastPaidAmount"));
        lastOrderDateT.setCellValueFactory(new PropertyValueFactory<>("lastOrderDate"));
        tableView.setItems(dataList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
        stateCB.getItems().addAll(stateArray);
    }

    public void selectCell(){
        customer = tableView.getSelectionModel().getSelectedItem();
    }
    public void clearList(){
        dataList.clear();
    }
    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        clearList();
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
}

