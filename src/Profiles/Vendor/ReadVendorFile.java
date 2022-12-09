package Profiles.Vendor;
/*
* @author Mahz Alam and Paulo Burgess
*
*/
import Profiles.Vendor.VendorList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadVendorFile {
    private static ObservableList<VendorList> dataList = FXCollections.observableArrayList();

    public static ObservableList<VendorList> initList(){
        String filePath = "VendorProfile.csv";
        File file = new File(filePath);

        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");

                dataList.add(new VendorList(String.valueOf(values[0]),String.valueOf(values[1]),String.valueOf(values[2])
                        ,String.valueOf(values[3]),String.valueOf(values[4]),String.valueOf(values[5]),String.valueOf(values[6])
                        ,String.valueOf(values[7]),String.valueOf(values[8]),String.valueOf(values[9])));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
