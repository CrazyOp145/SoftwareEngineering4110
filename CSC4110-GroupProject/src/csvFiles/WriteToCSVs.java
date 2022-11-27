package csvFiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSVs {
    public static void csvWriter(String filePath, String[] data){
        try {
            // CSV Printer
            CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT);

            // Header Row
            printer.printRecord("LastName", "FirstName", "UserID", "Password", "UserRole");

            // Input Data
            printer.printRecord((Object[]) data);

            printer.flush();
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToCsvWriter(String filePath, String[] data){
        try {
            //CSV Parser
            CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);

            // CSV Printer
            CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT);

            // Print From CSV
            for(CSVRecord record : csvParser){
                System.out.println(record.get(0) + "," + record.get(1) + "," + record.get(2) + "," + record.get(3) + "," + record.get(4));
                String lName = record.get("LastName");
                String fName = record.get("FirstName");
                String uID = record.get("UserID");
                String pass = record.get("Password");
                String uRole = record.get("UserRole");
                printer.printRecord(lName, fName, uID, pass, uRole);
            }

            // Input New Data
            printer.printRecord((Object[]) data);

            csvParser.close();
            printer.flush();
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
