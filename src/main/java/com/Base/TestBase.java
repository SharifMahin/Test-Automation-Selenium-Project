package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class TestBase {

    public static WebDriver driver;

    public static void chrome_launch(){

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();



    }

    public static void chrome_close(){

        driver.close();

    }
    public static void openUrl(String Url ){

        driver.get(Url);
    }

    public static String RandomName() throws IOException {

        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        String SALTCHAR="abcdeMahinmkABCDE12345XyzOI";
        StringBuilder salt=new StringBuilder();
        Random rnd=new Random();

        while (salt.length()<7){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }
        String saltStr=salt.toString();

        prop.setProperty("RandomName",saltStr);
        prop.setProperty("Password","123mahin");

        prop.store(fis,null);
        return saltStr;
    }


}

