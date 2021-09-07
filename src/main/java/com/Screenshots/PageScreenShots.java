package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenShots extends TestBase {
    public static void main(String[] args) throws IOException {
        chrome_launch();
        openUrl("https://www.google.com/");
        generateScreenshot("newImage");

    }


}
