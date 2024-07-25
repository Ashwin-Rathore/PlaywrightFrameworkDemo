/**
 * Author : Ashwin Rathore
 * Date : 25-07-2024
 * Email - ashwin.rathore001@gmail.com
 */

package com.base.factory;

import com.microsoft.playwright.*;
import com.base.utility.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static com.base.utility.Log.*;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    public static Properties properties;

    private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> threadLocalBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<Playwright>();


    public static Playwright getThreadLocalPlaywright() {
        return threadLocalPlaywright.get();
    }

    public static Browser getThreadLocalBrowser() {
        return threadLocalBrowser.get();
    }

    public static BrowserContext getThreadLocalBrowserContext() {
        return threadLocalBrowserContext.get();
    }

    public static Page getThreadLocalPage() {
        return threadLocalPage.get();
    }

    public Page initBrowser(Properties properties) {

        String browserName = properties.getProperty("browser").toLowerCase().trim();
        System.out.println("browserName :" + browserName);
        Log.INFO("Launching Browser - "+properties.getProperty("browser").toLowerCase().trim());
        Log.INFO("Headless - "+properties.getProperty("headless").toLowerCase().trim());
        threadLocalPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase(Locale.ROOT)) {
            case "chromium":
                //  browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                threadLocalBrowser.set(getThreadLocalPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(properties.getProperty("headless").trim()))));
                break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                threadLocalBrowser.set(getThreadLocalPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(properties.getProperty("headless").trim()))));
                break;
            case "safari":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                threadLocalBrowser.set(getThreadLocalPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(properties.getProperty("headless").trim()))));
                break;
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                threadLocalBrowser.set(getThreadLocalPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(Boolean.parseBoolean(properties.getProperty("headless").trim()))));
                break;
            default:
                System.out.println(("Browser " + browserName + " not found. Please check the browser name. "));
                break;
        }

        threadLocalBrowserContext.set(getThreadLocalBrowser().newContext());
        threadLocalPage.set(getThreadLocalBrowserContext().newPage());
        getThreadLocalPage().navigate(properties.getProperty("url").trim());

        login(properties.getProperty("email"), properties.getProperty("password"));


        return getThreadLocalPage();

    }


    /*
    This method is used to initialize the properties from config file
     */
    public Properties init_properties() {

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/java/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;

    }

    public void login(String userName, String pass) {
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        getThreadLocalPage().navigate(properties.getProperty("url"));
//            getThreadLocalPage().fill("input#username",properties.getProperty("email"));
//            getThreadLocalPage().click("input#login-next-btn");
//            getThreadLocalPage().fill("input#password",properties.getProperty("password"));
//            getThreadLocalPage().click("input#login-submit-btn");
        //page.locator(".header").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path)));


    }


    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = getThreadLocalPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }

    public static void switchToNewTab() {
        List<Page> pages = getThreadLocalBrowserContext().pages();
        System.out.println("pages.size() >> " + pages.size());
        if (pages.size() > 1) {
            Page newPage = pages.get(pages.size() - 1);
            threadLocalPage.set(newPage);
        } else {
            System.out.println("No new tab found.");
        }
    }

    public static void switchToOriginalTab() {
        // Switch back to the original tab (first page)
        Page originalPage = getThreadLocalBrowserContext().pages().get(0);
        threadLocalPage.set(originalPage);
    }


    public boolean getConfigValue(String key) throws IOException {
        // Check if the key exists
        if (properties.containsKey(key)) {
            return true;
        } else {
            // Key not found
            System.out.println("Key '" + key + "' does not exist in config.properties");
            return false;
        }
    }

}



