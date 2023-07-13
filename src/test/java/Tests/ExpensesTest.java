package Tests;

import Pages.ExpensesPage;
import Pages.JPersonalInfo;
import Pages.JpreApproval;
import Pages.LoginPage;
import Utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExpensesTest extends TestBase {
    Faker faker = new Faker();

                @Test(groups = {"smoke"})
                public void validTestRenting () {
                    List<String[]> loginData = readDataFromCSV("SignUp.csv");


                    for (String[] record : loginData) {
                        String email = record[0].trim();
                        String password = record[1].trim();

                        LoginPage login = new LoginPage();
                        login.getEmailAddress().sendKeys(email);
                        login.getPassword().sendKeys(password);
                        login.getSignInButton().click();
                        login.getMortgageApp().click();
                        JpreApproval approve = new JpreApproval();
                        approve.getRealtorinfo().sendKeys(faker.name().firstName());
                        approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(100, 5000000)));
                        approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(100, 10000)));
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
                }
                    @Test
                    public void validTestOwning() throws InterruptedException {
                        List<String[]> loginData = readDataFromCSV("SignUp.csv");

                        for (String[] record : loginData) {
                            String email = record[0].trim();
                            String password = record[1].trim();

                            LoginPage login = new LoginPage();
                            login.getEmailAddress().sendKeys(email);
                            login.getPassword().sendKeys(password);
                            login.getSignInButton().click();
                            login.getMortgageApp().click();
                            JpreApproval approve = new JpreApproval();
                            approve.getRealtorinfo().sendKeys(faker.name().firstName());
                            approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000, 1000000)));
                            approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 50000)));
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
                    }

                    @Test(groups = {"smoke"})
                    public void MonthlyRentalNonNumeric() throws InterruptedException {
                        List<String[]> loginData = readDataFromCSV("SignUp.csv");

                        for (String[] record : loginData) {
                            String email = record[0].trim();
                            String password = record[1].trim();

                            LoginPage login = new LoginPage();
                            login.getEmailAddress().sendKeys(email);
                            login.getPassword().sendKeys(password);
                            login.getSignInButton().click();
                            login.getMortgageApp().click();
                            JpreApproval approve = new JpreApproval();
                            approve.getRealtorinfo().sendKeys(faker.name().firstName());
                            approve.getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(50000, 1000000)));
                            approve.getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 50000)));
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
//                            expense.getRentalpayment().sendKeys(faker.lorem().characters(10));
                            expense.getRentalpayment().sendKeys("e");
                            expense.getSavebutton().click();
                            String actualErrorMessage = expense.getMonthlypaymenterror().getText();
                            String expectedErrorMessage = " PLEASE ENTER A VALID NUMBER.";
                            System.out.println("Actual Error Message: " + actualErrorMessage);
                            System.out.println("Expected Error Message: " + expectedErrorMessage);
                            Assert.assertTrue(actualErrorMessage.trim().contains(expectedErrorMessage.trim()));
                        }
                    }

                    public List<String[]> readDataFromCSV(String filePath) {
                        List<String[]> records = new ArrayList<>();

                        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                String[] record = line.split(",");
                                records.add(record);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return records;
                    }
                }