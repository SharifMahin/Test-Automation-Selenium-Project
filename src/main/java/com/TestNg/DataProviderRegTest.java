package com.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderRegTest {
    WebDriver driver;

    @BeforeClass
    public void initSetup(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "RegistrationData")
    public Object[][] data(){
    Object[][] data= new Object[2][6];

        //Set1
        data [0][0]="Sharif";
        data [0][1]="Mahin";
        data [0][2]="Mahin121121@gmail.com";
        data [0][3]="0163971....";
        data [0][4]="aaaaa12";
        data [0][5]="aaaaa12";

        //Set=2
        data [1][0]="shukriya";
        data [1][1]="Mahin";
        data [1][2]="Sharif121121@gmail.com";
        data [1][3]="019628....";
        data [1][4]="bbbbb12";
        data [1][5]="bbbbb12";

        return data;

    }
     @Test(dataProvider = "RegistrationData")
   public void ValidRegistrationTest(String DP_Fname,String DP_Lname,String DP_Mail,String DP_Mno,String DP_Pass,String DP_Cpass) throws InterruptedException {
        WebElement FirstName =driver.findElement(By.name("firstname"));
        FirstName.clear();
        FirstName.sendKeys(DP_Fname);
        Thread.sleep(3000);
        WebElement LastName=driver.findElement(By.name("lastname"));
        LastName.clear();
        LastName.sendKeys(DP_Lname);
        Thread.sleep(3000);
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(DP_Mail);
        Thread.sleep(3000);
        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.clear();
        Telephone.sendKeys(DP_Mno);
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Pass);
        Thread.sleep(3000);
        WebElement ConPassword=driver.findElement(By.name("confirm"));
        ConPassword.clear();
        ConPassword.sendKeys(DP_Cpass);
        Thread.sleep(3000);
        WebElement NewsLetter=driver.findElement(By.name("newsletter"));
        NewsLetter.click();
        Thread.sleep(3000);
        WebElement PrivacyBtn=driver.findElement(By.name("agree"));
        PrivacyBtn.click();
        Thread.sleep(3000);
        WebElement ContinueBtn=driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        ContinueBtn.click();
        //logout
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(3000);

        System.out.println("Valid Registration Executed");
    }

}
