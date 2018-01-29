package pl.edu.pjatk.tau.lab5.java;

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
        import java.util.concurrent.TimeUnit;

public class loginFailedSteps {
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

        loginPage.open();

    }

    @Given("^there is url to page$")
    public void there_is_url_to_page() throws Throwable {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }


    @When("^i use name \"([^\"]*)\" and  password \"([^\"]*)\" in form$")
    public void i_use_name_and_password_in_form(String name, String password) throws Throwable {
        loginPage.setLoginEmail(name);
        loginPage.setLoginPassword(password);
        loginPage.clickLoginSubmitButton();
    }

    @Then("^we click login button and we shouldn't login to page$")
    public void we_click_login_button_and_we_shouldn_t_login_to_page() throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]")).isDisplayed());
    }
    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}

