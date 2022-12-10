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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

//@author Mahz Alam

public class CreateCustomerInvoiceController implements Initializable {
    @FXML
    private TextField searchCustomerBar;
    @FXML
    private TextField selectCustomerName;


    private ObservableList<CustomerList> dataList = FXCollections.observableArrayList();

    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;

    ReadCustomerOrder readCustomerOrder = new ReadCustomerOrder();
    public void clearList(){
        dataList.clear();
    }

    public void createInvoice(){
        //ReadCustomerOrder readCustomerOrder = new ReadCustomerOrder();

        ReadCustomerOrder.initList(selectCustomerName.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void switchToUserMenuScene (javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

}
