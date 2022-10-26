package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CSVReader {
    /**
     *   Utility method that reads the content of a csv file and returns it as Object[][] to be used in @DataProvider
     *
     * @param str - path to a file
     * @return - returns 2D array of Objects that represents the content of the csv file
     */
    public static Object[][] readFromCSV(String str)  {
        List<String[]> result = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(str));
            String strConv;
            while((strConv=br.readLine()) !=null){
                String[] eachrow = strConv.split(",");
                result.add(eachrow);
            }
        } catch (IOException e){
            System.out.println("Exception");
        }
        int rowNo = result.size();
        int colNo = result.get(0).length;
        Object[][] objArr =  new Object[rowNo][colNo];
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = result.get(i);
        }
        return objArr;
    }
}