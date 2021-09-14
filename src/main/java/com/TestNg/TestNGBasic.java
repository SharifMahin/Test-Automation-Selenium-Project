package com.TestNg;

import org.testng.annotations.Test;

public class TestNGBasic{
    @Test(enabled = false)
    public  static void Testmethod1(){
        System.out.println("TestNg");
    }
    @Test(priority = 2)
    public  static void Testmethod2(){
        System.out.println("Test Automation");
    }
    @Test(priority = 1)
    public  static void Testmethod3(){
        System.out.println("Mahin");
    }
    //priority use na korle oigla age run korbe mane priority 0 hisebe count hobe
    @Test(description = "Test Description")
    public  static void Testmethod4(){
        System.out.println("Selenium");
    }
    @Test()
    public  static void Testmethod5(){
        System.out.println("Webdriver");
    }
}
