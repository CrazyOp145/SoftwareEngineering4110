package Profiles.PurchaseOrder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class ReadPurchaseOrder {
    private ObservableList<PurchaseOrderList> dataList = FXCollections.observableArrayList();

    public ObservableList<PurchaseOrderList> initList(String filePath){
        File file = new File(filePath);

        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] values = data.split(",");
                //Object[] valuesLine = data.split("\n");
                dataList.add(new PurchaseOrderList(String.valueOf(values[0]),String.valueOf(values[1]),String.valueOf(values[2])
                        ,String.valueOf(values[3]),String.valueOf(values[4]),String.valueOf(values[5]),String.valueOf(values[6])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
