package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;
    private static String fileName = "config.properties";

    static  {
        properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    public static String getProperty(String key){
       return properties.getProperty(key);
    }
}
