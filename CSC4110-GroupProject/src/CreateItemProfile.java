import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class CreateItemProfile extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage createItemStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("CreateItemProfile.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
        //Stage stage = new Stage();
        Scene scene = new Scene(root, 600,400);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        //String css = this.getClass().getResource("application.css").toExternalForm();
        //scene.getStylesheets().add(css);
        createItemStage.setTitle("WSU Inc. Wholesale Food Distribution");
        createItemStage.setScene(scene);
        createItemStage.show();
    }


}
