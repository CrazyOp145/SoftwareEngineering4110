package Profiles.PurchaseOrder;
import Profiles.Items.ReadVendorId;
import Profiles.Items.ItemList;
import Profiles.Items.ReadItemProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class CreatePurchaseOrderController implements Initializable {
    ReadVendorId RVI = new ReadVendorId();
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

    @FXML
    private ComboBox<String> vendorId;
    private List<String> vendorList = RVI.initList();

    CalculatePurchaseOrderTotalCost calculatePurchaseOrderTotalCost = new CalculatePurchaseOrderTotalCost();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    int addToOrderCounter = 0;
    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();
    //private ObservableList<PurchaseOrderList> dataList = FXCollections.observableArrayList();
    //private ArrayList<PurchaseOrderList> purchaseOrderList = new ArrayList<PurchaseOrderList>();
    private ArrayList<ItemList> purchaseOrderList = new ArrayList<>();
    ReadItemProfile readItemProfile = new ReadItemProfile();
    //PurchaseOrderList purchaseItem;
    ItemList item;


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
        if (LocalDate.parse(item.getExpireDate(),formatter).compareTo(LocalDate.now()) < 0){
            JOptionPane.showMessageDialog(null, "The item you pick has expired.\n Select a another item to add");
            return;
        }
        if(item.needDate == "null"){
            JOptionPane.showMessageDialog(null, "Add a need by date before continue");
            return;
        }else if(item.needQuantity.isEmpty() || Integer.parseInt(item.needQuantity) <= 0){
            JOptionPane.showMessageDialog(null, "Modify your quantity value before continue");
            return;
        }
        if(addToOrderCounter < 5){
            //purchaseOrderList.add(purchaseItem);
            purchaseOrderList.add(item);
            purchaseQuantity.clear();
            needDate.getEditor().clear();
            addToOrderCounter++;
            JOptionPane.showMessageDialog(null,item.getItemName()+" added to your order.");
        }else{
            JOptionPane.showMessageDialog(null,"You can only add 5 item in one order!\n Please add your items again...");
            purchaseOrderList.clear();
            addToOrderCounter = 0;
        }
    }

    public void createOrder(){
        if(purchaseOrderList.isEmpty()){
            JOptionPane.showMessageDialog(null,"You should add at least one item to your order!");
        }else{
            int purchaseId = PurchaseIdProvider.getInstance().getUniqueId();;
            String filePath = "PurchaseOrder"+ purchaseId +".csv";
            for (ItemList purchaseItem: purchaseOrderList
            ) {
                try{
                    double subtotalPrice = Double.parseDouble(purchaseItem.getPurchasePrice());
                    double subtotalQuantity = Double.parseDouble(purchaseItem.getNeedQuantity());
                    double subtotal = subtotalQuantity * subtotalPrice;
                    FileWriter fw = new FileWriter(filePath,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println(purchaseItem.getItemId()+","+purchaseItem.getItemName()+","+purchaseItem.getPurchasePrice()
                            +","+purchaseItem.getExpireDate() +","+purchaseItem.needQuantity+","+purchaseItem.needDate+","+subtotal);
                    pw.flush();
                    pw.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Unable to create purchase order...");
                }
            }
            JOptionPane.showMessageDialog(null, "Your purchase order has been created!");
            //update the vendor balance
            calculatePurchaseOrderTotalCost.calculatePurchaseOrderTotalCost(filePath);
            purchaseOrderList.clear();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
        datePicker();
        vendorId.getItems().addAll(vendorList);
        vendorId.setOnAction(this::getVendorCategory);
    }

    public void datePicker(){
        needDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) < 0 );
            }
        });
    }
    public String getVendorCategory(ActionEvent event){
        String vendorCategory = vendorId.getValue();
        return vendorCategory;
    }


    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (javafx.stage.Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

}
