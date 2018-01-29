package pl.edu.pjatk.tau.lab5.java;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pl.edu.pjatk.tau.lab4.RegisterPage;
import pl.edu.pjatk.tau.lab4.HomePage;
import pl.edu.pjatk.tau.lab4.LoginPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class registerSteps {
    public static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setCapability( PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs.exe");
        driver = new PhantomJSDriver(capabilities);

        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.MICROSECONDS);

        driver.manage()
                .window()
                .setSize( new Dimension( 1920, 1050 ) );

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

    }


    @Given("^setting email and click to register page$")
    public void oppeningAndSettingEmailAddressTest() throws Throwable {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        String email = UUID.randomUUID().toString();
        loginPage.setEmail( email + "@email.org" );
        RegisterPage registerPage = loginPage.goToRegisterPage();

    }
    @When("^fill up \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\"$")
    public void fillUpDetailsTest(String password, String name, String surname, String city, String street) throws Throwable {
        registerPage
                .setFirstName(name)
                .setLastName(surname)
                .setPassword(password)
                .setFirstNameAddress( "Stanislaw" )
                .setLastNameAddress( "Posmyk" )
                .setAddress(street)
                .setCity(city)
                .selectState( "Georgia" )
                .setPostCode( "12345" )
                .setPhoneNumber( "123456789" );


    }

    @Then("^account should be registered$")
    public void account_should_be_registered() throws Throwable {
        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).isDisplayed()); //sign out button
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click();
    }

    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}
