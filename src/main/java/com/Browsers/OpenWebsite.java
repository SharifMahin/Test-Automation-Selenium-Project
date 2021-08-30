package com.Browsers;

import com.Base.TestBase;

public class OpenWebsite extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        openUrl("https://google.com");
        chrome_close();
    }
//    public static void OpenUrl(){
//        driver.get("https://google.com");
//    }

}
