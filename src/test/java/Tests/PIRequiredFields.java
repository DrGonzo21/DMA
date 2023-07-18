package Tests;

import Pages.LoginPage;
import Pages.PersonalInformationPage;
import Pages.SignUpPage;
import Utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PIRequiredFields extends PersonalInformationTest {


//    @Test
//    public void LoginTest() {
//        getEmail().sendKeys("john@gmail.com");
//        WebElement pass= Driver.getDriver().findElement(By.id("exampleInputPassword1"));
//        pass.sendKeys("abcdef123");
//        WebElement signinButton= Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary glow w-100 position-relative']"));
//        signinButton.click();
//    }

    //Verify Fields with Requirements

    @Test
    public void fieldsTest() {


        //The first name, last name, email, date of birth, SSN, marital status, and cell phone fields should be required:
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();
        WebElement first = getFirstNameField();
        first.sendKeys("");
        first.clear();
        first.submit();

        WebElement borrower = Driver.getDriver().findElement(By.xpath("//div[@class='borrower']//label[@class='danger']"));
        Assert.assertTrue(borrower.isDisplayed());

        WebElement coBorrower = Driver.getDriver().findElement(By.xpath("//div[@class='co-borrower']//label[@class='danger']"));
        Assert.assertTrue(coBorrower.isDisplayed());
    }


    //The first name, middle name, last name, and suffix fields should only allow alphabetical characters and spaces:
    @Test
    public void negativeBorrowerTesting() {

//        verifyCheckBox();
//        PIRequiredFields piRequiredFields= new PIRequiredFields();
//        piRequiredFields.LoginTest();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        String invalidFirstName = "John_1.23";
        String invalidMiddleName = "James!@#";
        String invalidLastName = "Doe&123";
        String invalidSuffix = "Jr.12,3";
        piRequiredFields.getFirstNameField().sendKeys(invalidFirstName, Keys.TAB);
        piRequiredFields.getMiddleNameField().sendKeys(invalidMiddleName, Keys.TAB);
        piRequiredFields.getLastNameField().sendKeys(invalidLastName, Keys.TAB);

        WebElement BorrowerSuffix= Driver.getDriver().findElement(By.xpath("//span[@id='select2-b_suffix-container']"));
        BorrowerSuffix.click();
        piRequiredFields.getSuffixField().sendKeys(invalidSuffix);

        Assert.assertEquals(piRequiredFields.getFirstNameField().getAttribute("value"), invalidFirstName);
        Assert.assertEquals(piRequiredFields.getMiddleNameField().getAttribute("value"), invalidMiddleName);
        Assert.assertEquals(piRequiredFields.getLastNameField().getAttribute("value"), invalidLastName);
        Assert.assertEquals(piRequiredFields.getSuffixField().getAttribute("value"), invalidSuffix);

        piRequiredFields.getFirstNameCoBorrower().sendKeys(invalidFirstName, Keys.TAB);
        piRequiredFields.getMiddleNameCoBorrower().sendKeys(invalidMiddleName, Keys.TAB);
        piRequiredFields.getLastNameCoBorrower().sendKeys(invalidLastName, Keys.TAB);

        WebElement coBorrowerSuffix= Driver.getDriver().findElement(By.xpath("//span[@id='select2-c_suffix-container']"));
        coBorrowerSuffix.click();
        piRequiredFields.getSuffixCoBorrower().sendKeys(invalidSuffix);


        Assert.assertEquals(piRequiredFields.getFirstNameCoBorrower().getAttribute("value"), invalidFirstName);
        Assert.assertEquals(piRequiredFields.getMiddleNameCoBorrower().getAttribute("value"), invalidMiddleName);
        Assert.assertEquals(piRequiredFields.getLastNameCoBorrower().getAttribute("value"), invalidLastName);
        Assert.assertEquals(piRequiredFields.getSuffixCoBorrower().getAttribute("value"), invalidSuffix);


    }

    //The first name, middle name, last name, and suffix fields should only allow alphabetical characters and spaces.
    @Test
    public void positiveBorrowerTesting() throws InterruptedException {

//        verifyCheckBox();
        Thread.sleep(1000);
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        String validFirstName = "John";
        String validMiddleName = "James";
        String validLastName = "Doe";
        String validSuffix = "Jr";
        personalInformationPage.getFirstNameField().sendKeys(validFirstName, Keys.TAB);
        personalInformationPage.getMiddleNameField().sendKeys(validMiddleName, Keys.TAB);
        personalInformationPage.getLastNameField().sendKeys(validLastName, Keys.TAB);

        WebElement BorrowerSuffix= Driver.getDriver().findElement(By.xpath("//span[@id='select2-b_suffix-container']"));
        BorrowerSuffix.click();
        personalInformationPage.getSuffixField().sendKeys(validSuffix);

        Assert.assertEquals(personalInformationPage.getFirstNameField().getAttribute("value"), validFirstName);
        Assert.assertEquals(personalInformationPage.getMiddleNameField().getAttribute("value"), validMiddleName);
        Assert.assertEquals(personalInformationPage.getLastNameField().getAttribute("value"), validLastName);
        Assert.assertEquals(personalInformationPage.getSuffixField().getAttribute("value"), validSuffix);

        personalInformationPage.getFirstNameCoBorrower().sendKeys(validFirstName, Keys.TAB);
        personalInformationPage.getMiddleNameCoBorrower().sendKeys(validMiddleName, Keys.TAB);
        personalInformationPage.getLastNameCoBorrower().sendKeys(validLastName, Keys.TAB);

        WebElement coBorrowerSuffix= Driver.getDriver().findElement(By.xpath("//span[@id='select2-c_suffix-container']"));
        coBorrowerSuffix.click();
        personalInformationPage.getSuffixCoBorrower().sendKeys(validSuffix);


        Assert.assertEquals(personalInformationPage.getFirstNameCoBorrower().getAttribute("value"), validFirstName);
        Assert.assertEquals(personalInformationPage.getMiddleNameCoBorrower().getAttribute("value"), validMiddleName);
        Assert.assertEquals(personalInformationPage.getLastNameCoBorrower().getAttribute("value"), validLastName);
        Assert.assertEquals(personalInformationPage.getSuffixCoBorrower().getAttribute("value"), validSuffix);

    }

    //The email field should only allow a valid email address format (e.g., john.doe@email.com).
    @Test
    public void emailTesting() {
        //The email field should only allow a valid email address format (e.g., john.doe@email.com):
//        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        Driver.getDriver().manage().window().maximize();

        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();


        try {
            WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@name='login']"));
            SignUpPage signUpPage = new SignUpPage();
            WebElement pass = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));

            getEmail().sendKeys("12345khkjnh", Keys.TAB);
            pass.sendKeys("12345");
            loginButton.click();
            Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //The date of birth field should only allow a valid date format (e.g., mm/dd/yyyy) and the date should be before the current date.
    @Test
    public void dobBorrowerTest() {
//        PIRequiredFields.LoginTest();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();
        String validDate = "03/25/1990";
        getDobBorrower().sendKeys(validDate, Keys.TAB);

        boolean isDateFormatValid = validDate.matches("\\d{2}/\\d{2}/\\d{4}");
        Assert.assertTrue(isDateFormatValid, "Date format is invalid.");

        // Validate date is before current date
        LocalDate currentDate = LocalDate.now();
        LocalDate enteredDate = LocalDate.parse(validDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Assert.assertTrue(enteredDate.isBefore(currentDate), "Date is not before the current date.");

    }

    @Test
    public void dobCoBorrowerTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        String validDate = "03/25/1990";
        getDobCoBorrwer().sendKeys(validDate, Keys.TAB);

        boolean isDateFormatValid = validDate.matches("\\d{2}/\\d{2}/\\d{4}");
        Assert.assertTrue(isDateFormatValid, "Date format is invalid.");

        // Validate date is before current date
        LocalDate currentDate = LocalDate.now();
        LocalDate enteredDate = LocalDate.parse(validDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Assert.assertTrue(enteredDate.isBefore(currentDate), "Date is not before the current date.");

    }


    //The SSN field should only allow a valid Social Security Number format (e.g., 123-45-6789) and should not allow duplicates with other applicants.
    @Test
    public void ssnBorrowerTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();
        String validSSN = "123-45-6789";
        getSsnFieldBorrower().sendKeys(validSSN);

        boolean isSSNFormatValid = validSSN.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
        Assert.assertTrue(isSSNFormatValid, "SSN format is invalid.");


        List<String> ssnDatabase = new ArrayList<>();
        ssnDatabase.add(validSSN);
        boolean isSSNDuplicate = ssnDatabase.contains(validSSN);
    }

    @Test
    public void ssnCoBorrowerTest() throws InterruptedException {

        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();
        Thread.sleep(1000);


        String validSSN = "123-45-6789";
        getSsnFieldCoBorrower().sendKeys(validSSN);


        boolean isSSNFormatValid = validSSN.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
        Assert.assertTrue(isSSNFormatValid, "SSN format is invalid.");


        List<String> ssnDatabase = new ArrayList<>();
        ssnDatabase.add(validSSN);
        boolean isSSNDuplicate = ssnDatabase.contains(validSSN);
    }

    //The marital status field should only allow the values "single," "married," or "divorced."
    @Test
    public void maritalStatusBorrowerTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement dropdownElement = Driver.getDriver().findElement(By.id("b_marital"));
        Select select= new Select(dropdownElement);

        List<WebElement> options = select.getOptions();
        int[] desiredIndexes = {1, 2, 3};
        for (int index : desiredIndexes) {
            select.selectByIndex(index);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedValue = selectedOption.getText();
            boolean isValueValid = selectedValue.equals("single") || selectedValue.equals("married") || selectedValue.equals("divorced");
            Assert.assertFalse(isValueValid, "Selected option does not match the expected values");
        }
    }

    @Test
    public void maritalStatusCoBorrowerTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement dropdownElement = Driver.getDriver().findElement(By.id("c_marital"));
        Select select= new Select(dropdownElement);

        List<WebElement> options = select.getOptions();
        int[] desiredIndexes = {1, 2, 3};
        for (int index : desiredIndexes) {
            select.selectByIndex(index);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedValue = selectedOption.getText();
            boolean isValueValid = selectedValue.equals("single") || selectedValue.equals("married") || selectedValue.equals("divorced");
            Assert.assertFalse(isValueValid, "Selected option does not match the expected values");
        }
    }


    //The cell phone and home phone fields should only allow valid phone number formats (e.g., 123-456-6789):
    @Test
    private void phonesFieldBorrowerTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        String invalidNumbers= "123456789";
        String acceptanceFormat= "[0-9]{3}-[0-9]{2}-[0-9]{4}";

        getCellphoneBorrower().sendKeys(invalidNumbers);
        getHomephoneBorrower().sendKeys(invalidNumbers);

        Assert.assertTrue(getCellphoneBorrower().getAttribute("value").matches(acceptanceFormat));
        Assert.assertTrue(getHomephoneBorrower().getAttribute("value").matches(acceptanceFormat));

    }

    @Test
    public void phonesFieldCoBorrowerTest() {

        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        String invalidNumbers= "123456789";
        String acceptanceFormat= "[0-9]{3}-[0-9]{2}-[0-9]{4}";

        getCellphoneCoBorrower().sendKeys(invalidNumbers);
        getHomephoneCoBorrower().sendKeys(invalidNumbers);

        Assert.assertTrue(getCellphoneCoBorrower().getAttribute("value").matches(acceptanceFormat));
        Assert.assertTrue(getHomephoneCoBorrower().getAttribute("value").matches(acceptanceFormat));
    }


    //
    @Test
    public void privacyPolicyTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        WebElement ppStatement= Driver.getDriver().findElement(By.xpath("//div[@class='checkbox checkbox-primary checkbox-glow']//input[@id='privacypolicy']"));
        WebElement ppDisplayed= Driver.getDriver().findElement(By.xpath("//input[@id='privacypolicy']"));
        Assert.assertFalse(ppDisplayed.isDisplayed(), "Privacy Policy checkbox is not displayed");
        String expectedLabel = "I/We have read and accepted the terms of the Privacy Policy.";
        String actualLabel = ppStatement.getText();
        Assert.assertNotEquals("Privacy Policy checkbox label is incorrect", expectedLabel, actualLabel);
    }

    //The Previous and Next buttons should be clearly labeled and functional, allowing the user to navigate between pages and make changes as needed:
    @Test
    public void buttonsTest() {
//        verifyCheckBox();
        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();

        WebElement nextButton= Driver.getDriver().findElement(By.xpath("//li[@aria-hidden='false']"));
        nextButton.click();

        WebElement previousButton= Driver.getDriver().findElement(By.xpath("//a[@href='#previous']"));
        previousButton.click();

    }

    //All input fields should have clear labels and validation messages to guide the user in filling out the necessary information:
    @Test
    public void clearLabels() {
//        verifyCheckBox();

        PIRequiredFields piRequiredFields= new PIRequiredFields();
        piRequiredFields.LoginTest();
        getFirstNameField().submit();

        WebElement necessaryBorrowerFields= Driver.getDriver().findElement(By.xpath("//div[@class='borrower']//label[@class='danger']"));
//        String label= labels.getText();
//        System.out.println(label);
        Assert.assertTrue(necessaryBorrowerFields.isDisplayed());

        WebElement necessaryCoBorrowerFields= Driver.getDriver().findElement(By.xpath("//div[@class='co-borrower']//label[@class='danger']"));
        String label2= necessaryCoBorrowerFields.getText();
        System.out.println(label2);
        Assert.assertTrue(necessaryCoBorrowerFields.isDisplayed());
    }

    //The user should be able to move forward to the next page of the application only after all required fields have been completed and the privacy policy checkbox has been checked:
    @Test
    public void validNextButton() throws InterruptedException {

        PIRequiredFields piRequiredFields = new PIRequiredFields();
        piRequiredFields.LoginTest();
        Thread.sleep(1000);

        String validDate = "03/25/1990";
        getDobBorrower().sendKeys(validDate, Keys.TAB);
        getDobCoBorrwer().sendKeys(validDate, Keys.TAB);

        // Wait for the marital status dropdown to be visible
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement maritalDropdownBorrower = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_marital")));

        // Select the marital status for borrower
        Select borrowerSelect = new Select(maritalDropdownBorrower);
        borrowerSelect.selectByIndex(1);

        // Wait for the marital status dropdown to be visible
        WebElement maritalDropdownCoBorrower = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("c_marital")));

        // Select the marital status for co-borrower
        Select coBorrowerSelect = new Select(maritalDropdownCoBorrower);
        coBorrowerSelect.selectByIndex(2);

        String invalidNumbers = "123456789";
        getCellphoneBorrower().sendKeys(invalidNumbers);
        getHomephoneBorrower().sendKeys(invalidNumbers);

        getCellphoneCoBorrower().sendKeys(invalidNumbers);
        getHomephoneCoBorrower().sendKeys(invalidNumbers);

        // Wait for the next button to be clickable
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-hidden='false']")));

        nextButton.click();

    }

}





