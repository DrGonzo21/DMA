package Tests;

import Pages.LoginPage;
import Utils.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserName extends TestBase{
    @Test
    public void verifyUserNameDisplayed(){



      LoginPage verifyUserName = new LoginPage();
      verifyUserName.validLogIn();
      String actualUserName = Driver.getDriver().findElement(By.xpath("//div[@class='user-nav d-sm-flex d-none']//span[ @class='user-name']")).getText();

        String expectedUserName = "Masha Mow";
        Assert.assertEquals(actualUserName,expectedUserName);

    }


}
