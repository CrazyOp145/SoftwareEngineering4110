package csvFiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

public class ReadFromCSVs {
    public static void readCSV(String filePath){
        try{
            CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);
            for(CSVRecord record : csvParser){
                System.out.println(record.get(0) + "," + record.get(1) + "," + record.get(2) + "," + record.get(3) + "," + record.get(4));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
