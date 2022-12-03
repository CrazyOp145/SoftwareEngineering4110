package csvFiles;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCustomerProfileCSV{
    public static void csvCustomerProfileWriter(String[] data){
        File file = new File("CustomerProfiles.csv");
        try{
            FileWriter output = new FileWriter(file);
            CSVWriter writer = new CSVWriter(output , ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

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