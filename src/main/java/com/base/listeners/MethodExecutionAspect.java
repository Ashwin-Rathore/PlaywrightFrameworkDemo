package com.base.listeners;

import com.microsoft.playwright.Page;
import com.base.factory.PlaywrightFactory;
import org.junit.Before;

import java.nio.file.Paths;
import java.util.Base64;

import static com.base.factory.PlaywrightFactory.getThreadLocalPage;

public class MethodExecutionAspect {

    PlaywrightFactory pf = new PlaywrightFactory();
    @Before()
    public void beforeTestMethodExecution() {
        // Replace this with your screenshot capturing logic
        takeScreenshot();
    }


    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = getThreadLocalPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }
}
