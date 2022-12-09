package Profiles.Vendor;

import Profiles.CustomerList;
import Profiles.ProfilesFactory;
import Profiles.VendorProfile;
import Profiles.UserProfiles;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

// @author Mahz Alam
public class UpdateVendorProfileController {

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
    private  TextField balance;
    @FXML
    private TextField phone;
    @FXML
    private Label errorMessage;
    @FXML
    private DatePicker date;

    //Table Stuff
    @FXML
    private TableView<VendorList> tableView;
    @FXML
    private TableColumn<VendorList, String> VendIDTable;
    @FXML
    private TableColumn<VendorList, String> vendNameTable;
    @FXML
    private TableColumn<VendorList, String>  streetTable;
    @FXML
    private TableColumn<VendorList, String>  cityTable;
    @FXML
    private TableColumn<VendorList, String>  stateTable;
    @FXML
    private TableColumn<VendorList, String>  phoneTable;
    @FXML
    private TableColumn<VendorList, String>  balanceTable;
    @FXML
    private TableColumn<VendorList, String>  lastPaidAmountT;
    @FXML
    private TableColumn<VendorList, String>  lastOrderDateT;
    @FXML
    private TableColumn<VendorList, String> seasDiscDateT;
    private ObservableList<VendorList> dataList = FXCollections.observableArrayList();
    String temp = "tempVendor.csv";
    private VendorList vendor;

    public void updateVendor(){
        if(this.vendor == null){
            JOptionPane.showMessageDialog(null, "Please select a vendor profile to update.");
            return;
        }

        ProfilesFactory profFactory = new ProfilesFactory();
        Random random = new Random(); //Random functionality borrowed from David Her
        String vendID = String.valueOf((random.nextInt(999999)));
        String vendName = vendorName.getText();
        String str = street.getText();
        String c = city.getText();
        String ste = state.getValue();
        String ph = phone.getText();
        LocalDate seasonalDisc = date.getValue();
        String bal = balance.getText();

        String truBal = bal.replaceAll("[^0-9]", "");
        Pattern phonePattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");

        boolean correct = true;

        if ((vendName.length() > 20 || vendName.length() == 0)) {
            errorMessage.setText("Error: Vendor Name too Long");
            System.out.println("Name too long please enter a name that is less than 20 characters.");
            correct = false;
        }
        if (str.length() > 20 || str.length() == 0) {
            errorMessage.setText("Error: Street Address too Long");
            System.out.println("Address did not meet requirements.");
            correct = false;
        }
        if (c.length() > 20 || c.length() == 0) {
            errorMessage.setText("Error: City Name too Long");
            System.out.println("City name did not meet requirements.");
            correct = false;
        }
        if (state == null) {
            errorMessage.setText("Error: Please Select A State");
            System.out.println("State does not have an input.");
            correct = false;
        }
        if (ph.matches(phonePattern.pattern()) && ph != null) {
        } else {
            correct = false;
            errorMessage.setText("Error: Phone number format incorrect, please input as xxx xxx xxxx");
            System.out.println("Phone Number format incorrect.");
        }

        clearList();
        updateList();
    }

    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public void clearList(){
        dataList.clear();
    }

    public void selectCell(){
        vendor = tableView.getSelectionModel().getSelectedItem();
    }

    public void updateList(){
        dataList = ReadVendorFile.initList();
        VendIDTable.setCellValueFactory(new PropertyValueFactory<>("vendorID"));
        vendNameTable.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        streetTable.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        cityTable.setCellValueFactory(new PropertyValueFactory<>("city"));
        stateTable.setCellValueFactory(new PropertyValueFactory<>("state"));
        phoneTable.setCellValueFactory(new PropertyValueFactory<>("phone"));
        balanceTable.setCellValueFactory(new PropertyValueFactory<>("balance"));
        lastPaidAmountT.setCellValueFactory(new PropertyValueFactory<>("lastPaidAmount"));
        lastOrderDateT.setCellValueFactory(new PropertyValueFactory<>("lastOrderDate"));
        seasDiscDateT.setCellValueFactory(new PropertyValueFactory<>("SeasDiscDate"));
        tableView.setItems(dataList);
    }

    public void switchToUserMenuScene (javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
}
