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
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateItemController implements Initializable {
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
    @FXML
    private ComboBox newVendorId;
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

    String filePath = "ItemProfile.csv";
    String temp = "temp.csv";

    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();

    ReadItemProfile readItemProfile = new ReadItemProfile();

    UpdateItemProfile updateItemProfile = new UpdateItemProfile();


    File oldFile = new File(filePath);
    File newFile = new File(temp);

    public void updateProfile() {
        updateItemProfile.updateItemProfile(filePath,newItemId.getText(),newItemId.getText(),newItemName.getText(),
                newQuantity.getText(),newSellingPrice.getText(),newPurchasePrice.getText(), String.valueOf(newExpireDate.getValue()),
                newItemCategory.getValue(),newUnit.getValue());
        oldFile.delete();
        File dump = new File(filePath);
        newFile.renameTo(dump);
        //updateList();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
        newItemCategory.getItems().addAll(Category);
        newItemCategory.setOnAction(this::getCategory);
        newUnit.getItems().addAll(unitCategory);
        newUnit.setOnAction(this::getUnitCategory);
    }

    public void selectCell(){
        ArrayList<ItemList> orderList = new ArrayList<ItemList>();
        orderList.add(tableView.getSelectionModel().getSelectedItem());
    }


    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
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
}

