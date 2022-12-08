package Profiles.Items;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import Profiles.Items.Categories.*;
import Profiles.Items.*;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class UpdateItemController implements Initializable {
    ReadVendorId RVI = new ReadVendorId();
    //New value for update
    @FXML
    private TextField newItemId;
    @FXML
    private TextField newItemName;
    @FXML
    private TextField newQuantity;
    @FXML
    private TextField newSellingPrice;
    @FXML
    private TextField newPurchasePrice;
    @FXML
    private DatePicker newExpireDate;
    @FXML
    private ComboBox<String> newItemCategory;
    private String[] Category = {"Vegetables", "Fruits", "Nuts", "Dairy",
            "Meat", "Snacks", "Soda", "Juice", "Bakery"};
    @FXML
    private ComboBox<String> newUnit;
    private String[] unitCategory = {"Pounds", "Gallon", "Dozen", "Ounce", "bunch"};

    private List<String> vendorList = RVI.initList();
    @FXML
    private ComboBox<String> newVendorId;
    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;
    //list view variables
    @FXML
    private TableView<ItemList> tableView;
    @FXML
    private TableColumn<ItemList, String> itemId;
    @FXML
    private TableColumn<ItemList, String> itemName;
    @FXML
    private TableColumn<ItemList, String> quantity;
    @FXML
    private TableColumn<ItemList, String> sellingPrice;
    @FXML
    private TableColumn<ItemList, String> purchasePrice;
    @FXML
    private TableColumn<ItemList, String> expireDate;
    @FXML
    private TableColumn<ItemList, String> tableCategory;
    @FXML
    private TableColumn<ItemList, String> tableUnit;

    String filePath = "ItemProfile.csv";
    String temp = "temp.csv";

    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();
    private  ItemList item;

    ReadItemProfile readItemProfile = new ReadItemProfile();

    UpdateItemProfile updateItemProfile = new UpdateItemProfile();


    File oldFile = new File(filePath);
    File newFile = new File(temp);

    public void updateProfile() {
        if(this.item == null){
            JOptionPane.showMessageDialog(null, "You have to select a item to change.");
            return;
        }
        updateItemProfile.updateItemProfile(filePath,item.getItemId(),newItemId.getText(),newItemName.getText(),
                newQuantity.getText(),newSellingPrice.getText(),newPurchasePrice.getText(), String.valueOf(newExpireDate.getValue()),
                newItemCategory.getValue(),newUnit.getValue(),newVendorId.getValue());
        oldFile.delete();
        File dump = new File(filePath);
        newFile.renameTo(dump);
        clearList();
        updateList();
    }
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
        tableCategory.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        tableUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        tableView.setItems(dataList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextLengthLimiter(newItemName,20);
        TextTypeLimiter(newQuantity);
        TextTypeLimiter(newSellingPrice);
        TextTypeLimiter(newPurchasePrice);
        TextLengthLimiter(newItemId,6);
        TextTypeLimiter(newItemId);
        datePicker();
        updateList();
        newItemCategory.getItems().addAll(Category);
        newItemCategory.setOnAction(this::getCategory);
        newUnit.getItems().addAll(unitCategory);
        newUnit.setOnAction(this::getUnitCategory);
        newVendorId.getItems().addAll(vendorList);
        newVendorId.setOnAction(this::getVendorCategory);
    }

    public void selectCell(){
        item = tableView.getSelectionModel().getSelectedItem();
    }

    public void setCell(){
        newItemId.setText(item.getItemId());
        newItemName.setText(item.getItemName());
        newSellingPrice.setText(item.getSellingPrice());
        newPurchasePrice.setText(item.getPurchasePrice());
        newQuantity.setText(item.getQuantity());
        newExpireDate.getEditor().setText(item.getExpireDate());
        newItemCategory.getEditor().setText(item.getItemCategory());
        newUnit.getEditor().setText(item.getUnit());
    }


    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    public String getCategory(ActionEvent event){
        String category = newItemCategory.getValue();
        return category;
    }

    public String getUnitCategory(ActionEvent event){
        String unitCategory = newUnit.getValue();
        return unitCategory;
    }

    public String getVendorCategory(ActionEvent event){
        String vendorCategory = newVendorId.getValue();
        return vendorCategory;
    }
    public void datePicker(){
        newExpireDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) < 0 );
            }
        });
    }
    public void TextLengthLimiter(final TextField tf, final int maxLength){
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

    public void TextTypeLimiter(final TextField tf){
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*\\.\\d*")) {
                    tf.setText(newValue.replaceAll("\\D", ""));
                }
            }
        });
    }
}

