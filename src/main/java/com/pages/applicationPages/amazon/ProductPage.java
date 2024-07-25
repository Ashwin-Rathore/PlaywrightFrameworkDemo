package com.pages.applicationPages.amazon;

import com.microsoft.playwright.Page;

/**
 * Create By : Ashwin Rathore on 24/07/24
 *
 * @author : arathore@tracelin.com
 * @date :  24/07/24
 */
public class ProductPage {

    public ProductPage(Page page) {
        this.page = page;

    }

    // Page newTab;
    private final Page page;
    public final String visitStoreLink = "//div[@class='a-section a-spacing-none']/a[contains(text(),'Visit the')]";


    public StorePage clickOnStoreLink(Page page) {
        page.waitForSelector(visitStoreLink).click();
        return new StorePage(page);
    }


}