package base;

import com.microsoft.playwright.Page;
import com.base.factory.PlaywrightFactory;
import com.pages.applicationPages.amazon.HomePage;

import com.pages.applicationPages.amazon.ProductPage;
import com.pages.applicationPages.amazon.StorePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory playwrightFactory;
    Page page;
    SoftAssert softAssert = new SoftAssert();
    protected Properties properties;
    public HomePage homePage;
    public ProductPage productPage;
    public StorePage storepage;



    @BeforeTest
    public void initializeBrowser() {
        playwrightFactory = new PlaywrightFactory();
        properties = playwrightFactory.init_properties();
        page = playwrightFactory.initBrowser(properties);
        homePage = new HomePage(page);

    }


      @AfterTest
    public void tearDown() {
        softAssert.assertAll();
        page.close();
        page.context().browser().close();

    }

}