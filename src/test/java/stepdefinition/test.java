package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test {
    public WebDriver driver;

    @Given("browser is open")
    public void openBrowser()
    {
        String SystemProp = System.getProperty( "user.dir" );
        System.setProperty( "webdriver.chrome.driver", SystemProp + "/src/test/resources/chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 40, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout( 40, TimeUnit.SECONDS );
        driver.get( "https://phptravels.com" );
        driver.manage().window().maximize();

    }

    @When("User enter login password")
    public void enterLogPassword()
    {
        driver.findElement(By.xpath("/html/body/header/div/nav/a[4]")).click();
        Set<String> childs = driver.getWindowHandles();
        for (String child : childs)
        {
            driver.switchTo().window(child);
        }

        driver.findElement(By.id("inputEmail")).sendKeys("test@test.com");
        driver.findElement(By.id("inputPassword")).sendKeys("password");
        driver.findElement(By.id("login")).click();
    }

    @Then("user is navigate in the home page")
    public void homePage()
    {
        String message = driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/div[1]/div/form/div/div[1]/div[2]")).getText();
        Assert.assertEquals("Login Details Incorrect. Please try again.",message);
    }

    @After
    public void closeNavigator(){
        driver.quit();
    }
}
