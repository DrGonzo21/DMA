package Tests;

import Pages.DashboardPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA39_US3_VerifyMortgageAppButton extends TestBase {
@Test
    public void verifyMortgageApplicationLink(){

        DashboardPage  mortgageLink = new DashboardPage();
        String actualButtonText =  mortgageLink.getMortgageApplication().getText();
        String expectedButtonText = "Mortgage Application";
        Assert.assertEquals(actualButtonText,expectedButtonText, "Button name does not match");


    }
}
