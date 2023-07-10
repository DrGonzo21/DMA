package Pages;

import Utils.Driver;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
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
    @FindBy (xpath = "//span")
    private WebElement emailerror;

    public WebElement getEmailerror() {
        return emailerror;
    }

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
    public String getRandomEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(8).toLowerCase();
        return generatedString + "@example.com";
    }

    public String getRandomPassword() {
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        while (!containsValidPasswordCriteria(generatedString)) {
            generatedString = RandomStringUtils.randomAlphanumeric(8);
        }
        return generatedString;
    }

    public boolean containsValidPasswordCriteria(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }

    public String getRandomFirstName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String getRandomLastName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public void signUp(){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword1().sendKeys(password);
    }

    public void signUpExistingCustomers(String firstName, String lastName,String email,String password){
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword1().sendKeys(password);
    }

    public void signUpCustomFirstName(String firstName){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String lastName=faker.name().lastName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword1().sendKeys(password);
    }

    public void signUpCustomLastName(String lastName){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword1().sendKeys(password);
    }

    public void signUpCustomEmail(String email){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword1().sendKeys(password);
    }

    public void signUpCustomPassword(String password){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword1().sendKeys(password);
    }



}

