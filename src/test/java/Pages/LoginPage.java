package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }


    @FindBy (id = "exampleInputEmail1")
    private WebElement emailAddress;
    @FindBy (id = "exampleInputPassword1")
    private WebElement password;
    @FindBy (xpath = "//button[@type='submit']")
    private WebElement SignInButton;
    @FindBy (xpath = "//a[@class='dropdown-toggle nav-link dropdown-user-link']")
    private WebElement username;
    @FindBy (xpath = "//a[@href='logout.php']")
    private WebElement logoutButton;
    @FindBy (xpath = "//span[@class='menu-title']")
    private WebElement dashBoardtitle;

    public WebElement getDashBoardtitle() {
        return dashBoardtitle;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getSignInButton() {
        return SignInButton;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

}
