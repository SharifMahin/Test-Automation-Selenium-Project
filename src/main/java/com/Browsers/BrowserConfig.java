package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        //chrome_close();
        edge_launch();
        //edge_close();

    }


    public static void chrome_launch() {

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    /*public static void chrome_close(){

      driver.close();

    }*/

    public static void edge_launch() {
        System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();

    }

     /*public static void edge_close(){

      driver.close();

    }*/

}