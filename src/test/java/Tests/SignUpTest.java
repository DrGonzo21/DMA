package Tests;

import Pages.SignUpPage;
import Utils.Driver;
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
}


