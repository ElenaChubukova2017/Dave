package com.dave.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {

            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found in the ConfigurationReader class");
        }
    }

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);

    }
}
