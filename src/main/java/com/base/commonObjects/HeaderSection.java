package com.base.commonObjects;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.base.factory.PlaywrightFactory;
import com.base.utility.Log;
import com.pages.digital_Recalls.apt_DR.DashboardPage;
import com.pages.digital_Recalls.pim_pie.PieSearchPage;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.base.factory.PlaywrightFactory.properties;

public class HeaderSection {

    private final Page page;
    SoftAssert softAssert = new SoftAssert();

    public HeaderSection(Page page) {
        this.page = page;

    }

                  ////////////////////////////////////////////////////////////////////
                  //////////////////////////// Web Elements //////////////////////////
                  ////////////////////////////////////////////////////////////////////

    protected String doMenu = "//span[normalize-space()='Do']";
    protected String learnMenu = "//span[normalize-space()='Learn']";
    protected String shareMenu = "//span[normalize-space()='Share']";
    protected String administerMenu = "//span[normalize-space()='Administer']";
    protected String customizeMenu = "//span[normalize-space()='Customize']";
    private String monitorRecallExpTask = "//span[text()='Manage Recalls']";
    private String networkDropdown = "(//div[@role='combobox'])[1]//input";
    private String teamsDropdown = "(//div[@role='combobox'])[2]//input";
    private String goButton = "//button//span[text()='Go']";
    private String processDropdown = "(//div[@role='combobox'])[3]//input";
    private String userIcon = "//div[@data-testid='userIcon']//div";
    private String companyDropdown = "//button[@title='View Company Settings']";
    //private String companyInputBox = "//*[@data-name='mdiMenu']/ancestor::div/ancestor::div/ancestor::div//label[text()='Company']/following-sibling::div//input";
    private String companyInputBox = "//label[contains(text(),'Company')]/ancestor::div/div/input";
    private String closeButton = "//*[@data-name='mdiClose']";
    private String developEnvironment = "//li[text()='Develop']";
    private String validationEnvironment = "//li[text()='Validation']";
    private String productionEnvironment = "//li[text()='Production']";
    private String environmentDropdown = "//button[@data-testid='environment-switcher']//*[@data-name='mdiMenuDown']";
    private String environmentAttribute = "(//button[@data-testid='environment-switcher']//span)[1]";
    private String helpIcon = "//*[local-name()='svg' and @data-name='mdiHelpCircleOutline']";
    private String forumIcon = "//*[local-name()='svg' and @data-name='mdiForumOutline']";
    private String bellIcon = "//*[local-name()='svg' and @data-name='mdiBellOutline']";
    private String printIcon = "(//*[local-name()='svg' and @data-name='mdiPrinter'])[1]";
    private String dashboardIcon = "(//*[local-name()='svg' and @data-name='mdiPollBox'])[1]";
    private String listViewIcon = "(//*[local-name()='svg' and @data-name='mdiViewList'])[1]";
    private String footerVersion = "//a[@data-testid='flVersion']";
    private String footerLegalAndTrust = "//a[@data-testid='flLegalAndTrust']";
    private String footerUniversity = "//a[@data-testid='flUniversity']";
    private String footerSupport = "//a[@data-testid='flSupport']";
    private String footerContactUs = "//a[@data-testid='flContactUs']";
    private String footerCareers = "//a[@data-testid='flCareers']";
    private String footerSitemap = "//a[@data-testid='flSitemap']";


                     ////////////////////////////////////////////////////////////////////
                     ////////////////////////// Unit Methods ////////////////////////////
                     ////////////////////////////////////////////////////////////////////
    public boolean footerSitemapLinkVisible() {
        page.waitForSelector(footerSitemap);
        page.isEnabled(footerSitemap);
        if (page.isVisible(footerSitemap)) {
            return true;
        } else
            Log.ERROR("SiteMap Link is not Visible");
        return false;
    }

    public boolean footerCareersLinkVisible() {
        page.waitForSelector(footerCareers);
        page.isEnabled(footerCareers);
        if (page.isVisible(footerCareers)) {
            return true;
        } else
            Log.ERROR("Careers Link is not Visible");
        return false;
    }

    public boolean footerContactUsLinkVisible() {
        page.waitForSelector(footerContactUs);
        page.isEnabled(footerContactUs);
        if (page.isVisible(footerContactUs)) {
            return true;
        } else
            Log.ERROR("Contact Us Link is not Visible");
        return false;
    }

