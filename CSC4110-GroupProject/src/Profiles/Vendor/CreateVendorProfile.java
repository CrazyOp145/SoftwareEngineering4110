import Profiles.ProfilesFactory;
import Profiles.VendorProfile;
import Profiles.UserProfiles;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

// @author Mahz Alam

public class CreateVendorProfile implements Initializable {
    String filePath = "VendorFile.csv";

    private String[] stateArray = {"AL", "AK", "AZ", "AR", "CA",
            "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
            "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

    @FXML
    private TextField vendorName;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private ChoiceBox<String> state;
    @FXML
    private  TextField balance;
    @FXML
    private TextField phone;
    @FXML
    private Label errorMessage;
    @FXML
    private DatePicker date;


    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    public CreateVendorProfile(){
        state = new ChoiceBox<>(FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA",
                "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
                "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
        state.getItems();
    }

    public void createVendorProfile(ActionEvent actionEvent) throws IOException {
        ProfilesFactory profFactory = new ProfilesFactory();
        Random random = new Random(); //Random functionality borrowed from David Her
        String vendID = "v" + String.valueOf((random.nextInt(99999)));
        String vendName = vendorName.getText();
        String str = street.getText();
        String c = city.getText();
        String ste = state.getValue();
        String ph = phone.getText();
        LocalDate seasonalDisc = date.getValue();
        String bal = balance.getText();

        String truBal = bal.replaceAll("[^0-9]", "");


        boolean correct = true;

        Pattern phonePattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");

        if(checkVendorName(vendName)){
            errorMessage.setText("Name already taken.");
            correct = false;
        }

        if ((vendName.length() > 20 || vendName.length() == 0)) {
            errorMessage.setText("Error: Vendor Name too Long");
            System.out.println("Name too long please enter a name that is less than 20 characters.");
            correct = false;
        }
        if (str.length() > 20 || str.length() == 0) {
            errorMessage.setText("Error: Street Address too Long");
            System.out.println("Address did not meet requirements.");
            correct = false;
        }
        if (c.length() > 20 || c.length() == 0) {
            errorMessage.setText("Error: City Name too Long");
            System.out.println("City name did not meet requirements.");
            correct = false;
        }
        if (state == null) {
            errorMessage.setText("Error: Please Select A State");
            System.out.println("State does not have an input.");
            correct = false;
        }
        if (ph.matches(phonePattern.pattern()) && ph != null) {
        } else {
            correct = false;
            errorMessage.setText("Error: Phone number format incorrect, please input as xxx xxx xxxx");
            System.out.println("Phone Number format incorrect.");
        }


        if(correct) {
            UserProfiles vendorTemp = profFactory.createProfile("VENDOR");
            if (vendorTemp instanceof VendorProfile) {
                VendorProfile vendor = new VendorProfile();

                vendor.setID(vendID);
                vendor.setFirstName(vendName);
                vendor.setStreet(str);
                vendor.setCity(c);
                vendor.setState(ste);
                vendor.setPhone(ph);
                vendor.setDiscountStartDate(seasonalDisc);
                vendor.setBalance(Double.parseDouble(truBal));

                FileWriter fileWrite = new FileWriter(filePath, true);
                BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
                PrintWriter printW = new PrintWriter(bufferWrite);
                printW.println(vendor.getID() + "," + vendor.getCompanyName() + "," + vendor.getStreetAddress()
                        + "," + vendor.getCity() + "," + vendor.getState() + "," + vendor.getDiscountStartDate()
                        + "," + vendor.getBalance() + ",");
                System.out.println(vendor.getState());
                printW.flush();
                printW.close();
                JOptionPane.showMessageDialog(null, "Vendor Account Created");
            }
        }
    }

        public void switchToUserMenuScene (javafx.event.ActionEvent event) throws IOException {
            Root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
            Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene = new Scene(Root);
            Stage.setScene(Scene);
            Stage.show();
        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state.getItems().addAll(stateArray);
    }

    public static boolean checkVendorName(String input) {
        try {
            FileReader fileRead = new FileReader("VendorFile.csv");
            BufferedReader bufferRead = new BufferedReader(fileRead);

            String line;
            String[] data;

            while ((line = bufferRead.readLine()) != null) {
                data = line.split(",");
                if (data[1].equals(input)) {
                    return false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input.length() <= 20 && input.length() != 0;
    }
}
