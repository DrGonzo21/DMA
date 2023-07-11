package Tests;

import Pages.SignUpPage;
import Pages.SignupButton;
import Utils.ConfigReader;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupButtonHomepage extends TestBase{


    @Test
    public void verifySignupButton()  {
        SignupButton signup= new SignupButton();
        //Verify “Don't have an account? Sign up” button
        System.out.println(signup.getSignupText().getText());
        System.out.println(signup.getSignupButton().getText());

        //Click on Signup button
        signup.getSignupText().click();

        //Verify user is redirected to the signup page
        Assert.assertEquals( Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");


    }


}
