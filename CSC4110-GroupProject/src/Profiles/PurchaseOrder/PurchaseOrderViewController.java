package Profiles.PurchaseOrder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class PurchaseOrderViewController implements Initializable {
    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;

    @FXML
    private TableView<PurchaseOrderList> tableView;
    @FXML
    private TableColumn<PurchaseOrderList, String> itemId;
    @FXML
    private TableColumn<PurchaseOrderList, String>  itemName;
    @FXML
    private TableColumn<PurchaseOrderList, String>  quantity;
    @FXML
    private TableColumn<PurchaseOrderList, String>  needDate;
    @FXML
    private TableColumn<PurchaseOrderList, String>  purchasePrice;
    @FXML
    private TableColumn<PurchaseOrderList, String>  expireDate;
    @FXML
    private TableColumn<PurchaseOrderList, String>  subtotal;
    @FXML
    private TextField searchOrderBar;
    String filePath;

    private ObservableList<PurchaseOrderList> dataList = FXCollections.observableArrayList();
    ReadPurchaseOrder readPurchaseOrder = new ReadPurchaseOrder();

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (javafx.stage.Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
    public void updateList(){
        tableView.getItems().clear();
        filePath = "PurchaseOrder" + searchOrderBar.getText() + ".csv";
        dataList = readPurchaseOrder.initList(filePath);
        itemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        purchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        expireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        needDate.setCellValueFactory(new PropertyValueFactory<>("needDate"));
        subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        tableView.setItems(dataList);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTableColumnDecimalPlace();
    }

    public void setTableColumnDecimalPlace(){
        subtotal.setCellFactory(c -> new TableCell<>() {
            @Override
            protected void updateItem(String subtotal, boolean empty) {
                super.updateItem(subtotal, empty);
                if (subtotal == null || empty) {
                    setText(null);
                } else {
                    setText(String.format("%.2f", Double.parseDouble(subtotal)));
                }
            }
        });
    }
}