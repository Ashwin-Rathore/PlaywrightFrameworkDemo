package com.base.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static Properties prop=new Properties();
    static FileInputStream fis;

    static File src = new File("src/test/java/resources/config.properties");

    static  {
        try {

            fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);

        } catch (IOException e) {

            Log.ERROR("Exception while reading config file" + e.getMessage());
        }finally {
            fis=null;
        }
    }
    public static String getProperty(String key) {

        String value = prop.getProperty(key);
        return value;
    }
}
