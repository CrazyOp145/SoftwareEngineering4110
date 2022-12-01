package csvFiles;

import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

/**
 * @author David Her
 */

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
            Scanner userData = new Scanner(new File(filePath));
            userData.useDelimiter(",");
            String[][] arr = new String[1000][1000];
            List<String> oldData = new ArrayList<>();
            int row = 0;
            int column = 0;
            while(userData.hasNext()){
                while(userData.hasNext()) {
                    String oldUserData = "";
                    oldUserData = userData.next();
                    arr[row][column] = oldUserData;
                    oldData.add(arr[row][column]);
                    column++;
                }
                row++;
            }
            System.out.println(oldData);
            // CSV Printer
            CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT);

            //Add Data
            printer.printRecord(oldData);
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
