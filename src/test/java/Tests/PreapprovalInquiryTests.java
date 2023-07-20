package Tests;

import Pages.*;
import Utils.CSVReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PreapprovalInquiryTests extends TestBase{


    @DataProvider(name = "applicants")
    public Object [][] getData(){

        return CSVReader.readFromCSVFile("applicants.csv");
    }

    @Test(dataProvider = "applicants")
    public void fillOutApplication(String firstName,
                                   String lastName,
                                   String email,
                                   String dob,
                                   String ssn,
                                   String cellPhone,
                                   String homePhone){
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        personalInformationPage.getNoCheckBox();
        personalInformationPage.getFirstNameField().sendKeys(firstName);
        personalInformationPage.getLastNameField().sendKeys(lastName);
        personalInformationPage.getEmailFieldBorrower().sendKeys(email);
        personalInformationPage.getDobBorrower().sendKeys(dob);
        personalInformationPage.getSsnFieldBorrower().sendKeys(ssn);

        Select status = new Select(personalInformationPage.getMaritalField2());
        status.selectByIndex(2);
        personalInformationPage.getCellphoneBorrower().sendKeys(cellPhone);
        personalInformationPage.getHomephoneBorrower().sendKeys(homePhone);
        personalInformationPage.getNextButton().click();

        ExpensesPage expensesPage = new ExpensesPage();
        expensesPage.getRentalpayment().sendKeys("1000");
        expensesPage.getNextButton().click();

    }

}
