package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }
    @FindBy (xpath = "//a[@href='register.php']")
    private WebElement SignUpButton;
    @FindBy (id = "inputfirstname4")
    private WebElement firstName;
    @FindBy (id = "inputlastname4")
    private WebElement lastName;
    @FindBy (id = "email")
    private WebElement email;
    @FindBy (id = "exampleInputPassword1")
    private WebElement password1;
    @FindBy (id = "register")
    private WebElement registerButton;

    public WebElement getSignUpButton() {
        return SignUpButton;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword1() {
        return password1;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }
}

