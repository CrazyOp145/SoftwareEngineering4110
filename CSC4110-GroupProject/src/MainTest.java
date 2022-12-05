import Profiles.Login.LoginValidation;
import csvFiles.ToCSV;
import javafx.scene.Scene;

import java.util.Scanner;

import static Profiles.Login.CheckInputs.checkPasswordInput;
import static Profiles.Login.CheckInputs.checkUserIDInput;

public class MainTest {
    public static void main(String[] args){
        ToCSV.readUserData("UserData.csv");
        //LoginValidation.createUserProfiles();
        Scanner userInput = new Scanner(System.in);
        System.out.print(LoginValidation.loginCheck(
                checkUserIDInput(userInput, "Enter in UserID:"),
                checkPasswordInput(userInput, "Enter in Password:")));
    }
}
