package Profiles;

import Profiles.Users.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
* @author David Her
 * Used Code from Shijie Du's ReadItemProfile.java
*/
public class ReadUserData {
    private ObservableList<UserList> dataList = FXCollections.observableArrayList();
    public ObservableList<UserList> initList(){
        File file = new File("UserData.csv");
        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] dataLine = data.split(",");

                dataList.add(new UserList(String.valueOf(dataLine[0]),
                        String.valueOf(dataLine[1]),
                        String.valueOf(dataLine[2]),
                        String.valueOf(dataLine[3]),
                        String.valueOf(dataLine[4])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
