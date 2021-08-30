package com.locators;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebelLocatorReg extends TestBase {
    public static void main(String[] args) {

        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenRegPage();
        RegAcc();

    }

    public static void OpenRegPage(){
        WebElement MyAccount=driver.findElement(By.linkText("My Account"));
        MyAccount.click();
        WebElement Login=driver.findElement(By.linkText("Register"));
        Login.click();
    }

    public static void RegAcc(){
        WebElement FirstName =driver.findElement(By.name("firstname"));
        FirstName.sendKeys("Sharif");
        WebElement LastName=driver.findElement(By.name("lastname"));
        LastName.sendKeys("Mahin");
        WebElement Email=driver.findElement(By.name("email"));
        Email.sendKeys("mahin1@mail.com");
        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.sendKeys("01639....");
        WebElement Password=driver.findElement(By.name("password"));
        Password.sendKeys("123abc");
        WebElement ConPassword=driver.findElement(By.name("confirm"));
        ConPassword.sendKeys("123abc");
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
