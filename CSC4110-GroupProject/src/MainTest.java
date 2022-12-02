import Profiles.Login.LoginValidation;
import csvFiles.ToCSV;

public class MainTest {
    public static void main(String[] args){
        ToCSV.readUserData("UserData.csv");
        LoginValidation.createUserProfiles();
    }
}
