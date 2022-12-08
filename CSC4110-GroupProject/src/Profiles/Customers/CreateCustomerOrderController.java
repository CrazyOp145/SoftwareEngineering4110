package Profiles.Customers;

import Profiles.Items.ItemList;
import Profiles.Items.ReadItemProfile;
import Profiles.Items.UpdateItemProfile;
import Profiles.PurchaseOrder.PurchaseIdProvider;
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
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CreateCustomerOrderController implements Initializable {
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
    private ChoiceBox<String> customer;
    @FXML
    private TextField purchaseQuantity;
    @FXML
    private DatePicker needDate;
    CalculateCustomerOrderTotal calculateCustomerOrderTotal = new CalculateCustomerOrderTotal();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    int addToOrderCounter = 0;
    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();
    private ArrayList<ItemList> customerOrderList = new ArrayList<>();
    ReadItemProfile readItemProfile = new ReadItemProfile();
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
    public void addToOrder(){
        if (Double.parseDouble(item.getQuantity()) < Double.parseDouble(purchaseQuantity.getText())){
            JOptionPane.showMessageDialog(null, "We do not have enough of that item.\n " +
                    "Select a another item to add or less of that item");
            return;
        }
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
            customerOrderList.add(item);
            purchaseQuantity.clear();
            needDate.getEditor().clear();
            addToOrderCounter++;
            JOptionPane.showMessageDialog(null,item.getItemName()+" added to your order.");
        }else{
            JOptionPane.showMessageDialog(null,"You can only add 5 items in one order!\n Please add your items again...");
            customerOrderList.clear();
            addToOrderCounter = 0;
        }
    }

    public void createOrder(){
        double orderSubtotal = 0;
        if(customerOrderList.isEmpty()){
            JOptionPane.showMessageDialog(null,"You need at least one item to your order!");
        }else{
            Random randID = new Random();
            String customerOrderID = String.valueOf(randID.nextInt(999999));
            String filePath = "CustomerOrders.csv";
            try{
                FileWriter fw = new FileWriter(filePath,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("Customer Name:"+","+customer.getValue());
                pw.println("Order Number:"+","+customerOrderID);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to make customer order...");
            }
            for (ItemList purchaseItem: customerOrderList
            ) {
                try{
                    double subtotalPrice = Double.parseDouble(purchaseItem.getPurchasePrice());
                    double subtotalQuantity = Double.parseDouble(purchaseItem.getNeedQuantity());
                    double subtotal = subtotalQuantity * subtotalPrice;
                    FileWriter fw = new FileWriter(filePath,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println(purchaseItem.getItemId()+","+purchaseItem.getItemName()+","+purchaseItem.getPurchasePrice()
                            +","+purchaseItem.getSellingPrice() +","+purchaseItem.needQuantity+","+purchaseItem.needDate+","+subtotal);
                    pw.flush();
                    pw.close();
                    UpdateItemQuantity.updateItemQuantity("ItemProfile.csv",purchaseItem.getItemId(),
                           purchaseItem.needQuantity);
                    orderSubtotal += subtotal;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Unable to make customer order...");
                }
                clearList();
                updateList();
            }
            try{
                FileWriter fw = new FileWriter(filePath,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("Order Subtotal:"+","+orderSubtotal);
                pw.println("\n");
                pw.flush();
                pw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to make customer order...");
            }
            JOptionPane.showMessageDialog(null, "Customer order has been created!");
            //update the vendor balance
            calculateCustomerOrderTotal.calculateCustomerOrderTotal(filePath);
            customerOrderList.clear();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customer.getItems().addAll(GetListCustomerNames.getListCustomerNames());
        System.out.println(GetListCustomerNames.getListCustomerNames()+" Hello");
        updateList();
        datePicker();
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

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (javafx.stage.Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

}
