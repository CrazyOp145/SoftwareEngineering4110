package Profiles.Items;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class SearchItemController implements Initializable {

    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    @FXML
    private TextField searchItemBar;
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

    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();


    ReadItemProfile readItemProfile = new ReadItemProfile();

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
        FilteredList<ItemList> filteredData = new FilteredList<>(dataList, b -> true);
        searchItemBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ItemList -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (ItemList.getItemId().toString().indexOf(lowerCaseFilter) > -1 ) {
                    return true; // Filter matches first name.
                } else if (ItemList.getItemName().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(ItemList.getExpireDate()).indexOf(lowerCaseFilter) > -1)
                    return true;
                else
                    return false; // Does not match.
            });
            tableView.setPlaceholder(new Label("The Item "+ newValue +" profile is not found"));
        });
        SortedList<ItemList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);

    }

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("../UserMenu.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }


}
