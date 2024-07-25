/**
 * Author : Ashwin Rathore
 * Date : 25-07-2024
 * Email - ashwin.rathore001@gmail.com
 */

package com.pages.applicationPages.amazon;

import com.base.utility.Log;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage {


    private final Page page;

    public final String homePageLogo = "//div[@id='nav-logo']";
    public final String allDropdown = "//select[@id='searchDropdownBox']";//"//div[@id='nav-search-dropdown-card']";
    public final String searchBox = "//input[@id='twotabsearchtextbox']";
    public final String searchButton = "//input[@type='submit']";
    public final String searchedResultTitle = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']";


    public final String image = "(//div[@class='EditorialRow__half__UI2XB'])[2]//a";
    public final String quickLook = "((//div[@class='EditorialRow__half__UI2XB'])[2]//div[@class='QuickLook__content__X4jVd']//span[contains(text(),'Quick look')])[1]";
    public final String titleOfProduct = "((//div[@class='EditorialRow__half__UI2XB'])[2]//h3)[1]";
    public final String quickLookProductTitle = "//a[@class='ProductShowcase__title__SBCBw']";
    public final String visitStoreLink = "//div[@class='a-section a-spacing-none']/a[contains(text(),'Visit the')]";
    public final String searchResultTit = "//span[@class='a-color-state a-text-bold']";


    public HomePage(Page page) {
        this.page = page;

    }

    public Page newTab;

    SoftAssert softAssert = new SoftAssert();


    public void validateLogo() {
        if (page.isVisible(homePageLogo)) {
            Log.INFO("Logo is Correct");
        } else
            Log.ERROR("Logo is incorrect");
    }

    public void selectCatagoryAndSearchProduct(String catagory, String product) {
        page.waitForSelector(allDropdown).selectOption(catagory);
        page.waitForSelector(searchBox).fill(product);
        page.waitForSelector(searchButton).click();
        String searchResultTitle = page.waitForSelector(searchResultTit).textContent();
        System.out.println("product> "+ product);
        System.out.println("searchResultTitle> "+ searchResultTitle);
        if(searchResultTitle.toLowerCase().contains(product.toLowerCase())){
            Assert.assertTrue(true);
            Log.INFO("Product " + product + " is searched Successfully");
        }else {
            Log.ERROR("Product " + product + " is not searched Successfully");
            Assert.assertFalse(true);
        }

    }

    public void getListOdSearchedProduct(String product) throws InterruptedException {
        page.waitForSelector(searchedResultTitle);
        List<ElementHandle> element = page.querySelectorAll(searchedResultTitle);
        for (ElementHandle listOfProducts : element) {
            listOfProducts.innerText();
        }
    }

    public void searchProduct(String product) {
        page.waitForSelector(searchBox).fill("");
        page.waitForSelector(searchBox).fill(product);
        page.waitForSelector(searchButton).click();
    }

    public void selectProduct(int indexOfProduct) throws InterruptedException {
        ProductPage productPage = new ProductPage(page);
        StorePage storePage = new StorePage(page);
        final String selectProductByIndex = "(//span[@class='a-size-medium a-color-base a-text-normal'])[" + indexOfProduct + "]";

        newTab = page.waitForPopup(() -> {
            page.waitForSelector(selectProductByIndex).click();

        });
        newTab.waitForLoadState();
        productPage.clickOnStoreLink(newTab);
        storePage.selectProductFromStorePage(newTab, "Apple Watch", "Apple Watch SE (GPS + Cellular)");
        storePage.hoverToImageAndClickQuickLook(newTab);
        System.out.println("I am on New Page---------");
        page.bringToFront();
    }
}

//        1) Open https://www.amazon.in/ in Chrome Browser.
//        2) Click on Electronics from dropdown menu and type “IPhone 13”
//        3) Get All the dropdown suggestions and validate all are related to searched product
//        3) Then Type again “IPhone 13 128 GB” variant and Click “iPhone 13 128GB” variant from dropdown Result.
//        4) From Results, click on the searched product and validate new tab is opened
//        5) Navigate to next tab and click on Visit the Apple Store link appears below Apple iPhone 13 (128 GB) variant
//        6) Click on Apple Watch dropdown and select Apple Watch SE (GPS + Cellular)
//        7) Hover on watch image and verify Quick Look is displayed for the watch.
//        8) Verify newly opened modal is related to Same product for which Quick look is performed.

