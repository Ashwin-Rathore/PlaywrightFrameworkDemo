
/**
 * Author : Ashwin Rathore
 * Date : 25-07-2024
 * Email - ashwin.rathore001@gmail.com
 */

package applications.amazon;

import base.BaseTest;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    /**
     *1) Open https://www.amazon.in/ in Chrome Browser.
     * 2) Click on Electronics from dropdown menu and type “IPhone 13”
     * 3) Get All the dropdown suggestions and validate all are related to searched product
     * 3) Then Type again “IPhone 13 128 GB” variant and Click “iPhone 13 128GB” variant from dropdown Result.
     * 4) From Results, click on the searched product and validate new tab is opened
     * 5) Navigate to next tab and click on Visit the Apple Store link appears below Apple iPhone 13 (128 GB) variant
     * 6) Click on Apple Watch dropdown and select Apple Watch SE (GPS + Cellular)
     * 7) Hover on watch image and verify Quick Look is displayed for the watch.
     * 8) Verify newly opened modal is related to Same product for which Quick look is performed.
     * */
    @Test
    public void searchProduct() throws InterruptedException {
        homePage.validateLogo();
        homePage.selectCatagoryAndSearchProduct("Electronics", "IPhone 13");
        homePage.getListOdSearchedProduct("IPhone 13");
        homePage.searchProduct("iPhone 13 128GB");
        homePage.selectProduct( 1);



    }
}
