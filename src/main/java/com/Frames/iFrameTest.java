package com.Frames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/iframe");
        singleeFrame();
    }
    public static void singleeFrame() throws InterruptedException {

        driver.switchTo().frame("mce_0_ifr");
        WebElement iFrameBody=driver.findElement(By.id("tinymce"));
        iFrameBody.clear();
        Thread.sleep(3000);
        iFrameBody.sendKeys("Mahin");

    }
}
