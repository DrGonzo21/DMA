package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupButton {
    public SignupButton(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }


    @FindBy(xpath= "//small[@class='mr-25']")
    private WebElement signupText;

    @FindBy(xpath= "//a[@href='register.php']")
    private WebElement signupButton;

    public WebElement getSignupText() {
        return signupText;
    }


    public WebElement getSignupButton() {
        return signupButton;
    }

}
