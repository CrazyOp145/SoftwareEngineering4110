import Profiles.CustomerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SearchCustomerProfileController implements Initializable {

    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    @FXML
    private TextField searchCustomerBar;
    @FXML
    private TableView<CustomerList> tableView;
    @FXML
    private TableColumn<CustomerList, String> customerID;
    @FXML
    private TableColumn<CustomerList, String> companyName;
    @FXML
    private TableColumn<CustomerList, String>  streetAddress;
    @FXML
    private TableColumn<CustomerList, String>  city;
    @FXML
    private TableColumn<CustomerList, String>  state;
    @FXML
    private TableColumn<CustomerList, String>  phoneNumber;
    @FXML
    private TableColumn<CustomerList, String>  balance;
    @FXML
    private TableColumn<CustomerList, String>  lastPaidAmount;
    @FXML
    private TableColumn<CustomerList, String>  lastOrderDate;
    private ObservableList<CustomerList> dataList = FXCollections.observableArrayList();


    ReadCustomerProfile readCustomerProfile = new ReadCustomerProfile();

    public void updateList(){
        dataList = ReadCustomerProfile.initList();
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        streetAddress.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        lastPaidAmount.setCellValueFactory(new PropertyValueFactory<>("lastPaidAmount"));
        lastOrderDate.setCellValueFactory(new PropertyValueFactory<>("lastOrderDate"));
        tableView.setItems(dataList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
        FilteredList<CustomerList> filteredData = new FilteredList<>(dataList, b -> true);
        searchCustomerBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(CustomerList -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (CustomerList.getCustomerID().toString().indexOf(lowerCaseFilter) > -1 ) {
                    return true; // Filter matches first name.
                } else if (CustomerList.getCompanyName().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; // Filter matches last name.
                }
                else
                    return false; // Does not match.
            });
            tableView.setPlaceholder(new Label("The Customer "+ newValue +" profile is not found"));
        });
        SortedList<CustomerList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }


}