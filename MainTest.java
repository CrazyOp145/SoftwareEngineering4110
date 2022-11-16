import java.util.Scanner;

public class MainTest {
    public static void main(String[] args){

        String vName;
        String customer = "Customer Profile";
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Please input a name for the Vendor: ");
       // vName = scanner.nextLine();
       // vName = characterLimit(20, vName);
       // System.out.println("You inputted: " + vName);

        Profiles profile1 = ProfilesFactory.createProfile(customer);
        System.out.println(profile1.toString());
    }

    public static String characterLimit(int limit, String stringToLimit){
        String cutName = stringToLimit.substring(0, limit);
        if(stringToLimit.length() > limit){
            stringToLimit = cutName;
        }
        return stringToLimit;
    }
}