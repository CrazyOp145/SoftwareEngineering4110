package csvFiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSVs {
    public static void csvWriter(String filePath, String[] data){
        try {
            // CSV Printer
            CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT);

            // Header Row
            printer.printRecord("Last Name", "First Name", "User ID", "Password", "User Role");

            // Input Data
            printer.printRecord(data);

            printer.flush();
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
