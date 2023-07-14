package Tests;

import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA38_US3_VerifyLogoDisplayed extends TestBase{
@Test
    public void verifyLogoDisplayed(){

        DashboardPage getLogo = new DashboardPage();
        boolean isLogoDisplayed = getLogo.getBankLogo().isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Bank Logo is NOT displayed");
    }
}