    public boolean footerSupportLinkVisible() {
        page.waitForSelector(footerSupport);
        page.isEnabled(footerSupport);
        if (page.isVisible(footerSupport)) {
            return true;
        } else
            Log.ERROR("Support Link is not Visible");
        return false;
    }

    public boolean footerUniversityLinkVisible() {
        page.waitForSelector(footerUniversity);
        page.isEnabled(footerUniversity);
        if (page.isVisible(footerUniversity)) {
            return true;
        } else
            Log.ERROR("University Link is not Visible");
        return false;
    }

    public boolean footerLegalAndTrustLinkVisible() {
        page.waitForSelector(footerLegalAndTrust);
        page.isEnabled(footerLegalAndTrust);
        if (page.isVisible(footerLegalAndTrust)) {
            return true;
        } else
            Log.ERROR("Legal And Trust Link is not Visible");
        return false;
    }

    public boolean footerVersionLinkVisible() {
        page.waitForSelector(footerVersion);
        page.isEnabled(footerVersion);
        if (page.isVisible(footerVersion)) {
            return true;
        } else
            Log.ERROR("Version Link is not Visible");
        return false;
    }

    public void clickUserIcon() {
        page.waitForLoadState(LoadState.LOAD);
        page.isEnabled(userIcon);
        page.click(userIcon);
        page.waitForTimeout(2000);
        page.waitForSelector(environmentAttribute);
    }

    public boolean printIconVisible() {
        page.waitForSelector(printIcon);
        page.isEnabled(printIcon);
        if (page.isVisible(printIcon)) {
            return true;
        } else
            Log.ERROR("Print icon is not Visible");
        return false;
    }

    public boolean helpIconVisible() {
        page.waitForSelector(helpIcon);
        page.isEnabled(helpIcon);
        if (page.isVisible(helpIcon)) {
            return true;
        } else
            Log.ERROR("help icon is not Visible");
        return false;
    }

    public boolean listViewIconVisible() {
        page.waitForSelector(listViewIcon);
        page.isEnabled(listViewIcon);
        if (page.isVisible(listViewIcon)) {
            return true;
        } else
            Log.ERROR("List View icon is not Visible");
        return false;
    }

    public boolean dashboardIconVisible() {
        page.waitForSelector(dashboardIcon);
        page.isEnabled(dashboardIcon);
        if (page.isVisible(dashboardIcon)) {
            return true;
        } else
            Log.ERROR("Dashboard Icon is not Visible");
        return false;
    }

    public boolean learnMenuVisible() {
        page.waitForSelector(learnMenu);
        page.isEnabled(learnMenu);
        if (page.isVisible(learnMenu)) {
            return true;
        } else
            Log.ERROR("LEARN MENU is not Visible");
        return false;
    }

    public boolean shareMenuVisible() {
        page.waitForSelector(shareMenu);
        page.isEnabled(shareMenu);
        if (page.isVisible(shareMenu)) {
            return true;
        } else
            Log.ERROR("SHARE MENU is not Visible");
        return false;
    }

    public boolean administerMenuVisible() {
        page.waitForSelector(administerMenu);
        page.isEnabled(administerMenu);
        if (page.isVisible(administerMenu)) {
            return true;
        } else
            Log.ERROR("ADMINISTER MENU is not Visible");
        return false;
    }

    public boolean customizeMenuVisible() {
        page.waitForSelector(customizeMenu);
        page.isEnabled(customizeMenu);
        if (page.isVisible(customizeMenu)) {

            return true;
        } else
            //   softAssert.assertFalse(false,"CUSTOMIZE MENU is not Visible");
            //Log.ERROR("CUSTOMIZE MENU is not Visible");
            return false;


    }

    public boolean forumIconVisible() {
        page.waitForSelector(forumIcon);
        page.isEnabled(forumIcon);
        if (page.isVisible(forumIcon)) {

            return true;
        } else
            assertThat(page.locator(forumIcon)).isHidden();
        Log.ERROR("Forum Icon is not Visible");
        return false;

    }

    public boolean bellIconVisible() {
        page.waitForSelector(bellIcon);
        page.isEnabled(bellIcon);
        if (page.isVisible(bellIcon)) {
            return true;
        } else
            assertThat(page.locator(bellIcon)).isHidden();
        Log.ERROR("Bell Icon is not Visible");
        return false;

    }

