package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL extends TestBase {
    public static void main(String[] args) {
        insecurecerts();

    }
    public static void insecurecerts(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions chrObj = new ChromeOptions();
        chrObj.setAcceptInsecureCerts(true);
        driver= new ChromeDriver();
        driver.get("https://cacert.org/");
        System.out.println(driver.getTitle());
    }

}
