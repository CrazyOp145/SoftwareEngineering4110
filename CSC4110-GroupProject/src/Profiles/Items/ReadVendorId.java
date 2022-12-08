package Profiles.Items;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class ReadVendorId {
        private List<String> dataList = new ArrayList<>();
        public List<String> initList(){
            String filePath = "VendorProfile.csv";
            File file = new File(filePath);
            try {
                Scanner input = new Scanner(file);
                while((input.hasNext())){
                    String data = input.next();
                    Object[] values = data.split(",");
                    Object[] valuesLine = data.split("\n");
                    dataList.add(String.valueOf(values[0]));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return dataList;
        }
    }