    public void selectEnvironment() {
        if (properties.getProperty("environment").contains("val") && !page.textContent("(//button[@data-testid='environment-switcher']//span)[1]").equals("Validation")) {
            page.waitForSelector(environmentDropdown);
            page.click(environmentDropdown);
            page.waitForSelector(validationEnvironment);
            page.click(validationEnvironment);
            page.waitForTimeout(3000);
            page.waitForSelector(userIcon);
            page.click(userIcon);
            page.waitForTimeout(3000);
        } else if (properties.getProperty("environment").contains("dev") && !page.textContent("(//button[@data-testid='environment-switcher']//span)[1]").equals("Develop")) {
            page.waitForSelector(environmentDropdown);
            page.click(environmentDropdown);
            page.waitForSelector(developEnvironment);
            page.click(developEnvironment);
            page.waitForTimeout(3000);
            page.waitForSelector(userIcon);
            page.click(userIcon);
            page.waitForTimeout(3000);
        } else if (!page.textContent("(//button[@data-testid='environment-switcher']//span)[1]").equals("Production")) {
            page.waitForSelector(environmentDropdown);
            page.click(environmentDropdown);
            page.waitForSelector(productionEnvironment);
            page.click(productionEnvironment);
            page.waitForTimeout(3000);
            page.waitForSelector(userIcon);
            page.click(userIcon);
            page.waitForTimeout(3000);
        }
    }

    public void selectCompanyName(String companyName) {
        if (!page.isVisible(companyDropdown)) {
            page.reload();
            page.waitForSelector(userIcon);
            page.click(userIcon);
            page.waitForSelector(companyDropdown);
        }
        page.click(companyDropdown);
        page.click(companyInputBox);
        if (!page.querySelector(companyInputBox).getAttribute("value").equals(companyName)) {
            Log.INFO("Selected Company -  " + page.querySelector(companyInputBox).getAttribute("value"));
            page.click(companyInputBox);
            page.waitForTimeout(1000);
            page.fill(companyInputBox, companyName);
            page.waitForTimeout(500);
            page.keyboard().press("ArrowDown");
            page.keyboard().press("Enter");
        } else {
            Log.INFO("Selected Company - " + page.querySelector(companyInputBox).getAttribute("value"));
            page.click(closeButton);
        }
    }

    public boolean selectNetwork(String Network) {
        page.waitForSelector(doMenu);
        page.isEnabled(networkDropdown);
        //if (networkDropdown.toLowerCase().contains(Network.toLowerCase())) {
        if (page.textContent(networkDropdown).toLowerCase().contains(Network.toLowerCase())) {
            Log.INFO(Network + " - Already Selected");
            return true;
        } else if (!networkDropdown.toLowerCase().contains(Network.toLowerCase())) {
            page.isEnabled(networkDropdown);
            page.click(networkDropdown);
            page.waitForTimeout(1500);
            page.fill(networkDropdown, Network);
            page.waitForTimeout(1500);
            page.keyboard().press("ArrowDown");
            page.keyboard().press("Enter");
            Log.INFO("Selected Network - " + Network);
            page.waitForTimeout(5000);
            return true;
        } else
            return false;
    }

    public boolean selectTeam(String Team) {
        page.waitForSelector(doMenu);
        page.isEnabled(teamsDropdown);
        if (page.textContent(teamsDropdown.toLowerCase()).contains(Team.toLowerCase())) {
            Log.INFO(Team + " - Already Selected");
            return true;
        } else if (page.textContent(teamsDropdown.toLowerCase()).contains(Team.toLowerCase())) {
            page.isEnabled(teamsDropdown);
            page.click(teamsDropdown);
            page.waitForTimeout(1500);
            page.fill(teamsDropdown, Team);
            page.waitForTimeout(1500);
            page.keyboard().press("ArrowDown");
            page.keyboard().press("Enter");
            Log.INFO("'" + Team + "'" + " - Teams Selected");
            return true;
        } else
            return false;
    }

    public boolean selectProcess(String Process) {

        page.waitForSelector(doMenu);
        page.isEnabled(processDropdown);
        if (page.textContent(processDropdown.toLowerCase()).contains(Process.toLowerCase())) {
            Log.INFO(Process + " - Already Selected");
            return true;
        } else if (!page.textContent(processDropdown).contains(Process)) {
            page.click(processDropdown);
            page.waitForTimeout(500);
            page.fill(processDropdown, Process);
            page.waitForTimeout(500);
            page.keyboard().press("ArrowDown");
            page.waitForTimeout(500);
            page.keyboard().press("Enter");
            Log.INFO("'" + Process + "'" + " - Process Selected");
            return true;
        } else
            return false;
    }

