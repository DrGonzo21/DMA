package Tests;

import Utils.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class WelcomeMessage extends TestBase{

    public void verifyMessage(){
       String actualMessage = Driver.getDriver().findElement(By.xpath("//div[@class='card-title']//h4[@class='text-center mb-2']")).getText();
        Assert.assertEquals(actualMessage,"Welcome Back!");

    }



}
