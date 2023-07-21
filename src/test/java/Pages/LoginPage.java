package Pages;
import Utils.ConfigReader;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(id = "exampleInputEmail1")
    private WebElement emailAddress;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    private WebElement mortgageApp;
    @FindBy(xpath = "//a[@class='dropdown-toggle nav-link dropdown-user-link']")
    private WebElement username;
    @FindBy(xpath = "//a[@href='logout.php']")
    private WebElement logoutButton;
    @FindBy (xpath = "//small[@class='mr-25']")
    private WebElement Alreadyhaveaccount;
    @FindBy(xpath = "//span[@class='menu-title']")
    private WebElement dashBoardtitle;
    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getDashBoardtitle() {
        return dashBoardtitle;
    }

    public WebElement getMortgageApp() {
        return mortgageApp;
    }

    public WebElement getAlreadyhaveaccount() {
        return Alreadyhaveaccount;
    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void validLogIn() {
        emailAddress.sendKeys(ConfigReader.getProperty("valid"), Keys.TAB, ConfigReader.getProperty("passcode"), Keys.ENTER);
    }
    public void loginWithValidCredentials(){
        login(ConfigReader.getProperty("email"),ConfigReader.getProperty("password"));
    }
    public void login(String email, String password){
        emailAddress.sendKeys(email, Keys.TAB, password, Keys.ENTER);
    }

    public void validLoginInfo() throws InterruptedException {
        getEmailAddress().sendKeys("rschwand0@soundcloud.com");
        getPassword().sendKeys("aD2Z_oq+k'2b");
        Thread.sleep(1500);
        getSignInButton().click();
        getMortgageApp().click();
    }
}