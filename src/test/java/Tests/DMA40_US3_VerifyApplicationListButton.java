package Tests;

import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA40_US3_VerifyApplicationListButton extends TestBase {
@Test
    public void verifyMortgageApplicationLink(){

        DashboardPage  mortgageLink = new DashboardPage();
        String actualButtonText =  mortgageLink.getMortgageApplication().getText();
        String expectedButtonText = "Mortgage Application";
        Assert.assertEquals(actualButtonText,expectedButtonText, "Button name does not match");

    }
}
