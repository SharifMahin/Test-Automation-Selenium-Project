package com.Browsers;

import com.Base.TestBase;
import org.openqa.selenium.Dimension;


public class WindowsSize extends TestBase {

    public static void main(String[] args) {
        chrome_launch();
        getWindowSize();
        setWindowSize(1000,400);

    }
    public static void getWindowSize () {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("windows hight " + height);
        System.out.println("windows width " + width);
    }

    public static void setWindowSize(int Width,int Height){
        driver.manage().window().setSize(new Dimension(Width,Height));

        int height=driver.manage().window().getSize().getHeight(); //744
        int width=driver.manage().window().getSize().getWidth();  //1382
        System.out.println("New Height: "+height);
        System.out.println("New Width: "+width);
    }

}
