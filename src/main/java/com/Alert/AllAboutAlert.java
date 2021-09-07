package com.Alert;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlert extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        confirmAlert();
        promptAlert();
    }

    public static void normalAlert() throws InterruptedException {
        WebElement alertbtn= driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
        alertbtn.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // accept() for click on ok

    }
    public static void confirmAlert() throws InterruptedException {

        WebElement alertbtn= driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
        alertbtn.click();
        Thread.sleep(3000);
        //driver.switchTo().alert().accept(); // accept() for click on ok
        driver.switchTo().alert().dismiss(); // dismiss() for click on cancel
    }
    public static void promptAlert() throws InterruptedException {
        WebElement alertBtn=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
        alertBtn.click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("mahin");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
}
