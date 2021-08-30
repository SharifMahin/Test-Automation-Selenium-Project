package com.Browsers;

import com.Base.TestBase;
import com.OpenCart.Login;

public class TitleNurlVerify extends TestBase {

    public static void main(String[] args) {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        Login.OpenLoginPage();
        ValidTitleVerify();
        ValidUrlVerify();
    }

    public static void ValidTitleVerify() {

        String ExpectedTitle="Account Login";
        String ActualTitle=driver.getTitle();

        if (ExpectedTitle.equals(ActualTitle)){
            System.out.println("Test Passed,Login page open.Title Verified.");
        }
        else {
            System.out.println("Test Failed,Different page open.");
        }

    }

    public static void ValidUrlVerify(){
        String ExpectedUrl="https://demo.opencart.com/index.php?route=account/login";
        String ActualUrl=driver.getCurrentUrl();
        if (ExpectedUrl.equals(ActualUrl)){
            System.out.println("Test Passed,Login page open.URL Verified.");
        }
        else {
            System.out.println("Test Failed,Different page open.");
        }

    }

}
