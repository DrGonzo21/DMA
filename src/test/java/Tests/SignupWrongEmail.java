package Tests;

import Pages.SignUpPage;
import Utils.Driver;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;

public class SignupWrongEmail extends TestBase {
    @Test
    public void SignupWrongEmail() {
        SignUpPage signup = new SignUpPage();

        String firstName = signup.getRandomFirstName();
        String lastName = signup.getRandomLastName();
        String email = getRandomEmail();
        String password = signup.getRandomPassword();
        signup.getSignUpButton().click();
        signup.getFirstName().sendKeys(firstName);
        signup.getLastName().sendKeys(lastName);
        signup.getEmail().sendKeys(email);
        signup.getPassword1().sendKeys(password);
        signup.getRegisterButton().click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Register - Create an Account");

        writeCredentialsToCSV(email, password);
    }
    public String getRandomEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(300).toLowerCase();
        return generatedString + "@example.com";
    }

    public void writeCredentialsToCSV(String email, String password) {
        String filePath = "SignUp.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(email).append(",").append(password).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


