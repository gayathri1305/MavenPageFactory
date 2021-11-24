package resources;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    public void takeScreenShotTime(WebDriver driver,String filename) throws IOException {
        DateFormat df = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date date = new Date();
        String currentDateTime = df.format(date);
        String filenameScreen=filename+"_"+currentDateTime+".png";

        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file, new File("Screenshot/"+filenameScreen));

    }
    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") +"/Screenshot/"+screenShotName+".png";
        File fileDestination = new File(destination);
        Files.copy(source, fileDestination);

        return destination;
    }


}
