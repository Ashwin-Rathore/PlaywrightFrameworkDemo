/**
 * Author : Ashwin Rathore
 * Date : 25-07-2024
 * Email - ashwin.rathore001@gmail.com
 */

package com.pages.applicationPages.amazon;

import com.microsoft.playwright.Page;

public class StorePage {

    public StorePage(Page page) {
        this.page = page;

    }

    private final Page page;
    private final String image = "(//div[@class='EditorialRow__half__UI2XB'])[2]//a";
    public final String quickLook = "((//div[@class='EditorialRow__half__UI2XB'])[2]//div[@class='QuickLook__content__X4jVd']//span[contains(text(),'Quick look')])[1]";
    public final String titleOfProduct = "((//div[@class='EditorialRow__half__UI2XB'])[2]//h3)[1]";
    public final String quickLookProductTitle = "//a[@class='ProductShowcase__title__SBCBw']";


    public void selectProductFromStorePage(Page page, String productName, String SelectProduct) {

        final String productNameElement = "(//nav[@class='Navigation__navBar__tdJ0T']//li/a/span[contains(text(),'" + productName + "')])[1]";
        page.locator(productNameElement).click();
        String product = "(//nav[@class='Navigation__navBar__tdJ0T']//li/a/span[contains(text(),'" + SelectProduct + "')])[1]";
        page.querySelector(product).click();
    }

    public void hoverToImageAndClickQuickLook(Page page) {
        String title = page.waitForSelector(titleOfProduct).textContent();
        page.waitForSelector(image).hover();
        page.waitForSelector(quickLook).click();
        String quickLookProdTitle = page.waitForSelector(quickLookProductTitle).textContent();
        String[] titleWords = title.split("\\s+");
        boolean found = false;
        for (String word : titleWords) {
            if (quickLookProdTitle.contains(word)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Yes, it's correct");
        } else {
            System.out.println("No, it's not correct");
        }

    }

}

