package com.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLoginTest {
    WebDriver driver;
    /*
Using BeforeClass and AfterClass
@BeforeClass execute only one time for all @Test method
@AfterClass execute only one time after all @Test method
 */
    /* here you can use @BeforeMethod,@BeforeTest,@ @AfterMethod,@AfterTest instead of @BeforeClass,@AfterClass.
    and see the changes.*/
    @BeforeClass
    public void initSetup(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }
    @DataProvider(name = "LoginData")
    public Object [][] data(){
        Object [][] data =new Object[3][2];

        //Set1
        data [0][0]="mail@mail.com";
        data [0][1]="123456";

        //Set=2
        data [1][0]="mail2@gmail.com";
        data [1][1]="145222222";

        //Set3
        data [2][0]="test@yahoo.com";
        data [2][1]="sfdsff";

        return data;
    }

    @Test(dataProvider = "LoginData")
    public void ValidLoginTest(String DP_Email,String DP_Pass) throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(DP_Email);
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Pass);
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        System.out.println("ValidLoginTest Executed");
    }
}
