package Profiles.Vendor;

import Profiles.Vendor.VendorList;
import Profiles.Vendor.ReadVendorFile;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchVendorProfileController implements Initializable {
    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    @FXML
    private TextField searchVendor;
    @FXML
    private TableView<VendorList> tableView;
    @FXML
    private TableColumn<VendorList, String> vendID;
    @FXML
    private TableColumn<VendorList, String> vendorName;
    @FXML
    private TableColumn<VendorList, String>  street;
    @FXML
    private TableColumn<VendorList, String>  city;
    @FXML
    private TableColumn<VendorList, String>  state;
    @FXML
    private TableColumn<VendorList, String>  phone;
    @FXML
    private TableColumn<VendorList, String>  balance;
    @FXML
    private TableColumn<VendorList, String>  lastPaidAmount;
    @FXML
    private TableColumn<VendorList, String>  lastOrderDate;
    @FXML
    private TableColumn<VendorList, String> seasDiscDate;
    private ObservableList<VendorList> dataList = FXCollections.observableArrayList();


    ReadVendorFile readVendorFile = new ReadVendorFile();
    public void clearList(){
        dataList.clear();
    }
    public void updateList(){
        dataList = ReadVendorFile.initList();
        vendID.setCellValueFactory(new PropertyValueFactory<>("vendID"));
        vendorName.setCellValueFactory(new PropertyValueFactory<>("vendName"));
        street.setCellValueFactory(new PropertyValueFactory<>("street"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        lastPaidAmount.setCellValueFactory(new PropertyValueFactory<>("lastPaidAmount"));
        lastOrderDate.setCellValueFactory(new PropertyValueFactory<>("lastOrderDate"));
        seasDiscDate.setCellValueFactory(new PropertyValueFactory<>("seasDiscDate"));
        tableView.setItems(dataList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
        FilteredList<VendorList> filteredData = new FilteredList<>(dataList, b -> true);
        searchVendor.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(VendorList -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (VendorList.getID().toString().indexOf(lowerCaseFilter) > -1 ) {
                    return true; // Filter matches first name.
                } else if (VendorList.getCompanyName().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; // Filter matches last name.
                }
                else
                    return false; // Does not match.
            });
            tableView.setPlaceholder(new Label("The Vendor "+ newValue +" profile is not found"));
        });
        SortedList<VendorList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    public void switchToUserMenuScene (javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
}
