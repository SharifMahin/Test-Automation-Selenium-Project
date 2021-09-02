package com.BrowserOptions;

import com.Base.TestBase;
import com.OpenCart.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class HeadlessTest extends TestBase {
    public static void main(String[] args) throws IOException {
        ChromeHeadless();

    }
    public static void ChromeHeadless() throws IOException {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions chromeObj = new ChromeOptions();
        chromeObj.setHeadless(true);
        driver= new ChromeDriver(chromeObj);
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        Login.ValidloginTest();
        System.out.println("Login Success");
    }
}
