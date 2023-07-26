package Tests;

import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA15_VerifySignInButtonDisabled extends TestBase{

    @Test
    public void isDisabled() throws InterruptedException {

        LoginPage emailLogInOnly = new LoginPage();

          emailLogInOnly.getEmailAddress().sendKeys("Jsmith@yahoo.com");

        Thread.sleep(500);
        emailLogInOnly.getSignInButton().click();
        boolean isSignInButtonDisabled = emailLogInOnly.isButtonDisabledSignInWithEmailOnly(emailLogInOnly.getSignInButton());
        Assert.assertTrue(isSignInButtonDisabled, "Button is Disabled");

        Driver.quitDriver();
    }
}
