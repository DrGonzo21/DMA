package Pages;

import Utils.ConfigReader;
import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public   DashboardPage(){

        PageFactory.initElements(Driver.getDriver(),this);
        LoginPage login = new LoginPage();
        login.getEmailAddress().sendKeys(ConfigReader.getProperty("valid")  );
        login.getPassword().sendKeys(ConfigReader.getProperty("passcode"));
        login.getSignInButton().click();
        login.getMortgageApp().click();
            }



    @FindBy(xpath = "//a[@href='mortgage.php']")
    private WebElement mortgageApplication;

    @FindBy(xpath = "//div[@class='brand-logo']")
    private WebElement bankIcon;

    @FindBy(xpath = " //h2[@class='brand-text mb-0'] ")
    private WebElement bankNameLogo;





    public WebElement getBankNameLogo() {
        return bankNameLogo;
    }

    public WebElement getBankIcon() {
        return bankIcon;
    }

    public WebElement getMortgageApplication() {
        return mortgageApplication;
    }
}


