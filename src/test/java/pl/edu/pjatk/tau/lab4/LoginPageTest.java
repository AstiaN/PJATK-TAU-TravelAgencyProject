package pl.edu.pjatk.tau.lab4;

import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest {
    private static WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public static void driverSetup(){

        DesiredCapabilities capabilities;
        capabilities = new DesiredCapabilities();
        capabilities.setCapability( PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs.exe");
        driver = new PhantomJSDriver(capabilities);

        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.MICROSECONDS);

        driver.manage()
                .window()
                .setSize( new Dimension( 1920, 1050 ) );
    }

    @Before
    public void homePageSetup() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    public void loginTest() {
        loginPage.setLoginEmail( "this@is.email" );
        loginPage.setLoginPassword( "password" );
        loginPage.clickLoginSubmitButton();

        assertThat( loginPage.getUrl() ).isEqualTo( LoginPage.MY_ACCOUNT_URL );

        loginPage.clickSignOutButton();

        assertThat( loginPage.getUrl() ).isEqualTo( LoginPage.LOGIN_URL );
    }

    @Test
    public void loginWithIncorrectCredentialsTest() {
        loginPage.setLoginEmail( "this@is.email" );
        loginPage.setLoginPassword( "haslo" );
        loginPage.clickLoginSubmitButton();

        assertThat( loginPage.isAuthenticationErrorDisplayed() ).isTrue();
    }


    @AfterClass
    public static void quitPage() throws Exception {
        driver.quit();
    }
}
