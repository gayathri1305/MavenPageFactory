package org.thoughworks.pageobject;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import resources.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public  WebDriver driver;

    ExtentReports extent;
    ExtentTest test;
    @BeforeClass
    public  void reportCreation(){
        //Test report
        extent =new ExtentReports(System.getProperty("user.dir")+"/reports/index.html",true);
        extent.addSystemInfo("Test", "Spree Automation");
        extent.addSystemInfo("Tester", "Gayathri Devi");
        test = extent.startTest("placingOrder");
    }
    @BeforeMethod
    public void initializeDriver() throws Exception {
            System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
            driver=new ChromeDriver();
            driver.get("https://spree-vapasi-prod.herokuapp.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(file, new File("Screenshot/"+result.getName()+".png"));

            //to attach the screenshot in report
            test.log(LogStatus.FAIL,"Test Case Failed is "+result.getName());
            test.log(LogStatus.FAIL,result.getThrowable());
            String screenshotPath= ScreenShot.capture(driver,result.getName());
            test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

        }
        else if(result.getStatus() == ITestResult.SKIP){
            test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        else if(result.getStatus()== ITestResult.SUCCESS){
            test.log(LogStatus.PASS,"Test Case Passed is "+result.getName());
        }

        driver.close();

    }
    @AfterClass
    public void cleanReport(){
        extent.endTest(test);
        extent.flush();
    }
 }
