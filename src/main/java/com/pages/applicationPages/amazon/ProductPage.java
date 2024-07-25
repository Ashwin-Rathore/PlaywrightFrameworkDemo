/**
 * Author : Ashwin Rathore
 * Date : 25-07-2024
 * Email - ashwin.rathore001@gmail.com
 */
package com.pages.applicationPages.amazon;

import com.microsoft.playwright.Page;

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