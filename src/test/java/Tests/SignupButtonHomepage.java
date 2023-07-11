package Tests;

import Pages.SignUpPage;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupButtonHomepage {

    WebDriver driver= new ChromeDriver();
    @Test
    public void verifySignupButton() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");

        //Verify “Don't have an account? Sign up” button
        WebElement signupText= driver.findElement(By.xpath("//small[@class='mr-25']"));
        System.out.println(signupText.getText());
        WebElement signupButton= driver.findElement(By.xpath("//a[@href='register.php']"));
        System.out.println(signupButton.getText());

        //Click on Signup button
        driver.findElement(By.xpath("//div[@class='text-center']//a[@href='register.php']")).click();

        //Verify user is redirected to the signup page
        Assert.assertEquals(driver.getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");

        driver.quit();


    }
}
