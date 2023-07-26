package Tests;

import Pages.DashboardPage;
import Utils.ConfigReader;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA42_US3_LogoutFunctionality extends TestBase {
@Test
    public void verifyLogoutBtn() throws InterruptedException {
        DashboardPage logoutButton = new DashboardPage();
        logoutButton.getAccountInfo().click();
        Thread.sleep(500);
        logoutButton.getLogout().click();
    Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("url"),"You did not logout");
    }

}
