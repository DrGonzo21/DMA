package Tests;

import Pages.LoginPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDashBoard extends TestBase{
    @Test
    public void VerifyDashBoard() throws InterruptedException {

        String dashboard = "Dashboard";

        LoginPage login = new LoginPage();

        login.getEmailAddress().sendKeys("123123@example.com");
        login.getPassword().sendKeys("123");
        login.getSignInButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(dashboard,login.getDashBoardtitle().getText());
    }
}
