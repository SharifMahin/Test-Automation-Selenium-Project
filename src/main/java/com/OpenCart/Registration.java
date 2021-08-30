package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Registration extends TestBase {
    public static void main(String[] args) throws IOException {

        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenRegPage();
        ValidRegAcc();

    }

    public static void OpenRegPage(){
        WebElement MyAccount=driver.findElement(By.linkText("My Account"));
        MyAccount.click();
        WebElement Login=driver.findElement(By.linkText("Register"));
        Login.click();
    }

    public static void ValidRegAcc() throws IOException {

        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop=new Properties();
        prop.load(fis);

        //**************  String email=RandomName().concat("@gmail.com"); this line keep in last because last randomfunction data will remain data.properties file

        String Fname= RandomName();
        String Lname=RandomName().concat("mahin");
        String email=RandomName().concat("@gmail.com");



        WebElement FirstName =driver.findElement(By.name("firstname"));
        FirstName.sendKeys(Fname);

        WebElement LastName=driver.findElement(By.name("lastname"));
        LastName.sendKeys(Lname);
        WebElement Email=driver.findElement(By.name("email"));
        Email.sendKeys(email);
        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.sendKeys("01639....");

        // *************  this is not need because we read test password from data.properties file ************

//        WebElement Password=driver.findElement(By.name("password"));
//        Password.sendKeys("123mahin");
//        WebElement ConPassword=driver.findElement(By.name("confirm"));
//        ConPassword.sendKeys("123mahin");



        WebElement Password=driver.findElement(By.name("password"));
       Password.sendKeys(prop.getProperty("Password"));
        WebElement ConPassword=driver.findElement(By.name("confirm"));
        ConPassword.sendKeys(prop.getProperty("Password"));


        WebElement NewsLetter=driver.findElement(By.name("newsletter"));
        NewsLetter.click();
        WebElement PrivacyBtn=driver.findElement(By.name("agree"));
        PrivacyBtn.click();
        WebElement ContinueBtn=driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        ContinueBtn.click();
        WebElement RegcontinueBtn=driver.findElement(By.cssSelector("#content > div > div > a"));
        RegcontinueBtn.click();
    }

}
