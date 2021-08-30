package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Logout extends TestBase {
    public static void main(String[] args) throws IOException {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        Login.OpenLoginPage();
        Login.ValidloginTest();

        logOut();
    }

    public static void logOut(){
        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();
        WebElement AfterlogoutcontinueBtn=driver.findElement(By.cssSelector("#content > div > div > a"));
        AfterlogoutcontinueBtn.click();
    }
}
