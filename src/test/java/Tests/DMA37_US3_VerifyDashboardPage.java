package Tests;

import Pages.DashboardPage;
import Utils.Driver;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DMA37_US3_VerifyDashboardPage extends TestBase{
   @Test
   public void verifyBankName(){
        DashboardPage accessDashboard = new DashboardPage();
        String actualBankName = accessDashboard.getBankNameLogo().getText();
        String expectedBankName = "DuoBank";
        Assert.assertEquals(actualBankName, expectedBankName);
    }

   @Test
       public void verifyDashboardTitle(){
       DashboardPage title = new DashboardPage();
       String expectedTitle = "Dashboard";
String actualTitle = title.getDashboardTitle().getText();
Assert.assertEquals(actualTitle, expectedTitle, "Title is NOT Dashboard");
    }




    @Test
    public void verifyURL() throws IOException {

        try {
            DashboardPage url = new DashboardPage();
            String actualUrl = Driver.getDriver().getCurrentUrl();
            String expectedUrl = "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php";
            Assert.assertEquals(actualUrl, expectedUrl, "You are not on the Dashboard Page");



        } catch (AssertionError e) {
            File screenshotFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File( screenshotFile + "screenshot" + System.currentTimeMillis() + ".png"));
            System.out.println("Catch block");
            throw e;
        }


    }
}
