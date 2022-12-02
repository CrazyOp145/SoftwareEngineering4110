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
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreatePurchaseOrderController implements Initializable {
    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;
    @FXML
    private TableView<ItemList> tableView;
    @FXML
    private TableColumn<ItemList, String> itemId;
    @FXML
    private TableColumn<ItemList, String>  itemName;
    @FXML
    private TableColumn<ItemList, String>  quantity;
    @FXML
    private TableColumn<ItemList, String>  sellingPrice;
    @FXML
    private TableColumn<ItemList, String>  purchasePrice;
    @FXML
    private TableColumn<ItemList, String>  expireDate;
    @FXML
    private TextField purchaseQuantity;
    @FXML
    private DatePicker needDate;
    int purchaseId = PurchaseIdProvider.getInstance().getUniqueId();;
    String filePath = "PurchaseOrder"+ purchaseId +".csv";
    String temp = "temp.csv";

    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();
    //private ObservableList<PurchaseOrderList> dataList = FXCollections.observableArrayList();
    //private ArrayList<PurchaseOrderList> purchaseOrderList = new ArrayList<PurchaseOrderList>();
    private ArrayList<ItemList> purchaseOrderList = new ArrayList<ItemList>();
    ReadItemProfile readItemProfile = new ReadItemProfile();
    PurchaseOrderList purchaseItem;
    ItemList item;

    File oldFile = new File(filePath);
    File newFile = new File(temp);

    public void clearList(){
        dataList.clear();
    }
    public void updateList(){
        dataList = readItemProfile.initList();
        itemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        sellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        purchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        expireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        tableView.setItems(dataList);
    }
    public void selectCell(){
        item = tableView.getSelectionModel().getSelectedItem();
        item.setNeedQuantity(purchaseQuantity.getText());
        item.setNeedDate(String.valueOf(needDate.getValue()));
    }

    public void vendorList(){

        updateList();
    }

    public void addToOrder(){
        //purchaseOrderList.add(purchaseItem);
        purchaseOrderList.add(item);
        purchaseQuantity.clear();
        needDate.getEditor().clear();
    }
    public void createOrder(){
        for (ItemList purchaseItem: purchaseOrderList
        ) {
            try{
                FileWriter fw = new FileWriter(filePath,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(purchaseItem.getItemId()+","+purchaseItem.getItemName()+","+purchaseItem.getPurchasePrice()
                        +","+purchaseItem.getExpireDate() +","+purchaseItem.needQuantity+","+purchaseItem.needDate);
                pw.flush();
                pw.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Unable to create purchase order...");
            }
        }
        JOptionPane.showMessageDialog(null, "Your purchase order has been created!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
    }

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (javafx.stage.Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

}
