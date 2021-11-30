package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;

import org.testng.annotations.*;
import resources.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest extends  Reports{
    public  WebDriver driver;


    @BeforeMethod
    public void initializeDriver(ITestResult result) throws Exception {
        test = extent.createTest(result.getMethod().getMethodName());
        //test = extent.startTest(result.getMethod().getMethodName());// for extent report

            System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
            driver=new ChromeDriver();
            driver.get("https://spree-vapasi-prod.herokuapp.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        reportTest(result, driver);
        //logReport(result, driver);
        driver.quit();
    }

 }
