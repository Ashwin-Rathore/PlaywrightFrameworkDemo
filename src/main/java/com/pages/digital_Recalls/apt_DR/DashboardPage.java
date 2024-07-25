package com.pages.digital_Recalls.apt_DR;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.base.factory.PlaywrightFactory;
import com.base.utility.Log;
import org.testng.asserts.SoftAssert;

public class DashboardPage {

    private final Page page;

    public final String all_Recalls_by_Response_Status_Card = "//div[@class='MuiCardHeader-content']/span[contains(text(),'All Recalls by Response Status')]";
    public final String open_Recalls_by_Days_Since_Notification = ".MuiTypography-root:contains('Open Recalls by Days Since Notification')";
    public final String open_Recalls_by_Due_Date = ".MuiTypography-root:contains('Open Recalls by Due Date')";

    public final String not_Acknowledge_Link = "//span[contains(text(),'Not Acknowledged')]/parent::div/following-sibling::div";

    public final String monitor_Recalls_Page = "//p[contains(text(),'Monitor Recalls')]";
    public final String title = "//div[@data-testid='ScreenHeader-']//p[contains(text(),'Monitor Change Requests')]";


    public DashboardPage(Page page) {
        this.page = page;

    }

    SoftAssert softAssert = new SoftAssert();

    public void validateDashboardTitle(String dashboardName) {
        String dashboard = "//div[@class='MuiCardHeader-content']/span[contains(text(),'" + dashboardName + "')]";
        page.waitForSelector(dashboard);
        if (page.isVisible(dashboard)) {
        } else
            softAssert.assertFalse(true, "Dashboard is not present - " + dashboardName);
    }

    public String getDashboardPageTitle() {
        page.waitForSelector(monitor_Recalls_Page);
        page.locator(monitor_Recalls_Page).highlight();
        pf.takeScreenshot();
        String title = page.title();
        Log.INFO("Page Title - " + title);
        return title;
    }

    public String getDashboardPageURL() {
        String url = page.url();
        System.out.println("Page URL - " + url);
        return url;
    }

    public void validateChartCards() {
        System.out.println("Chart Card - " + page.textContent(all_Recalls_by_Response_Status_Card));
        page.getAttribute(all_Recalls_by_Response_Status_Card, "All Recalls by Response Status");

    }

    PlaywrightFactory pf = new PlaywrightFactory();

    public ListViewPage clickNotAcknowledgeLink() {
        page.waitForSelector(not_Acknowledge_Link);
        page.click(not_Acknowledge_Link);
        page.locator(not_Acknowledge_Link).highlight();
        pf.takeScreenshot();
        System.out.println("Link Clicked Successfully");
        page.waitForTimeout(5000);
       // page.locator().scro
        return new ListViewPage(page);

    }

}
