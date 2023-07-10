package Tests;

import Pages.SignUpPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignupDupEmail extends TestBase {

    @Test
    public void SignupDupEmail() throws InterruptedException {


                    SignUpPage signup = new SignUpPage();

                    signup.getSignUpButton().click();
                    signup.getFirstName().sendKeys("John");
                    signup.getLastName().sendKeys("does");
                    signup.getEmail().sendKeys("123123@example.com", Keys.TAB);
                    Thread.sleep(2000);
                     Assert.assertTrue(signup.getEmailerror().isDisplayed());
                }
            }


