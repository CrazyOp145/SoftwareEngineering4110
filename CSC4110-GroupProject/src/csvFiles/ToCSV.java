package csvFiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToCSV {
    public static void createCsv(String filePath,String[] header){
        try {
            // CSV Printer
            CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT);

            // Header Row
            printer.printRecord((Object[]) header);

            printer.flush();
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToUserData(String filePath, String[] data){
        try {
            //CSV Parser
            CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);

            List<String> recordList = new ArrayList<>();

            // Print From CSV
            for(CSVRecord record : csvParser){

                String line = record.get(0) + "," + record.get(1) + "," + record.get(2) + "," + record.get(3) + "," + record.get(4);
                System.out.println(line);

                recordList.add(record.get(0));
                recordList.add(record.get(1));
                recordList.add(record.get(2));
                recordList.add(record.get(3));
                recordList.add(record.get(4));
            }

            // CSV Printer
            CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT);

            //Add Data
            printer.printRecord(recordList);
            printer.printRecord((Object[]) data);

            //Close printer
            printer.flush();
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUserData(String filePath){
        try{
            //CSV Parser
            CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);

            // Print From CSV
            for(CSVRecord record : csvParser){
                System.out.println(record.get(0) + "," + record.get(1) + "," + record.get(2) + "," + record.get(3) + "," + record.get(4));
            }

            // Close CSV Parser
            csvParser.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
