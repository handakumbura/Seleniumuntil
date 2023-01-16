package io.github.handakumbura;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptHelper {
    private JavascriptExecutor executor;
    private final String PAUSE_WINDOW_SNIPPET = "window.setTimeout(arguments[arguments.length - 1], %s);";
    private final String INNER_HTML_SNIPPET = "document.querySelector('%s').innerHTML='%s'";
    private final String EVENT_LISTENER_SNIPPET = "document.querySelector('%s').addEventListener('%s',%s)";

    private final String EVENT_HANDLER_TARGET_VALUE_SNIPPET = "window.radio; document.querySelectorAll('%s').forEach(elem => {elem.addEventListener('click',function(e){ window.radio = e.target.defaultValue})});";
    private final int MAX_SCRIPT_WAIT_DURATION = 120;

    private final String NAME_OF_RADIO_BUTTON_VALUE_VARIABLE = "window.radio";

    /***
     * Provides a few common javascript snippets as java functions.
     * @param driver driver.
     */
    public JavaScriptHelper(WebDriver driver) {
        this.executor = (JavascriptExecutor) driver;
        driver.manage().timeouts().setScriptTimeout(MAX_SCRIPT_WAIT_DURATION, TimeUnit.SECONDS);
    }

    /***
     * takes a given JavaScript function and adds it to the given web element.
     * Todo: use a WebElement instead of a CSS Selector.
     * @param cssSelector css selector of the web element.
     * @param eventListener The HTML DOM event listener. Select the event from package Enum EventListener.
     * @param jsFunction the function as a string.
     */
    public void attachASnippetAsAEventCallBack(String cssSelector, EventListener eventListener, String jsFunction) {
        executor.executeScript(String.format(EVENT_LISTENER_SNIPPET, cssSelector, eventListener, jsFunction));
    }

    /**
     * Appends a valid and well-formed HTML block as a child of the element selected by the CSS Selector.
     * Todo: use a WebElement instead of a CSS Selector.
     *
     * @param html        html block.
     * @param cssSelector css selector of the parent block.
     */
    public void appendAnHTMLBlockAsAChild(String html, String cssSelector) {
        executor.executeScript(String.format(INNER_HTML_SNIPPET, cssSelector, html));
    }

    /***
     * Pauses the browser window for a given duration.
     * @param duration duration in milliseconds.
     */
    public void pauseTheDOMForAGivenDuration(long duration) {
        executor.executeAsyncScript(String.format(PAUSE_WINDOW_SNIPPET, duration));
    }

    /***
     *  Attaches an event listener to the members of a given radio group to store the user selection in a window object.
     * @param cssSelector By CSS Locator object of the radio group.
     */
    public void storeRadioButtonValueInContext(By.ByCssSelector cssSelector) {
        executor.executeScript(String.format(EVENT_HANDLER_TARGET_VALUE_SNIPPET,LocatorHelper.getValueOfCSSSelectorAsAString(cssSelector)));
    }

    /***
     * Returns the user selection from a radio button group by reading a window variable value.
     * @return the value of the selected redio button member.
     */
    public String getRadioButtonValueFromContext(){
        return (String) executor.executeScript("return "+ NAME_OF_RADIO_BUTTON_VALUE_VARIABLE);
    }



}
