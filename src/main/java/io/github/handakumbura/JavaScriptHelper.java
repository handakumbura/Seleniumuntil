package io.github.handakumbura;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptHelper {
    private JavascriptExecutor executor;
    private final String PAUSE_WINDOW_SNIPPET = "window.setTimeout(arguments[arguments.length - 1], %s);";
    private final int MAX_SCRIPT_WAIT_DURATION = 120;

    /***
     * Provides a few common javascript snippets as java functions.
     * @param driver driver.
     */
    public JavaScriptHelper(WebDriver driver) {
        this.executor = (JavascriptExecutor) driver;
        driver.manage().timeouts().setScriptTimeout(MAX_SCRIPT_WAIT_DURATION, TimeUnit.SECONDS);
    }

    public void executeSnippetAsAEventCallBack(EventListeners listeners) {
    }

    public void appendAnElement(By locatorOfElement, String changeTo) {

    }

    public void clickUsingJavaScript(By locatorOfElement) {

    }

    /***
     * Pauses the browser window for a given duration.
     * @param duration duration in milliseconds.
     */
    public void pauseTheDOMForAGivenDuration(long duration) {
        executor.executeAsyncScript(String.format(PAUSE_WINDOW_SNIPPET,duration));
    }

}