    public boolean clickGoButton() {
        page.waitForSelector(goButton);
        if (page.isVisible(goButton)) {
            page.click(goButton);
            page.waitForSelector(doMenu);
            return true;
        } else if (!page.isVisible(goButton)) {
            page.waitForSelector(goButton);
            page.click(goButton);
            page.waitForSelector(doMenu);
            return true;
        } else if (!page.isVisible(goButton))
            Log.ERROR("GO button is not enable");
        return false;
    }

    public boolean clickExperienceTask(String ExperienceTaskName) {
       // clickGoButton();
        if (page.isVisible("//span[text()='" + ExperienceTaskName + "']")) {
            page.click("//span[text()='" + ExperienceTaskName + "']");
            Log.INFO("Clicked on - " + ExperienceTaskName);
            return true;
        } else if (!page.isVisible("//span[text()='" + ExperienceTaskName + "']")) {
            reloadPage();
            page.waitForSelector("//span[text()='" + ExperienceTaskName + "']");
            page.click("//span[text()='" + ExperienceTaskName + "']");
            Log.INFO("Clicked on - " + ExperienceTaskName);
            return true;
        } else if (!page.isVisible("//span[text()='" + ExperienceTaskName + "']"))
            Log.ERROR("Experience Task " + ExperienceTaskName + " not Present on the Page");

        return false;
    }

    public void reloadPage() {
        page.reload();
        page.waitForTimeout(5000);
    }

