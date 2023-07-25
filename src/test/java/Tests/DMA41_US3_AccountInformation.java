package Tests;

import Pages.DashboardPage;
import Utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA41_US3_AccountInformation extends TestBase {
    @Test
    public void isInfoDisplayed(){
        DashboardPage userInfo = new DashboardPage();
        Assert.assertTrue(userInfo.getAccountInfo().isDisplayed(), " Account information is displayed");
    }

    @Test
    public void verifyAccountInformation(){
        DashboardPage userInfo = new DashboardPage();
        String actualInformation = userInfo.getAccountInfo().getText();
        String expectedInformation =""+ ConfigReader.getProperty("firstname")+" "+ConfigReader.getProperty("lastname");
        Assert.assertEquals(actualInformation, expectedInformation," Information do not match");
    }
}
