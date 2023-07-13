package Tests;

import Pages.ExpensesPage;
import Pages.JPersonalInfo;
import Pages.JpreApproval;
import Pages.LoginPage;
import Utils.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpensesTest extends TestBase {

        Faker faker = new Faker();

        @Test(groups = {"smoke"})
        public void validTestRenting() {

                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys("123123@example.com");
                login.getPassword().sendKeys("123");
                login.getSignInButton().click();
                login.getMortgageApp().click();
                JpreApproval approve = new JpreApproval();
                approve.getRealtorinfo().sendKeys(faker.name().firstName());
                approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(100, 5000000)));
                approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(100, 10000)));
                approve.getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1, 100)));
                approve.getNextbutton().click();
                JPersonalInfo personal = new JPersonalInfo();
                personal.getFirstname().sendKeys(faker.name().firstName());
                personal.getLastname().sendKeys(faker.name().lastName());
                personal.getEmail().sendKeys(faker.internet().emailAddress());
                personal.getCalandar().sendKeys("05051980");
                personal.getSsn().sendKeys(faker.idNumber().ssnValid());
                personal.getMaritalstatus();
                personal.getCellnumber().sendKeys(faker.phoneNumber().cellPhone());
                personal.getNextbutton().click();
                ExpensesPage expense = new ExpensesPage();
                expense.getRentalpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 3000)));
                expense.getSavebutton().click();
                String dashboardurl = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
                Assert.assertEquals(Driver.getDriver().getCurrentUrl(), dashboardurl);
        }

        @Test
        public void validTestOwning(String email, String password) throws InterruptedException {

                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys(email);
                login.getPassword().sendKeys(password);
                login.getSignInButton().click();
                login.getMortgageApp().click();
                JpreApproval approve = new JpreApproval();
                approve.getRealtorinfo().sendKeys(faker.name().firstName());
                approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000, 1000000)));
                approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 50000)));
                approve.getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1, 100)));
                approve.getNextbutton().click();
                JPersonalInfo personal = new JPersonalInfo();
                personal.getFirstname().sendKeys(faker.name().firstName());
                personal.getLastname().sendKeys(faker.name().lastName());
                personal.getEmail().sendKeys(faker.internet().emailAddress());
                personal.getCalandar().sendKeys("05051980");
                personal.getSsn().sendKeys(faker.idNumber().ssnValid());
                personal.getMaritalstatus().click();
                personal.getCellnumber().sendKeys(faker.phoneNumber().cellPhone());
                personal.getNextbutton().click();
                ExpensesPage expense = new ExpensesPage();
                expense.getOwncheckbox().click();
                Thread.sleep(1500);
                expense.getMortgagepayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 3000)));
                expense.getSavebutton().click();
                String dashboardUrl = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
                Assert.assertEquals(Driver.getDriver().getCurrentUrl(), dashboardUrl);
        }

        @Test(groups = {"smoke"})
        public void MonthlyRentalNonNumeric() throws InterruptedException {

                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys("123123@example.com");
                login.getPassword().sendKeys("123");
                login.getSignInButton().click();
                login.getMortgageApp().click();
                JpreApproval approve = new JpreApproval();
                approve.getRealtorinfo().sendKeys(faker.name().firstName());
                approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000, 1000000)));
                approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 50000)));
                approve.getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1, 100)));
                approve.getNextbutton().click();
                JPersonalInfo personal = new JPersonalInfo();
                personal.getFirstname().sendKeys(faker.name().firstName());
                personal.getLastname().sendKeys(faker.name().lastName());
                personal.getEmail().sendKeys(faker.internet().emailAddress());
                personal.getCalandar().sendKeys("05051980");
                personal.getSsn().sendKeys(faker.idNumber().ssnValid());
                personal.getMaritalstatus().click();
                personal.getCellnumber().sendKeys(faker.phoneNumber().cellPhone());
                personal.getNextbutton().click();
                ExpensesPage expense = new ExpensesPage();
                expense.getRentalpayment().sendKeys("e");
                expense.getSavebutton().click();
                String actualErrorMessage = expense.getMonthlypaymenterror().getText();
                String expectedErrorMessage = " PLEASE ENTER A VALID NUMBER.";
                System.out.println("Actual Error Message: " + actualErrorMessage);
                System.out.println("Expected Error Message: " + expectedErrorMessage);
                Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
        }
        @Test
        public void MonthlyRentalnovalue() throws InterruptedException {

                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys("123123@example.com");
                login.getPassword().sendKeys("123");
                login.getSignInButton().click();
                login.getMortgageApp().click();
                JpreApproval approve = new JpreApproval();
                approve.getRealtorinfo().sendKeys(faker.name().firstName());
                approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000, 1000000)));
                approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 50000)));
                approve.getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1, 100)));
                approve.getNextbutton().click();
                JPersonalInfo personal = new JPersonalInfo();
                personal.getFirstname().sendKeys(faker.name().firstName());
                personal.getLastname().sendKeys(faker.name().lastName());
                personal.getEmail().sendKeys(faker.internet().emailAddress());
                personal.getCalandar().sendKeys("05051980");
                personal.getSsn().sendKeys(faker.idNumber().ssnValid());
                personal.getMaritalstatus().click();
                personal.getCellnumber().sendKeys(faker.phoneNumber().cellPhone());
                personal.getNextbutton().click();
                ExpensesPage expense = new ExpensesPage();
                expense.getRentalpayment().sendKeys("");
                expense.getSavebutton().click();
                Thread.sleep(1500);
                String actualErrorMessage = expense.getMonthlypaymenterror().getText();
                String expectedErrorMessage = " THIS FIELD IS REQUIRED.";
                System.out.println("Actual Error Message: " + actualErrorMessage);
                System.out.println("Expected Error Message: " + expectedErrorMessage);
                Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
        }
        @Test
        public void MortgageRentalnovalue() throws InterruptedException {

                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys("123123@example.com");
                login.getPassword().sendKeys("123");
                login.getSignInButton().click();
                login.getMortgageApp().click();
                JpreApproval approve = new JpreApproval();
                approve.getRealtorinfo().sendKeys(faker.name().firstName());
                approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000, 1000000)));
                approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 50000)));
                approve.getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1, 100)));
                approve.getNextbutton().click();
                JPersonalInfo personal = new JPersonalInfo();
                personal.getFirstname().sendKeys(faker.name().firstName());
                personal.getLastname().sendKeys(faker.name().lastName());
                personal.getEmail().sendKeys(faker.internet().emailAddress());
                personal.getCalandar().sendKeys("05051980");
                personal.getSsn().sendKeys(faker.idNumber().ssnValid());
                personal.getMaritalstatus().click();
                personal.getCellnumber().sendKeys(faker.phoneNumber().cellPhone());
                personal.getNextbutton().click();
                ExpensesPage expense = new ExpensesPage();
                expense.getOwncheckbox().click();
                expense.getMortgagepayment().sendKeys("");
                expense.getSavebutton().click();
                Thread.sleep(1500);
                String actualErrorMessage = expense.getMortgagepaymenterror().getText();
                String expectedErrorMessage = " THIS FIELD IS REQUIRED.";
                System.out.println("Actual Error Message: " + actualErrorMessage);
                System.out.println("Expected Error Message: " + expectedErrorMessage);
                Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
        }
}


