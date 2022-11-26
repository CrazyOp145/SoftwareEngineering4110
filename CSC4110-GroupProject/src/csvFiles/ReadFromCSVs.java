package csvFiles;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class ReadFromCSVs {
    public static void readLineByLine(String filePath){
        try{
            CSVReader reader = new com.opencsv.CSVReaderBuilder(new FileReader(filePath)).build();
            List<String[]> userData = reader.readAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
