package csvFiles;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSVs {
    public static void csvWriter(String filePath, String[] data){
        File file = new File(filePath);

        try{
            FileWriter output = new FileWriter(file);
            CSVWriter writer = new CSVWriter(output);

            String[] header = {"Last Name", "First Name", "User ID", "Password", "User Role"};
            writer.writeNext(header);

            writer.writeNext(data);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
