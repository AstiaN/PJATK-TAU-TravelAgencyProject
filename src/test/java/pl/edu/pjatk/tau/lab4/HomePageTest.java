package pl.edu.pjatk.tau.lab4;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import pl.edu.pjatk.tau.lab4.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest {

    private static WebDriver driver;
    private HomePage homePage;

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
        homePage = new HomePage(driver);
        homePage.open();
    }


    @Test
    public void sliderDisplayedTest() {
        WebElement slider = homePage.getSlider();

        assertThat( slider.isDisplayed() ).isTrue();
    }

    @Test
    public void linkToCartDisplayedTest() {
        WebElement cart = homePage.getCartLink();

        assertThat( cart.isDisplayed() ).isTrue();
    }

    @Test
    public void callUsNowPhoneTest() {
        assertTrue(driver.getPageSource().contains("0123-456-789"));
    }

    @Test
    public void bestSellersSevenItemsTest() {
        homePage.clickBestSellersLink();

        int count = homePage.getBestSellersCount();

        assertThat( count ).isEqualTo( 7 );
    }

    @Test
    public void dressIsOnBestSellersListTest() {
        homePage.clickBestSellersLink();
        boolean isDressOnBestSellersList = homePage.isDressOnBestSellersList();

        assertThat( isDressOnBestSellersList ).isTrue();
    }

    @Test
    public void bestSellersAreDisplayedAfterClickTest() {
        homePage.clickBestSellersLink();

        assertThat( homePage.areBestSellersVisible() ).isTrue();
    }

    @Ignore("To Do")
    @Test
    public void dressesActionTest() {
        homePage.open();
        homePage.hoverDressesLink();

        assertTrue(homePage.getCasualDressesLink().isDisplayed());
        assertTrue(homePage.getEveningDressesLink().isDisplayed());
        assertTrue(homePage.getSummerDressesLink().isDisplayed());
    }

    @Test
    public void goToLoginPageTest() {
        homePage.clickLoginLink();

        String url = homePage.getUrl();
        assertThat( url ).isEqualTo( HomePage.LOGIN_URL );
    }


    @AfterClass
    public static void quitDriver() throws Exception {
        driver.quit();
    }

}
