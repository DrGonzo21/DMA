package Tests;

import Pages.SignUpPage;
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
    public SignupButtonHomepage(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }

//    WebDriver driver= new ChromeDriver();

    @FindBy(xpath= "//small[@class='mr-25']")
    private WebElement signupText;

    @FindBy(xpath= "//a[@href='register.php']")
    private WebElement signupButton;

    @Test
    public void verifySignupButton()  {
        setUp();
        Driver.getDriver();
//        driver.get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");

        //Verify “Don't have an account? Sign up” button
        signupText.getText();
        signupButton.getText();

        //Click on Signup button
        signupButton.click();

        //Verify user is redirected to the signup page
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");

        tearDown();

    }

    public WebElement getSignupText() {
        return signupText;
    }

    public WebElement setSignupText() {
        return signupText;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public WebElement setSignupButton() {
        return signupButton;
    }
}
