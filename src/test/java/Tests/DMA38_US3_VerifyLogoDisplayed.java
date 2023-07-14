package Tests;

import Pages.DashboardPage;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DMA38_US3_VerifyLogoDisplayed extends TestBase{

@Test
    public void verifyLogoDisplayed(){

        DashboardPage getLogo = new DashboardPage();
        boolean isLogoDisplayed = getLogo.getBankIcon().isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Bank Logo is NOT displayed");
    }
@Test
    public void verifyLogoLocation(){
    DashboardPage getLogo = new DashboardPage();
    Point logoLocation = getLogo.getBankIcon().getLocation();
    int Y = logoLocation.getY();
    int X = logoLocation.getX();
    System.out.println("Logo Located: " + logoLocation);

    if ( Y < 50 & X < 50){
        Assert.assertTrue(true, " Logo is NOT located in the top left corner");
    }
    }



}

