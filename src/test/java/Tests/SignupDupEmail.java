package Tests;

import Pages.SignUpPage;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignupDupEmail extends TestBase {

    @Test
    public void SignupDupEmail() {
        String filePath = "SignUp.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                if (record.length == 2) {
                    String email = record[0].trim();

                    SignUpPage signup = new SignUpPage();

                    String firstName = signup.getRandomFirstName();
                    String lastName = signup.getRandomLastName();
                    String password = signup.getRandomPassword();

                    signup.getSignUpButton().click();
                    signup.getFirstName().sendKeys(firstName);
                    signup.getLastName().sendKeys(lastName);
                    signup.getEmail().sendKeys(email);
                    signup.getPassword1().sendKeys(password);
                    signup.getRegisterButton().click();

                    writeCredentialsToCSV(email, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCredentialsToCSV(String email, String password) {
        String filePath = "SignupDuplicate.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(email).append(",").append(password).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
