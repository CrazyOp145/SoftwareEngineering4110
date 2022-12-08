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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class DeleteCustomerProfileController implements Initializable {
    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;
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
    @FXML
    private TextField deleteCustomerBar;
    String filePath = "CustomerProfiles.csv";
    String temp = "temp.csv";

    private ObservableList<CustomerList> dataList = FXCollections.observableArrayList();

    ReadCustomerProfile readCustomerProfile = new ReadCustomerProfile();

    DeleteCustomerProfile deleteCustomerProfile = new DeleteCustomerProfile();


    File oldFile = new File(filePath);
    File newFile = new File(temp);
    public void deleteProfile(){
        deleteCustomerProfile.deleteCustomerProfile(filePath,deleteCustomerBar.getText());

        oldFile.delete();
        File dump = new File(filePath);
        newFile.renameTo(dump);
        dump.exists();


        //tableView.setItems(dataList);
        clearList();
        updateList();
    }

    public void clearList(){
        dataList.clear();
    }
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
    }

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        clearList();
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }


}
