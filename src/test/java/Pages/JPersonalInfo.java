package Pages;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JPersonalInfo {
    public JPersonalInfo(){
            PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
        }
        @FindBy (xpath = "//a[@href='#next']")
        private WebElement nextbutton;
    @FindBy (xpath = "//input[@id='b_firstName']")
        private WebElement firstname;
    @FindBy (xpath = "//input[@id='b_middleName']")
        private WebElement middlename;
    @FindBy (xpath = "//input[@id='b_lastName']")
        private WebElement lastname;
    @FindBy (xpath = "//input[@id='b_ssn']")
        private WebElement ssn;
    @FindBy (xpath = "//input[@id='b_email']")
        private WebElement email;
    @FindBy (xpath = "//span[@id='select2-b_marital-container']")
        private WebElement maritalstatus;
    @FindBy (xpath = "//input[@id='b_cell']")
        private WebElement cellnumber;
    @FindBy (xpath = "//input[@id='coborrower2']")
        private WebElement borrowerboxno;
    @FindBy (xpath = "//input[@id='b_dob']")
        private WebElement calandar;

    public WebElement getCalandar() {
        return calandar;
    }

    public WebElement getNextbutton() {
        return nextbutton;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getMiddlename() {
        return middlename;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getSsn() {
        return ssn;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getMaritalstatus() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement maritalStatusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-b_marital-container")));
        maritalStatusDropdown.click();

        WebElement optionMarried = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Married')]")));
        optionMarried.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", maritalStatusDropdown);

        return maritalStatusDropdown;
    }

    public WebElement getCellnumber() {
        return cellnumber;
    }

    public WebElement getBorrowerboxno() {
        return borrowerboxno;
    }
}

