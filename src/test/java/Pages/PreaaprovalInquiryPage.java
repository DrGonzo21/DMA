package Pages;

import Utils.CSVReader;
import Utils.ConfigReader;
import Utils.Driver;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

@Data
public class PreaaprovalInquiryPage {

    public PreaaprovalInquiryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='creditreport1']")
    private WebElement orderReport;

    @FindBy(xpath = "//label[@for='creditreport2']")
    private WebElement noReport;



}
