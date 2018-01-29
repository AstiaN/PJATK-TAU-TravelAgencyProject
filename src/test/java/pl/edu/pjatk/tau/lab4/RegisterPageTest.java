package pl.edu.pjatk.tau.lab4;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;



public class RegisterPageTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private HomePage homePage;
    private static WebDriver driver;

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
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        loginPage.open();
    }


    @Test
    public void registrationFailure() {
        loginPage.setEmail( "definitely#not@an,email" );
        loginPage.clickSubmitButton();
        assertThat(loginPage.isErrorMessageShown()).isTrue();
    }

    @Test
    public void registrationSuccess() {
        String email = UUID.randomUUID().toString();
        loginPage.setEmail( email + "@email.org" );
        RegisterPage registerPage = loginPage.goToRegisterPage();

        registerPage.takeScreenshot( "go_to_create_account_page" );

        registerPage
                .setFirstName( "Stanislaw" )
                .setLastName( "Posmyk" )
                .setPassword( "password" )
                .setFirstNameAddress( "Stanislaw" )
                .setLastNameAddress( "Posmyk" )
                .setAddress( "Brzegi" )
                .setCity( "Gdansk" )
                .selectState( "Georgia" )
                .setPostCode( "12345" )
                .setPhoneNumber( "123456789" );

        registerPage.clickSubmitButton();
        registerPage.takeScreenshot( "registred" );

        assertThat( loginPage.getUrl() ).isEqualTo( LoginPage.MY_ACCOUNT_URL );
    }


    @AfterClass
    public static void quitPage() throws Exception {
        driver.quit();
    }


}
