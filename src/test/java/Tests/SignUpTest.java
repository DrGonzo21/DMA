package Tests;

import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.Driver;
import Utils.SeleniumWebTools;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;


public class SignUpTest extends TestBase {
    @Test
    public void SignUp() {

        SignUpPage signup = new SignUpPage();

        String firstName = signup.getRandomFirstName();
        String lastName = signup.getRandomLastName();
        String email = signup.getRandomEmail();
        String PassWord = signup.getRandomPassword();

        signup.getSignUpButton().click();
        signup.getFirstName().sendKeys(firstName);
        signup.getLastName().sendKeys(lastName);
        signup.getEmail().sendKeys(email);
        signup.getPassword1().sendKeys(PassWord);
        signup.getRegisterButton().click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Register - Create an Account");

        writeCredentialsToCSV(email, PassWord);
    }

    public void writeCredentialsToCSV(String email, String PassWord) {
        String filePath = "SignUp.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(email).append(",").append(PassWord).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void positiveSignup ()  {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUp();
        signUpPage.getRegisterButton().click();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Registration Successful"));
        new SeleniumWebTools().waitForTitleContains("Login", 3);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
    }

    @Test
    public void negativeSignupNoFirstName ()  {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomFirstName("");
        signUpPage.getRegisterButton().click();

        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupLongFirstName () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomFirstName("sfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejf");
        signUpPage.getRegisterButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupNumbersFirstName () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomFirstName("12345khkjnh");
        signUpPage.getRegisterButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void signUpButtonDisabled () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();
        Assert.assertFalse(new SignUpPage().getSignUpButton().isEnabled());
    }
    @Test
    public void verifyAlreadyHaveAccount(){

        SignUpPage signup = new SignUpPage();
        signup.getSignUpButton().click();
        String actual = signup.getAlreadyHaveAccount().getText();
        String expected = "Already have an account?";
       Assert.assertEquals(actual,expected);
        System.out.println(actual);
        System.out.println(expected);

    }

}