    public static void captureScreenshot(String name) {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = null;
        try {
            capture = new Robot().createScreenCapture(screenRect);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        try {
            ImageIO.write(capture, "png", new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

                     //////////////////////////////////////////////////////////////////////////
                     ////////////////////////// Validation Methods ////////////////////////////
                     //////////////////////////////////////////////////////////////////////////
    /*
    This Method is used to Select the Company
     */
    public void changeEnvAndCompanyName(String companyName) {
        page.waitForSelector(goButton);
        page.waitForTimeout(5000);
        clickUserIcon();
        selectEnvironment();
        selectCompanyName(companyName);
    }

//    public void selectProcessNetwork(String Network) {
//        page.waitForSelector(doMenu);
//        page.click(networkDropdown);
//        page.waitForTimeout(1500);
//        page.fill(networkDropdown, Network);
//        page.waitForTimeout(1500);
//        page.keyboard().press("ArrowDown");
//        page.keyboard().press("Enter");
////        page.waitForSelector("//input[@value='APTQAOwner2023060808395496617 - Product Information Exchange']");
//        if (!Network.contains(Network)) {
//            page.waitForTimeout(2000);
//            //selectProcess(Process);
//            page.waitForTimeout(500);
//        }
//        if (page.isEnabled(goButton)) {
//            page.click(goButton);
//        } else {
//            page.waitForTimeout(2000);
//            page.click(goButton);
//        }
//        page.waitForSelector(doMenu);
//    }


    public boolean validatedFooterLinks() {
        footerCareersLinkVisible();
        softAssert.assertTrue(true, "CAREER - Link is not visible");
        footerSitemapLinkVisible();
        softAssert.assertTrue(true, "SITEMAP - is not visible");
        footerContactUsLinkVisible();
        softAssert.assertTrue(true, "CONTACT US - Link is not visible");
        footerLegalAndTrustLinkVisible();
        softAssert.assertTrue(true, "LEGAL & TRUST - Link is not visible");
        footerSupportLinkVisible();
        softAssert.assertTrue(true, "SUPPORT - Link is not visible");
        footerUniversityLinkVisible();
        softAssert.assertTrue(true, "TRACELINK UNIVERSITY - Link is not visible");
        footerVersionLinkVisible();
        softAssert.assertTrue(true, "VERSION - Link is not visible");
        softAssert.assertAll();
//        test.get().pass(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(PlaywrightFactory.takeScreenshot(), result.getMethod().getMethodName()).build());
//        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
        return true;
    }

    public boolean validatedHeaderIconAndMenuVisible() {
        helpIconVisible();
        softAssert.assertTrue(true, "Helper Icon is not visible");
        forumIconVisible();
        softAssert.assertTrue(true, "Forum Icon is not visible");
        bellIconVisible();
        softAssert.assertTrue(true, "Bell Icon is not visible");
        learnMenuVisible();
        softAssert.assertTrue(true, "LEARN Menu is not visible");
        shareMenuVisible();
        softAssert.assertTrue(true, "SHARE Menu is not visible");
        administerMenuVisible();
        softAssert.assertTrue(true, "ADMINISTER Menu is not visible");
        customizeMenuVisible();
        softAssert.assertTrue(true, "CUSTOMIZE Menu is not visible");
        printIconVisible();
        softAssert.assertTrue(true, "Print Icon is not visible");
//        dashboardIconVisible();
//        softAssert.assertTrue(true, "Dashboard Icon is not visible");
//        listViewIconVisible();
//        softAssert.assertTrue(true, "List View is not visible");
        softAssert.assertAll();
        return true;
    }

    public String dashboardCardTitlePresent(String cardName) {
        String cardTitle = "//div[@class='MuiCardHeader-content']/span[contains(text(),'" + cardName + "')]";
        page.waitForSelector(cardTitle);
        if (page.isVisible(cardTitle)) {
        } else
            softAssert.assertEquals(page.textContent(cardTitle), cardName);
        return page.innerText(cardTitle);
    }

    public ArrayList<String> dashboardCard(String cardName) {
        String dashboardCardName = dashboardCardTitlePresent(cardName);
        String cardTitle = "//div[@class='MuiCardHeader-content']/span[contains(text(),'" + cardName + "')]";
        String cardRowText = "(//span[contains(text(),'" + dashboardCardName + "')]//ancestor::div/following-sibling::div)[1]/div//li//span";
        String cardRowTextLinks = "(//span[contains(text(),'" + dashboardCardName + "')]//ancestor::div/following-sibling::div)[1]/div//li//a";
        page.waitForSelector(cardTitle);
        page.waitForTimeout(2000);
        ArrayList<String> cardRowTextList = new ArrayList<>();
        for (int i = 0; i < page.locator(cardRowText).count(); i++) {
            ElementHandle element = page.locator(cardRowText).nth(i).elementHandle();
            ElementHandle element1 = page.locator(cardRowTextLinks).nth(i).elementHandle();
            // Get the text of the element and add it to the cardLink ArrayList
            cardRowTextList.add(element.textContent());
            cardRowTextList.add(element1.textContent());
        }
        return cardRowTextList;
    }


    public void validateDashboard(String cardName){
        System.out.println(dashboardCard(cardName));

    }
    public void validatePageHeaderTitle(String pageHeaderTitle) {
        String headerTitle = "//div[@data-testid='ScreenHeader-']//p[contains(text(),'" + pageHeaderTitle + "')]";
        page.waitForSelector(headerTitle);
        if (page.isVisible(headerTitle)) {
        } else
            softAssert.assertEquals(page.textContent(headerTitle), pageHeaderTitle);
    }

    public void validatePageHeaderInLineMessage(String pageHeaderInLineMessage) {
        String headerInLineMessage = "//div[@data-testid='ScreenHeader-']//p[contains(text(),'" + pageHeaderInLineMessage + "')]";
        page.waitForSelector(headerInLineMessage);
        if (page.isVisible(headerInLineMessage)) {
        } else
            softAssert.assertEquals(page.textContent(headerInLineMessage), pageHeaderInLineMessage);
    }

    public void validatedNetworkTeamsProcessSelected(String network, String team, String process) {
        selectNetwork(network);
        selectTeam(team);
        selectProcess(process);
    }

                      //////////////////////////////////////////////////////////////////////////
                      ////////////////////////// Page References ///////////////////////////////
                      //////////////////////////////////////////////////////////////////////////


                      //////////////////* Digital Recalls Pages  *//////////////////
    public PieSearchPage getPieSearchPage() {
        return new PieSearchPage(page);
    }

    public DashboardPage getAPTDashBoard() {
        return new DashboardPage(page);
    }


    public DashboardPage returnDashoardPage(){
        return new DashboardPage(page);
    }

                       /////////////////* Agile Process Teams Pages  *//////////////////


                       //////////////////* MPC Pages  *//////////////////
}

