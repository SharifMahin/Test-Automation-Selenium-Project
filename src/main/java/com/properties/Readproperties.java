package com.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readproperties {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop=new Properties();
        prop.load(fis);
        System.out.println(prop.getProperty("Name"));
        System.out.println(prop.getProperty("Email"));
        System.out.println(prop.getProperty("Password"));
        //System.out.println(prop.getProperty("City"));

    }
}
