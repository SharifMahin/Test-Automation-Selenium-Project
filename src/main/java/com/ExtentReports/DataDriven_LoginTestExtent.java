package com.ExtentReports;

import com.Utils.Xls_Reader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDriven_LoginTestExtent {


    WebDriver driver;
    /*
Using BeforeClass and AfterClass
@BeforeClass execute only one time for all @Test method
@AfterClass execute only one time after all @Test method
 */
    /* here you can use @BeforeMethod,@BeforeTest,@ @AfterMethod,@AfterTest instead of @BeforeClass,@AfterClass.
    and see the changes.*/

    //Extent Report
    ExtentHtmlReporter htmlReporter;
    ExtentReports reports;
    ExtentTest logger;


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

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(description = "Email and Password are InValid.")
    public void ValidLoginTest_1() throws InterruptedException {

        //Extent report Implementation
        htmlReporter =new ExtentHtmlReporter("./Extent-Reports/LoginTest.html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Information add in Extent Report

        reports.setSystemInfo("Environment","Test");
        reports.setSystemInfo("OS","Windows 10");
        reports.setSystemInfo("Tester","Mahin");

        logger=reports.createTest("Login Test");

        driver.get("https://demo.opencart.com/index.php?route=account/login");
        logger.log(Status.INFO,"Login Page open.");

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/main/TestData/LoginData2.xlsx");
        String sheetName="Sheet1";

        int rowCount= reader.getRowCount(sheetName);

        for(int rowNum=2;rowNum<=rowCount;rowNum++){
            //Email
            String email=reader.getCellData(sheetName,"Email",rowNum);
            //Password
            String pass=reader.getCellData(sheetName,"Password",rowNum);


        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(email);
        logger.log(Status.INFO,"Type Email: "+email);
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(pass);
        logger.log(Status.INFO,"Type Password: "+pass);
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
            logger.log(Status.INFO,"Click on Login Button");
            //Logic for pass/fail
            String Expected_Title="Account Login";
            String Actual_Title=driver.getTitle();

            if(Expected_Title.equals(Actual_Title)){
                logger.log(Status.PASS,"Login Test Passed.");
                //Write on Excel
                reader.setCellData(sheetName,"Actual Result",rowNum,"Login Unsuccess");
                reader.setCellData(sheetName,"Test Status",rowNum,"Passed");
            }
            else {
                //Write on Excel
                logger.log(Status.FAIL,"Login Test Failed.");
                reader.setCellData(sheetName,"Actual Result",rowNum,"Login Success");
                reader.setCellData(sheetName,"Test Status",rowNum,"Failed");
            }
        }
        reports.flush();
    }

}
