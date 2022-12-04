import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

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

    public void switchToUserMenu(javafx.event.ActionEvent event) throws IOException {


        Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        Stage = (javafx.stage.Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
