package com.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser_loginTest {

    WebDriver driver;
    /*
Using BeforeClass and AfterClass
@BeforeClass execute only one time for all @Test method
@AfterClass execute only one time after all @Test method
 */
    /* here you can use @BeforeMethod,@BeforeTest,@ @AfterMethod,@AfterTest instead of @BeforeClass,@AfterClass.
    and see the changes.*/
    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else{
            System.out.println("No Browser Found");
        }
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1,description = "Email and Password are Valid.")
    public void ValidLoginTest_1() throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("123456");
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Logout
        //Same. so comment
        //WebElement Logout=driver.findElement(By.linkText("Logout"));
        // Logout.click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);

        /* we can't use it because after use this , it go to dashboard . So next test methods can not get login page
        and can't execute.Though it works in @BeforeMethod
        driver.findElement(By.cssSelector("#content > div > div > a")).click();
         */

        System.out.println("ValidLoginTest_1 Executed");
    }


    @Test(priority = 2,description = "Email valid and Password InValid.")
    public void ValidLoginTest_2() throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("zas22");
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        System.out.println("ValidLoginTest_2 Executed");
    }
    @Test(priority = 3,description = "Email and Password are InValid.")
    public void ValidLoginTest_3() throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail");
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("");
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
        System.out.println("ValidLoginTest_3 Executed");
    }

}
