package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Login extends TestBase {
    public static void main(String[] args) throws IOException {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenLoginPage();
        ValidloginTest();
    }

    public static void OpenLoginPage(){
        WebElement MyAccount=driver.findElement(By.linkText("My Account"));
        MyAccount.click();
        WebElement Login=driver.findElement(By.linkText("Login"));
        Login.click();
    }

    public static void ValidloginTest() throws IOException {

        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop=new Properties();
        prop.load(fis);


        WebElement Email=driver.findElement(By.name("email"));
        Email.sendKeys(prop.getProperty("RandomName").concat("@gmail.com"));

        WebElement Password=driver.findElement(By.name("password"));
        Password.sendKeys(prop.getProperty("Password"));

        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
    }
}
