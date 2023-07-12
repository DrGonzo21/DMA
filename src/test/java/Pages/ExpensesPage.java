package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensesPage {
    public ExpensesPage(){

            PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
        }
        @FindBy (xpath = "//label[@id='monthlyrentalpayment-error']")
                private WebElement monthlypaymenterror;
        @FindBy (xpath = "//input[@id='expense1']")
                private WebElement rentcheckbox;
        @FindBy(xpath = "//input[@id='expense2']")
    private WebElement owncheckbox;
        @FindBy (xpath = "//input[@id='monthlyrentalpayment']")
     private WebElement monthlyMortgagepayment;
      @FindBy (xpath = "//label[@for='firtmortagagetotalpayment']")
    private WebElement mortgagepaymentlabel;
      @FindBy (xpath = "//label[@for='monthlyrentalpayment'][1]")
    private WebElement monthlypaymentlabel;
      @FindBy (xpath = "//a[@href='#previous']")
    private WebElement previousbutton;
      @FindBy (xpath = "//a[@href='#finish']")
    private WebElement savebutton;

    public WebElement getMonthlypaymenterror() {
        return monthlypaymenterror;
    }

    public WebElement getRentcheckbox() {
        return rentcheckbox;
    }

    public WebElement getOwncheckbox() {
        return owncheckbox;
    }

    public WebElement getMonthlyMortgagepayment() {
        return monthlyMortgagepayment;
    }

    public WebElement getMortgagepaymentlabel() {
        return mortgagepaymentlabel;
    }

    public WebElement getMonthlypaymentlabel() {
        return monthlypaymentlabel;
    }

    public WebElement getPreviousbutton() {
        return previousbutton;
    }

    public WebElement getSavebutton() {
        return savebutton;
    }
}

