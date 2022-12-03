import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateItemProfileController implements Initializable {

    String filePath = "ItemProfile.csv";

    @FXML
    private TextField itemName;
    @FXML
    private TextField quantity;
    @FXML
    private TextField sellingPrice;
    @FXML
    private TextField purchasePrice;
    @FXML
    private DatePicker expireDate;
    @FXML
    private ComboBox<String> itemCategory;
    private String[] Category = {"Vegetables", "Fruits", "Nuts", "Dairy",
            "Meat", "Snacks", "Soda", "Juice", "Bakery"};
    @FXML
    private ComboBox<String> unit;
    private String[] unitCategory = {"Pounds", "Gallon", "Dozen", "Ounce", "bunch"};
    @FXML
    private ComboBox VendorID;
    private String[] vendorIdCategory = {""};

    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public CreateItemProfileController() {
        itemCategory = new ComboBox<>(FXCollections.observableArrayList(Category));
    }

    public void create(javafx.event.ActionEvent actionEvent){
        ItemProfileFactory itemFactory = new ItemProfileFactory();
        String itemNameC = itemName.getText();
        int quantityC = Integer.parseInt(quantity.getText());
        double sellingPriceC = Double.parseDouble(sellingPrice.getText());
        double purchasePriceC = Double.parseDouble(purchasePrice.getText());
        String unitC = unit.getValue();
        String itemCategoryC = itemCategory.getValue();
        LocalDate expireDateC = expireDate.getValue();
        //String itemCategoryC = getCategory(actionEvent);

        ItemProfile item = null;

        item = itemFactory.createItemProfile(itemCategoryC);
        item.setItemID();
        item.setItemName(itemNameC);
        item.setItemCategory(itemCategoryC);
        item.setQuantity(quantityC);
        item.setSellingPrice(sellingPriceC);
        item.setPurchasePrice(purchasePriceC);
        item.setDate(expireDateC);
        item.setUnit(unitC);

        try{
            FileWriter fw = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(item.getItemID()+","+item.getItemName()+","+item.getQuantity()+","+ item.getSellingPrice()
                    +","+item.getPurchasePrice()+","+item.getDate()+","+ item.getItemCategory() +","+item.getUnit());
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, "Your item has been created!");
            emptyTextField();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to save the record...");
        }

    }

    public void emptyTextField(){
        itemName.clear();
        itemCategory.getItems().clear();
        quantity.clear();
        sellingPrice.clear();
        purchasePrice.clear();
        expireDate.getEditor().clear();
        unit.getItems().clear();
        VendorID.getItems().clear();
    }

    public void switchToUserMenuScene(javafx.event.ActionEvent event) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource(""))
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemCategory.getItems().addAll(Category);
        itemCategory.setOnAction(this::getCategory);
        unit.getItems().addAll(unitCategory);
        unit.setOnAction(this::getUnitCategory);
        datePicker();
        TextLengthLimiter(itemName,20);
        TextTypeLimiter(quantity);
        TextTypeLimiter(sellingPrice);
        TextTypeLimiter(purchasePrice);
    }

    public String getCategory(ActionEvent event){
        String category = itemCategory.getValue();
        return category;
    }

    public String getUnitCategory(ActionEvent event){
        String unitCategory = unit.getValue();
        return unitCategory;
    }
    public void datePicker(){
        expireDate.setDayCellFactory(param -> new DateCell() {
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
