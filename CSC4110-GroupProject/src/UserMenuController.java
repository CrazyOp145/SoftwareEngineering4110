import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMenuController {
    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public void switchToCreateItemProfileScene(ActionEvent event) throws IOException {
        Root = FXMLLoader.load(getClass().getResource("CreateItemProfile.fxml"));
        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

//    public void switchToUserMenuScene(javafx.event.ActionEvent event) throws IOException {
//        Root = FXMLLoader.load(getClass().getResource("UserMenuController.fxml"));
//        Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene = new Scene(Root);
//        Stage.setScene(Scene);
//        Stage.show();
//    }

}
