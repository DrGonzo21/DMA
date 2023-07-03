package Tests;

import Pages.LoginPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginTest extends TestBase {
    @Test
    public void LoginTest() {
        LoginPage login = new LoginPage();
        String filePath = "SignUp.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                if (record.length == 2) {
                    String email = record[0].trim();
                    String password = record[1].trim();

                    login.getEmailAddress().clear();
                    login.getPassword().clear();
                    login.getEmailAddress().sendKeys(email);
                    login.getPassword().sendKeys(password);
                    login.getSignInButton().click();
                    login.getUsername().click();
                    login.getLogoutButton().click();
                    String expected = "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php";
                    Assert.assertEquals(expected, Driver.getDriver().getCurrentUrl());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
