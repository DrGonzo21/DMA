package Tests;

import JerrodPages.JPersonalInfo;
import JerrodPages.JpreApproval;
import Pages.BorrowerEmploymentPage;
import Pages.ExpensesPage;
import Pages.LoginPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStory7 extends TestBase {




    @Test(groups = {"smoke"})
    public void fillOutEmploymentAndIncomeDetails() throws InterruptedException {

        new LoginPage().validLoginInfo();
        Thread.sleep(1500);
        new JpreApproval().validPreApprovalInfo();
        Thread.sleep(1500);
        new JPersonalInfo().validInfoFillout();
        Thread.sleep(1500);
        new ExpensesPage().validExpensesInfo();
        Thread.sleep(1500);
        new BorrowerEmploymentPage().borrowPageInfo();
        String expected = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expected);
    }
    @Test
    public void FilloutwithEmployer2added()throws InterruptedException {
        new LoginPage().validLoginInfo();
        Thread.sleep(1500);
        new JpreApproval().validPreApprovalInfo();
        Thread.sleep(1500);
        new JPersonalInfo().validInfoFillout();
        Thread.sleep(1500);
        new ExpensesPage().validExpensesInfo();
        Thread.sleep(1500);
        new BorrowerEmploymentPage().borrowPageXtraEmployer();
        String expected = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expected);
    }
    @Test
    public void ClearRemoveButtons() throws InterruptedException {
        new LoginPage().validLoginInfo();
        Thread.sleep(500);
        new JpreApproval().validPreApprovalInfo();
        Thread.sleep(500);
        new JPersonalInfo().validInfoFillout();
        Thread.sleep(500);
        new ExpensesPage().validExpensesInfo();
        Thread.sleep(500);
        new BorrowerEmploymentPage().borrowPageConfirmClearRemoveButtons();
        String expected = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expected);
    }



}

