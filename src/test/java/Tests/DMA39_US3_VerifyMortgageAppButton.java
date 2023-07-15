package Tests;

import Pages.DashboardPage;
import org.openqa.selenium.WebElement;
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

    @Test
    public void verifyButtonVisibility(){
        DashboardPage verifyMortgageButton = new DashboardPage();
        WebElement mortgageButton= verifyMortgageButton.getMortgageApplication();
        boolean isMortgageButtonVisible =  verifyMortgageButton.isButtonVisible(mortgageButton);
        Assert.assertTrue(isMortgageButtonVisible, "Mortgage button is NOT visible");
    }

    @Test
    public void verifyButtonEnabled(){
        DashboardPage mortgageButtonEnabled = new DashboardPage();
        WebElement mortgageButton = mortgageButtonEnabled.getApplicationListButton();
        boolean isMortgageButtonEnabled = mortgageButtonEnabled.isButtonEnabled(mortgageButton);
        Assert.assertTrue(isMortgageButtonEnabled, "Mortgage button is DISABLED");
    }


}
