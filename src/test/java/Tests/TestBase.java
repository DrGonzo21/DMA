package Tests;
import Utils.ConfigReader;
import Utils.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import Utils.SeleniumWebTools;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    protected static ExtentReports report; // manages the report generation
    protected static ExtentSparkReporter htmlReport; // creates the html report
    protected static ExtentTest logger; // logger object

    @BeforeSuite(alwaysRun = true)
    public void setupReport(){
        report =  new ExtentReports();
        String pathToHtmlFile = System.getProperty("user.dir")+"/target/ExtentReports/report.html";
        htmlReport = new ExtentSparkReporter(pathToHtmlFile);
        report.attachReporter(htmlReport);
        report.setSystemInfo("Project Name", "Duobank Mortgage Application");
        report.setSystemInfo("SDET", "Team A");
        report.setSystemInfo("Environment", ConfigReader.getProperty("env"));
        report.setSystemInfo("Operating System", System.getProperty("os.name"));
        report.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        report.setSystemInfo("Homepage", ConfigReader.getProperty("url"));
    }



    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger = report.createTest(method.getName());
        logger.info("TEST STARTED: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult){

        if (testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("TEST PASSED: " + testResult.getName());
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            logger.fail("TEST FAILED: " + testResult.getName());
            logger.fail(testResult.getThrowable());
            String pathToScreenshotFile = SeleniumWebTools.getScreenshot("failed");
            logger.addScreenCaptureFromPath(pathToScreenshotFile);
        }else{
            logger.skip("TEST SKIPPED: " + testResult.getName());
        }

        Driver.quitDriver();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDownReport(){
        report.flush();
    }
}


