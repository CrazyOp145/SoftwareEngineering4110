package csvFiles;

import java.io.*;
import java.util.*;

/**
 * @author David Her
 */

public class ToCSV {
    public static void createCsv(String filePath,String[] header){
        try {
            //FileWriters
            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            //Header Row
            printWriter.print(Arrays.toString(header));

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToUserData(String filePath, String[] data){
        try {
            //Scanner
            Scanner userData = new Scanner(new File(filePath));
            userData.useDelimiter(",");

            Object[] arr;
            List<String> oldData = new ArrayList<>();

            //Put Old Data into List
            while(userData.hasNext()){
                String oldUserData = userData.next();
                arr = oldUserData.split(",");
                oldData.add(String.valueOf(arr[0]));
            }

            //FileWriters
            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            //Write Data into File
            printWriter.print(oldData.toString().substring(1,oldData.toString().length()-1).replaceAll(" ", ""));
            printWriter.println(Arrays.toString(data).substring(1,Arrays.toString(data).length()-1).replaceAll(" ", "") + ",");

            //Close Writers
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUserData(String filePath){
        try{
            //Scanner
            Scanner userData = new Scanner(new File(filePath));
            userData.useDelimiter(",");

            //Read Data
            while (userData.hasNext()) {
                System.out.print(userData.next() + ",");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
