package Tests;

import Pages.*;
import Utils.CSVReader;
import Utils.Driver;
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

//    @Test(dataProvider = "applicants")
//    public void orderReportOptions(String firstName,
//                            String lastName,
//                            String email,
//                            String dob,
//                            String ssn,
//                            String cellPhone,
//                            String homePhone){
//
//        PreaaprovalInquiryPage preaaprovalInquiryPage = new PreaaprovalInquiryPage();
//        preaaprovalInquiryPage.fillOutApplication(firstName,lastName,email, dob, ssn, cellPhone, homePhone);
//        Assert.assertEquals(preaaprovalInquiryPage.getOrderReport().getText(), "Yes");
//        Assert.assertEquals(preaaprovalInquiryPage.getNoReport().getText(), "No");
//    }

    @Test(dataProvider = "applicants")
    public void orderReport(String firstName,
                            String lastName,
                            String email,
                            String dob,
                            String ssn,
                            String cellPhone,
                            String homePhone){

        PreaaprovalInquiryPage preaaprovalInquiryPage = new PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplication(firstName,lastName,email, dob, ssn, cellPhone, homePhone);
        preaaprovalInquiryPage.getOrderReport();
        preaaprovalInquiryPage.getSaveButton().click();
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");

    }

    @Test(dataProvider = "applicants")
    public void dontOrderReport(String firstName,
                            String lastName,
                            String email,
                            String dob,
                            String ssn,
                            String cellPhone,
                            String homePhone){

        PreaaprovalInquiryPage preaaprovalInquiryPage = new PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplication(firstName,lastName,email, dob, ssn, cellPhone, homePhone);
        preaaprovalInquiryPage.getNoReport();
        preaaprovalInquiryPage.getSaveButton().click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");

    }

}
