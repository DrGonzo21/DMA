package Tests;
import Utils.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.PreapprovalDetailsPage;
import Utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class PreapprovalDetailsTests extends TestBase{

    @DataProvider(name = "realtor")
    public Object [][] getData(){

        return CSVReader.readFromCSVFile("realtor.csv");
    }
    @Test
    public void workingWithRealtorOptions() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        Assert.assertEquals(preapprovalDetailsPage.getHasRealtor().getText(), "Yes");
        Assert.assertEquals(preapprovalDetailsPage.getNoRealtor().getText(), "No");

    }

    @Test(dataProvider = "realtor")
    public void hasRealtorEnterInfo(String realtorInfo) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getHasRealtor().click();
        Assert.assertTrue(preapprovalDetailsPage.getRealtorInfo().isEnabled());
        preapprovalDetailsPage.getRealtorInfo().sendKeys(realtorInfo);
    }

    @Test
    public void hasRealtorInfoRequired() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getHasRealtor().click();
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();
        Assert.assertFalse(preapprovalDetailsPage.getNextPage().isDisplayed());
    }

    @Test(dataProvider = "realtor")
    public void NoRealtorEnterInfo(String realtorInfo) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getNoRealtor().click();
        preapprovalDetailsPage.getRealtorInfo().sendKeys(realtorInfo);
        Assert.assertNotEquals(preapprovalDetailsPage.getRealtorInfo().getText(), realtorInfo);
    }

    @Test
    public void workingWithLoanOfficerOptions() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        Assert.assertEquals(preapprovalDetailsPage.getHasLoanOfficer().getText(), "Yes");
        Assert.assertEquals(preapprovalDetailsPage.getNoLoanOfficer().getText(), "No");

    }

    @Test(groups = {"smoke"})
    public void loanOptions() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();

        List<String> optionsExpected = List.of("Purchase a home", "Refinance", "Construction");
        List<WebElement> elements = new Select(preapprovalDetailsPage.getLoanPurpose()).getOptions();


        List<String> modifiedList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            modifiedList.add(elements.get(i).getText());
        }
        System.out.println(modifiedList);

        Assert.assertEquals(modifiedList, optionsExpected);
    }

    @Test
    public void estPurchasePriceFormatPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        String price = "10000.55";
        preapprovalDetailsPage.getEstPrice().sendKeys(price, Keys.TAB);
        Assert.assertEquals(preapprovalDetailsPage.getEstPrice().getAttribute("value"), price);

    }

    @Test
    public void estPurchasePriceRequired() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();
        Assert.assertFalse(preapprovalDetailsPage.getNextPage().isDisplayed());

    }


    @Test
    public void estPurchasePriceFormatNegative() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        String price = "10000.55555555";
        preapprovalDetailsPage.getEstPrice().sendKeys(price, Keys.TAB);
        Assert.assertNotEquals(preapprovalDetailsPage.getEstPrice().getAttribute("value"), price);

    }

    @Test
    public void downPmntAmountFormatPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getEstPrice().sendKeys("10000", Keys.TAB);
        String downPmnt = "1000.55";
        preapprovalDetailsPage.getDownPayment().sendKeys(downPmnt);
        Assert.assertEquals(preapprovalDetailsPage.getDownPayment().getAttribute("value"), downPmnt);

    }

    @Test
    public void downPmntAmountRequired() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();
        Assert.assertFalse(preapprovalDetailsPage.getNextPage().isDisplayed());

    }


    @Test
    public void downPmntAmountFormatNegative() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        String price = "10000.55555555";
        preapprovalDetailsPage.getEstPrice().sendKeys(price);
        Assert.assertNotEquals(preapprovalDetailsPage.getEstPrice().getAttribute("value"), price);

    }

    @Test
    public void downPmntAmountFormatTab() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getEstPrice().sendKeys("10000", Keys.TAB);
        String downPmnt = "1000.55";
        preapprovalDetailsPage.getDownPayment().sendKeys(downPmnt, Keys.TAB);
        Assert.assertEquals(preapprovalDetailsPage.getDownPayment().getAttribute("value"), downPmnt);

    }

    @Test
    public void downPmntPercentFormatPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getEstPrice().sendKeys("10000", Keys.TAB);
        String downPmntPercent = "10.55";
        preapprovalDetailsPage.getDownPaymentPercent().sendKeys(downPmntPercent);
        Assert.assertEquals(preapprovalDetailsPage.getDownPaymentPercent().getAttribute("value"), downPmntPercent);

    }

    @Test
    public void downPmntPercentFormatNegative() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getEstPrice().sendKeys("10000", Keys.TAB);
        String downPmntPercent = "10.55555";
        preapprovalDetailsPage.getDownPaymentPercent().sendKeys(downPmntPercent);
        Assert.assertNotEquals(preapprovalDetailsPage.getDownPaymentPercent().getAttribute("value"), downPmntPercent);

    }

    @Test
    public void downPmntPercentCalculated() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        String downPmnt = "1000";
        preapprovalDetailsPage.getDownPayment().sendKeys(downPmnt);
        Assert.assertEquals(preapprovalDetailsPage.getDownPaymentPercent().getAttribute("value"), "10");

    }


    @Test
    public void loanAmount() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        Assert.assertEquals(preapprovalDetailsPage.getLoanAmount().getText(), "9000 $");

    }

    @Test
    public void downPmntSource() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();

        List<String> optionsExpected = List.of("Checking/Savings (most recent bank statement)",
                "Equity on Pending Sale (executed sales contract)",
                "Other type of Down Payment");
        List<WebElement> elements = new Select(preapprovalDetailsPage.getSrcDownPayment()).getOptions();


        List<String> modifiedList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            modifiedList.add(elements.get(i).getText());
        }
        System.out.println(modifiedList);

        Assert.assertEquals(modifiedList, optionsExpected);
    }

    @Test
    public void additionalFundsNegative() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getAdditionalFunds().sendKeys("1000.222222", Keys.TAB);
        Assert.assertNotEquals(preapprovalDetailsPage.getAdditionalFunds().getAttribute("value"), "1000.222222");


    }

    @Test
    public void additionalFundsPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getAdditionalFunds().sendKeys("1000.22", Keys.TAB);
        Assert.assertEquals(preapprovalDetailsPage.getAdditionalFunds().getAttribute("value"), "1000.22");


    }

    @Test(groups = {"smoke"})
    public void nextButtonFunctionality() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();
        Assert.assertFalse(preapprovalDetailsPage.getNextPage().isDisplayed());


    }

    @Test(groups = {"smoke"})
    public void successfulSubmission() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();
        Assert.assertTrue(preapprovalDetailsPage.getNextPage().isDisplayed());


    }
}
