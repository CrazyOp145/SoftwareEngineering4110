import Profiles.LoginValidation;
import csvFiles.ReadFromCSVs;

public class MainTest {
    public static void main(String[] args){
        ReadFromCSVs.readCSV("UserData.csv");
        LoginValidation.createUserProfiles();
    }
}
