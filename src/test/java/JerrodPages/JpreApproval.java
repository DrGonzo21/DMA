package JerrodPages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JpreApproval {

    public JpreApproval(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }


    @FindBy (xpath = "//input[@id='realtorinfo']")
        private WebElement realtorinfo;
    @FindBy (xpath = "//input[@id='loanofficer2']")
        private WebElement LOfficerNoBox;
    @FindBy (xpath = "//input[@id='estimatedprice']")
        private WebElement estimatedprice;
    @FindBy (xpath = "//input[@id='downpayment']")
        private WebElement downpayment;
    @FindBy (xpath = "//input[@id='downpaymentpercentage']")
        private WebElement dpPercentage;
    @FindBy (xpath = "//a[@href='#next']")
    private WebElement nextbutton;

    public WebElement getNextbutton() {
        return nextbutton;
    }

    public WebElement getRealtorinfo() {
        return realtorinfo;
    }

    public WebElement getLOfficerNoBox() {
        return LOfficerNoBox;
    }

    public WebElement getEstimatedprice() {
        return estimatedprice;
    }

    public WebElement getDownpayment() {
        return downpayment;
    }

    public WebElement getDpPercentage() {
        return dpPercentage;
    }
}
