package Tests;

import JerrodPages.JPersonalInfo;
import JerrodPages.JpreApproval;
import Pages.ExpensesPage;
import Pages.LoginPage;
import Utils.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpensesTest extends TestBase {

        Faker faker = new Faker();
        @DataProvider(name = "customers", parallel = true)
        public Object[][] provideCustomerData() {

                Object[][] data = {
                        {"123123@example.com", "123"},
                        {"fnilleqc@example.com", "sh55h5J0"},
                        {"zxmluewd@example.com", "Xp1AVIkP"},
                        {"egtxvaix@example.com","TXuILgs0"},
                        {"ypqzxkyd@example.com","yPQXr3rZ"},
                        {" udbytikjhb@example.com","yEeWFNG2"},
                        {"ebolcyzpks@example.com","7a4sreC9"}
                };
                return data;
        }

        @Test(groups = {"smoke"}, dataProvider = "customers")
        public void validTestRenting(String email, String password) {

                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys(email);
                login.getPassword().sendKeys(password);
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

        @Test(dataProvider = "customers")
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

        @Test(groups = {"smoke"}, dataProvider = "customers")
        public void MonthlyRentalNonNumeric(String email, String password) throws InterruptedException {

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
                expense.getRentalpayment().sendKeys("e");
                expense.getSavebutton().click();
                String actualErrorMessage = expense.getMonthlypaymenterror().getText();
                String expectedErrorMessage = " PLEASE ENTER A VALID NUMBER.";
                System.out.println("Actual Error Message: " + actualErrorMessage);
                System.out.println("Expected Error Message: " + expectedErrorMessage);
                Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
        }
        @Test(dataProvider = "customers")
        public void MonthlyRentalnovalue(String email, String password) throws InterruptedException {

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
                expense.getRentalpayment().sendKeys("");
                expense.getSavebutton().click();
                Thread.sleep(1500);
                String actualErrorMessage = expense.getMonthlypaymenterror().getText();
                String expectedErrorMessage = " THIS FIELD IS REQUIRED.";
                System.out.println("Actual Error Message: " + actualErrorMessage);
                System.out.println("Expected Error Message: " + expectedErrorMessage);
                Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
        }
        @Test(dataProvider = "customers")
        public void MortgageRentalnovalue(String email, String password) throws InterruptedException {

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
                expense.getMortgagepayment().sendKeys("");
                expense.getSavebutton().click();
                Thread.sleep(1500);
                String actualErrorMessage = expense.getMortgagepaymenterror().getText();
                String expectedErrorMessage = " THIS FIELD IS REQUIRED.";
                System.out.println("Actual Error Message: " + actualErrorMessage);
                System.out.println("Expected Error Message: " + expectedErrorMessage);
                Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
        }
        @Test
        public void VerifyPreviousNextButton() throws InterruptedException {
                LoginPage login = new LoginPage();
                login.getEmailAddress().sendKeys("123123@example.com");
                login.getPassword().sendKeys("123");
                login.getSignInButton().click();
                Thread.sleep(1500);
                login.getMortgageApp().click();
                JpreApproval pre = new JpreApproval();
                pre.getRealtorinfo().sendKeys(faker.name().firstName());
                pre.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000,100000)));
                pre.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(10000,50000)));
                pre.getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1,100)));
                pre.getNextbutton().click();
                JPersonalInfo person = new JPersonalInfo();
                person.getFirstname().sendKeys(faker.name().firstName());
                person.getLastname().sendKeys(faker.name().lastName());
                person.getEmail().sendKeys(faker.internet().emailAddress());
                person.getCalandar().sendKeys("02201990");
                person.getSsn().sendKeys(faker.idNumber().ssnValid());
                person.getMaritalstatus().click();
                person.getCellnumber().sendKeys(faker.phoneNumber().cellPhone());
                person.getNextbutton().click();
                ExpensesPage expense = new ExpensesPage();
                expense.getOwncheckbox().click();
                expense.getMortgagepayment().sendKeys(String.valueOf(faker.random().nextInt(500,3000)));
                expense.getPreviousbutton().click();
                person.getNextbutton().click();
                expense.getSavebutton().click();
                String dashboardUrl = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
                Assert.assertEquals(Driver.getDriver().getCurrentUrl(), dashboardUrl);

        }
}


