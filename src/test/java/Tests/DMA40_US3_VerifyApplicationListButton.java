package Tests;

import Pages.DashboardPage;
import org.openqa.selenium.WebElement;
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

    @Test
    public void verifyButtonVisibility(){
        DashboardPage verifyApplicationListButton = new DashboardPage();
        WebElement applicationListButton= verifyApplicationListButton.getMortgageApplication();
        boolean isApplicationListButtonVisible =  verifyApplicationListButton.isButtonVisible(applicationListButton);
        Assert.assertTrue(isApplicationListButtonVisible, "Application List button is NOT visible");
    }

  @Test
  public void verifyButtonEnabled(){
    DashboardPage applicationListButtonEnabled = new DashboardPage();
    WebElement applicationListButton = applicationListButtonEnabled.getApplicationListButton();
    boolean isApplicationListButtonEnabled = applicationListButtonEnabled.isButtonEnabled(applicationListButton);
    Assert.assertTrue(isApplicationListButtonEnabled, "Application List button is DISABLED");
    }
}
