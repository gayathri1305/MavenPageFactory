package resources;
//
//import com.google.common.io.Files;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//import java.io.File;
//import java.io.IOException;
//
public class Report {
//    ExtentReports extent;
//    ExtentTest test;
//
//    @BeforeSuite
//    public  void reportCreation(){
//        //Test report
//        extent =new ExtentReports(System.getProperty("user.dir")+"/reports/index.html",true);
//        extent.addSystemInfo("Test", "Spree Automation");
//        extent.addSystemInfo("Tester", "Gayathri Devi");
//
//    }
//   @BeforeMethod
//    public void reportCreation(ITestResult result) throws Exception {
//        test = extent.startTest(result.getMethod().getMethodName());
//    }
//
//    public void logReport(ITestResult result, WebDriver driver) throws IOException {
//        if(result.getStatus()==ITestResult.FAILURE){
//            File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            Files.copy(file, new File("Screenshot/"+result.getName()+".png"));
//
//            //to attach the screenshot in report
//            test.log(LogStatus.FAIL,"Test Case Failed is "+result.getName());
//            //test.log(LogStatus.FAIL,result.getThrowable());
//            String screenshotPath= ScreenShot.capture(driver,result.getName());
//            test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
//
//        }
//        else if(result.getStatus() == ITestResult.SKIP){
//            test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//        }
//        else if(result.getStatus()== ITestResult.SUCCESS){
//            test.log(LogStatus.PASS,"Test Case Passed is "+result.getName());
//        }
//
//
//    }
//    @AfterSuite
//    public void clearReport(){
//
//        extent.flush();
//    }
}
