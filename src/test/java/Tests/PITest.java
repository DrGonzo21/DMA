package Tests;

import Pages.PersonalInformationPage;
import Utils.Driver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PITest extends TestBase {

    @Test
    public void LoginTest() {

        PersonalInformationPage personalInformationPage= new PersonalInformationPage();

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Driver.getDriver().manage().window().maximize();

        personalInformationPage.getEmail().sendKeys("john@gmail.com");
        WebElement pass= Driver.getDriver().findElement(By.id("exampleInputPassword1"));
        pass.sendKeys("abcdef123");
        WebElement signinButton= Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary glow w-100 position-relative']"));
        signinButton.click();

        Driver.getDriver().findElement(By.xpath("//span[@data-i18n='eCommerce']")).click();
        Driver.getDriver().findElement(By.xpath("//label[@for='realtor2']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@name='est_purchase_price']")).sendKeys("12345");
        Driver.getDriver().findElement(By.xpath("//input[@id='downpayment']")).sendKeys("1234");

        //1. initiate a JS to scroll up
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -250)");

        //2.click on Personal Information page
        Driver.getDriver().findElement(By.xpath("//a[@id='steps-uid-0-t-1']//span[@class='icon-title']")).click();
        Driver.getDriver().findElement(By.xpath("//label[@for='coborrower1']")).click();
    }
    @Test
    public void verifyCheckBox() {

        PersonalInformationPage personalInformationPage= new PersonalInformationPage();

        LoginTest();
        //The "Are you applying with a co-borrower?" field should have checkboxes with options "Yes" and "No".
        String labelText= personalInformationPage.getApplyingWithCoBorrower().getText();
        System.out.println(labelText + "\n"+ personalInformationPage.getGetYesOrNoCheckBox().getText());

        //If the user selects "Yes" for the co-borrower question, the page should display an additional section for co-borrower's information.
        WebElement additional= Driver.getDriver().findElement(By.xpath("//div[@class='borrower'][@style='display: block;'] "));
        Assert.assertTrue(additional.isDisplayed());




        // The borrower's and co-borrower's information sections should have input fields for first name, middle name,
        // last name, suffix (if applicable), email, date of birth, SSN, marital status, cell phone, and home phone


        WebElement borrowerList = Driver.getDriver().findElement(By.xpath("//div[@class='borrower']"));

        List<WebElement> elements = new ArrayList<>();
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_firstname']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_middleName']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_lastName']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_suff']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_email']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_dob']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_ssn']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_marital']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_cell']")));
        elements.add(borrowerList.findElement(By.xpath("//label[@for='b_home']")));

        // Assert that all elements are displayed
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

    }

}
