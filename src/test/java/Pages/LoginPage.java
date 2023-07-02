package Pages;

import Utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }
}
