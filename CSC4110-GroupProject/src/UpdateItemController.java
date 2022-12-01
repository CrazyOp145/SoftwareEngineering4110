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

public class UpdateItemController implements Initializable {
    private javafx.stage.Stage Stage;
    private javafx.scene.Scene Scene;
    private Parent Root;
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
    private TextField deleteItemBar;
    String filePath = "itemProfile.csv";

    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();

    ReadItemProfile readItemProfile = new ReadItemProfile();

    DeleteItemProfile deleteItemProfile = new DeleteItemProfile();


    File oldFile = new File("ItemProfile.csv");
    File newFile = new File("temp.csv");

    public void updateProfile() {
        deleteItemProfile.deleteItemProfile(filePath, deleteItemBar.getText());
        oldFile.delete();
        File dump = new File(filePath);
        newFile.renameTo(dump);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataList = readItemProfile.initList();
        itemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        sellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        purchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        expireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        tableView.setItems(dataList);
    }

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }
}
