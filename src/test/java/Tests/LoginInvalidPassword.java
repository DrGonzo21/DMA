package Tests;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginInvalidPassword extends TestBase{
    @Test
    public void LoginInvalidPassword(){

        LoginPage login = new LoginPage();
        String filePath = "SignUp.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                if (record.length == 2) {
                    String email = record[0].trim();
                    String password = "invalid123!";


                    login.getEmailAddress().sendKeys(new SignUpPage().getRandomEmail());
                    login.getPassword().sendKeys(password);
                    login.getSignInButton().click();
                    String expected = "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php";
                    Assert.assertEquals(expected, Driver.getDriver().getCurrentUrl());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}