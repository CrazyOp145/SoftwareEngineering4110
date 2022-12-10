package Profiles.Customers;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateCustomerInvoiceController implements Initializable {
    @FXML
    private TextField searchCustomerBar;
    @FXML
    private TextField selectCustomerID;
    @FXML
    private TableView<CustomerList> tableView;
    @FXML
    private TableColumn<CustomerList, String> itemID;
    @FXML
    private TableColumn<CustomerList, String> itemName;
    @FXML
    private TableColumn<CustomerList, String>  quantity;
    @FXML
    private TableColumn<CustomerList, String>  sellingPrice;
    @FXML
    private TableColumn<CustomerList, String>  purchasePrice;
    @FXML
    private TableColumn<CustomerList, String>  expireDate;

    private ObservableList<CustomerList> dataList = FXCollections.observableArrayList();

    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;

    ReadCustomerOrder readCustomerOrder = new ReadCustomerOrder();
    public void clearList(){
        dataList.clear();
    }
    public void updateList(){
        dataList = ReadCustomerOrder.initList();
        itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        sellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        purchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        expireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
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


    public void switchToUserMenuScene (javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

}
