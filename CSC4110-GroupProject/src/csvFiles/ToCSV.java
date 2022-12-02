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
            Object[] arr;
            List<String> oldData = new ArrayList<>();
            while(userData.hasNext()){
                String oldUserData = userData.next();
                arr = oldUserData.split(",");
                oldData.add(String.valueOf(arr[0]));
            }

            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.print(oldData.toString().substring(1,oldData.toString().length()-1).replaceAll(" ", ""));
            printWriter.println(Arrays.toString(data).substring(1,Arrays.toString(data).length()-1).replaceAll(" ", ""));

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUserData(String filePath){
        try{
            Scanner userData = new Scanner(new File(filePath));
            userData.useDelimiter(",");
            while (userData.hasNext()) {
                System.out.print(userData.next() + ",");
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
