package Tests;

import Pages.ExpensesPage;
import Pages.JPersonalInfo;
import Pages.JpreApproval;
import Pages.LoginPage;
import Utils.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpensesTest extends TestBase{
    @Test
    public void validExpensesTest() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.getEmailAddress().sendKeys("123123@example.com");
        login.getPassword().sendKeys("123");
        login.getSignInButton().click();
        login.getMortgageApp().click();
        Thread.sleep(2000);
        JpreApproval approve = new JpreApproval();
        approve.getRealtorinfo().sendKeys("Arthur");
        approve.getEstimatedprice().sendKeys("500000");
        approve.getDownpayment().sendKeys("5000");
        approve.getNextbutton().click();
        JPersonalInfo personal = new JPersonalInfo();
        personal.getFirstname().sendKeys("John");
        personal.getLastname().sendKeys("Wick");
        personal.getEmail().sendKeys("123123@example.com");
        personal.getCalandar().sendKeys("05051980");
        personal.getSsn().sendKeys("123456789");
        personal.getMaritalstatus();
        personal.getCellnumber().sendKeys("123456789");
        personal.getNextbutton().click();
        Thread.sleep(2000);
        ExpensesPage expense = new ExpensesPage();
        expense.getMonthlyMortgagepayment().sendKeys("7000");
        expense.getSavebutton().click();
        String dashboardurl = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),dashboardurl);

    }
}
