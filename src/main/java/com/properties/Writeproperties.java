package com.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Writeproperties {
    public static void main(String[] args) throws IOException {
        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();
        prop.setProperty("Name","Mahin");
        prop.setProperty("Email","lollol@gmail.com");
        prop.setProperty("Password","lollol");
        prop.store(fis, null);
    }
}
