package com.OpenCart;

import com.Base.TestBase;

import java.io.IOException;

public class EndtoEnd extends TestBase {
    public static void main(String[] args) throws IOException {

        String HomePage="https://demo.opencart.com/";
        chrome_launch();
        openUrl(HomePage);
        Registration.OpenRegPage();
        Registration.ValidRegAcc();
        Logout.logOut();
        Login.OpenLoginPage();
        Login.ValidloginTest();
        Logout.logOut();

    }
}
