package Pages;

import Tests.TestBase;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {

    public PersonalInformationPage(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }

    @FindBy (xpath = "//label[@for='proposalTitle1']")
    private WebElement applyingWithCoBorrower;


    @FindBy (xpath = "//div[@class='col-sm-6']//ul[@class='list-unstyled mb-0']")
    private WebElement getYesOrNoCheckBox;

    @FindBy (xpath = "//div[@class='checkbox checkbox-primary checkbox-glow']//label[@for='realtor1']")
    private WebElement yesCheckBox;

    @FindBy (xpath = "//div[@class='checkbox checkbox-danger checkbox-glow']//label[@for='realtor2']")
    private WebElement noCheckBox;

//    @FindBy (xpath = "//div[@class='col-sm-6']//ul[@class='list-unstyled mb-0']")
//    private WebElement yesOrNoCheckBox;

    @FindBy (xpath = "//input[@id='b_firstName']")
    private WebElement firstNameField;

    @FindBy (xpath = "//input[@id='b_middleName']")
    private WebElement middleNameField;

    @FindBy (xpath = "//input[@id='b_lastName']")
    private WebElement lastNameField;

    @FindBy (xpath = "//input[@id='b_email']")
    private WebElement emailFieldBorrower;

    @FindBy (xpath = "//input[@id='b_ssn']")
    private WebElement ssnFieldBorrower;

    @FindBy (xpath ="//span[@class='select2-results']//ul[@role='tree']" )
    private WebElement maritalField;
    ////div[@data-select2-id='16']//span[@class='select2-selection__arrow']


    @FindBy (xpath = "//input[@class='select2-search__field']")
    private WebElement suffixField;

    @FindBy (xpath = "//input[@id='c_firstName']")
    private WebElement firstNameCoBorrower;

    @FindBy (xpath = "//input[@id='c_middleName']")
    private WebElement middleNameCoBorrower;

    @FindBy (xpath = "//input[@id='c_lastName']")
    private WebElement lastNameCoBorrower;

    @FindBy (xpath = "//input[@class='select2-search__field']")
    private WebElement suffixCoBorrower;

    @FindBy (xpath = "//input[@id='exampleInputEmail1']")
    private WebElement email;

    @FindBy (xpath = "//input[@id='b_dob']")
    private WebElement dobBorrower;


    @FindBy (xpath = "//input[@id='b_cell']")
    private WebElement cellphoneBorrower;

    @FindBy (xpath = "//input[@id='b_home']")
    private  WebElement homephoneBorrower;

    @FindBy (xpath = "//input[@id='c_cell']")
    private WebElement cellphoneCoBorrower;

    @FindBy (xpath = "//input[@id='c_home']")
    private WebElement homephoneCoBorrower;

    @FindBy (xpath = "//input[@id='c_ssn']")
    private WebElement ssnFieldCoBorrower;

    @FindBy (xpath = "//input[@id='c_dob']")
    private WebElement dobCoBorrwer;

    @FindBy (xpath = "//input[@id='c_email']")
    private WebElement emailCoBorrower;



    //==============================



    public WebElement getApplyingWithCoBorrower() {
        return applyingWithCoBorrower;
    }

    public WebElement getGetYesOrNoCheckBox() {
        return getYesOrNoCheckBox;
    }

    public WebElement getYesCheckBox() {
        return yesCheckBox;
    }

    public WebElement getNoCheckBox() {
        return noCheckBox;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getMiddleNameField() {
        return middleNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailFieldBorrower() {
        return emailFieldBorrower;
    }

    public WebElement getSsnFieldBorrower() {
        return ssnFieldBorrower;
    }

    public WebElement getMaritalField() {
        return maritalField;
    }

    public WebElement getSuffixField() {
        return suffixField;
    }

    public WebElement getFirstNameCoBorrower() {
        return firstNameCoBorrower;
    }

    public WebElement getMiddleNameCoBorrower() {
        return middleNameCoBorrower;
    }

    public WebElement getLastNameCoBorrower() {
        return lastNameCoBorrower;
    }

    public WebElement getSuffixCoBorrower() {
        return suffixCoBorrower;
    }

    public void getPIpage(){
        Driver.getDriver().findElement(By.linkText("Personal Information")).click();
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getDobBorrower() {
        return dobBorrower;
    }

    public WebElement getCellphoneBorrower() {
        return cellphoneBorrower;
    }

    public WebElement getHomephoneBorrower() {
        return homephoneBorrower;
    }

    public WebElement getCellphoneCoBorrower() {
        return cellphoneCoBorrower;
    }

    public WebElement getHomephoneCoBorrower() {
        return homephoneCoBorrower;
    }

    public WebElement getSsnFieldCoBorrower() {
        return ssnFieldCoBorrower;
    }

    public WebElement getDobCoBorrwer() {
        return dobCoBorrwer;
    }

    public WebElement getEmailCoBorrower() {
        return emailCoBorrower;
    }
}
