package applications.amazon;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;


/**
 * Create By : Ashwin Rathore on 24/07/24
 *
 * @author : arathore@tracelin.com
 * @date :  24/07/24
 */
public class HomePageTest extends BaseTest {

    @Test
    public void searchProduct() throws InterruptedException {
        homePage.validateLogo();
        homePage.selectCatagoryAndSearchProduct("Electronics", "IPhone 13");
        homePage.getListOdSearchedProduct("IPhone 13");
        homePage.searchProduct("iPhone 13 128GB");
        homePage.selectProduct( 1);



    }
}
