import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadItemProfile {
    private ObservableList<ItemList> dataList = FXCollections.observableArrayList();

    public ObservableList<ItemList> initList(){
        String filePath = "ItemProfile.csv";
        File file = new File(filePath);

        try {
            Scanner input = new Scanner(file);
            while((input.hasNext())){
                String data = input.next();
                Object[] values = data.split(",");
                Object[] valuesLine = data.split("\n");

                dataList.add(new ItemList(String.valueOf(values[0]),String.valueOf(values[1]),String.valueOf(values[2])
                        ,String.valueOf(values[3]),String.valueOf(values[4]),String.valueOf(values[5])));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
