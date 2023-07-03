package Tests;

import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.ConfigReader;
import Utils.Driver;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTest extends TestBase {
@Test
   public void SignUp(){

       SignUpPage signup = new SignUpPage();

       String firstName = signup.getRandomFirstName();
       String lastName = signup.getRandomLastName();
       String email = signup.getRandomEmail();
       String PassWord =  signup.getRandomPassword();

      signup.getSignUpButton().click();
      signup.getFirstName().sendKeys(firstName);
      signup.getLastName().sendKeys(lastName);
      signup.getEmail().sendKeys(email);
      signup.getPassword1().sendKeys(PassWord);
      signup.getRegisterButton().click();
      Assert.assertEquals(Driver.getDriver().getTitle(), "Register - Create an Account");

   }

}

