package csvFiles;

import java.io.*;
import java.util.*;

/**
 * @author David Her
 */

public class ToUserDataCSV {
    public static void createCsv(String filePath){
        try {
            //FileWriters
            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

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

    public static String[] readUserData(String filePath){
        String line;
        String[] data = new String[]{};
        try{
            FileReader fr = new FileReader("UserData.csv");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                data = line.split(",");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
