package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropDown extends TestBase
{
    public static void main(String[] args) throws InterruptedException {

        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/dropdown");
        selectOptionByIndex();
        selectOptionByValue();
        selectOptionByVisibleText();

    }
    public static void selectOptionByIndex() throws InterruptedException {
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select obj= new Select(dropdown);
        obj.selectByIndex(1);
        Thread.sleep(2000);
    }

    public static void selectOptionByValue() throws InterruptedException {
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select obj= new Select(dropdown);
        obj.selectByValue("2");
        Thread.sleep(2000);
    }
    public static void selectOptionByVisibleText() throws InterruptedException {
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select obj= new Select(dropdown);
        obj.selectByVisibleText("Option 1");
        Thread.sleep(2000);
    }


}
