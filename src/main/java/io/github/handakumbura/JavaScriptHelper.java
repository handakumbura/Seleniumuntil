package io.github.handakumbura;

import com.googlecode.jslint4java.Issue;
import com.googlecode.jslint4java.JSLint;
import com.googlecode.jslint4java.JSLintBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JavaScriptHelper {
    private JavascriptExecutor executor;
    private final String PAUSE_WINDOW_SNIPPET = "window.setTimeout(arguments[arguments.length - 1], %s);";
    private final String INNER_HTML_SNIPPET = "document.querySelector('%s').innerHTML = '%s';";
    private final String EVENT_LISTENER_SNIPPET = "document.querySelector('%s').addEventListener('%s', function(e) {%s; });";
    private final String EVENT_HANDLER_TARGET_VALUE_SNIPPET = "window.radio; document.querySelectorAll('%s').forEach(elem => {elem.addEventListener('click', function(e) { window.radio = e.target.defaultValue})});";

    private final String NAME_OF_RADIO_BUTTON_VALUE_VARIABLE = "window.radio";
    private final int MAX_SCRIPT_WAIT_DURATION = 120;


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
        String snippet = String.format(EVENT_LISTENER_SNIPPET, cssSelector, eventListener, jsFunction);
        parseJavaScript(snippet);
        executor.executeScript(snippet);
    }

    /**
     * Appends a valid and well-formed HTML block as a child of the element selected by the CSS Selector.
     * Todo: use a WebElement instead of a CSS Selector.
     *
     * @param htmlBlock   htmlBlock block.
     * @param cssSelector css selector of the parent block.
     */
    public void appendAnHTMLBlockAsAChild(String htmlBlock, String cssSelector) throws IOException, SAXException {
        String snippet = String.format(INNER_HTML_SNIPPET, cssSelector, htmlBlock);
        parseHTMLBlock(htmlBlock);
        parseJavaScript(snippet);
        executor.executeScript(snippet);
    }

    /***
     * Pauses the browser window for a given duration.
     * @param duration duration in milliseconds.
     */
    public void pauseTheDOMForAGivenDuration(long duration) {
        String snippet = String.format(PAUSE_WINDOW_SNIPPET, duration);
        if (parseJavaScript(snippet) > 1) {
            throw new JavascriptException("Syntax error: \t" + snippet);
        }
        executor.executeAsyncScript(snippet);
    }

    /***
     *  Attaches an event listener to the members of a given radio group to store the user selection in a window object.
     * @param cssSelector By CSS Locator object of the radio group.
     */
    public void storeRadioButtonValueInContext(By.ByCssSelector cssSelector) {
        String snippet = String.format(EVENT_HANDLER_TARGET_VALUE_SNIPPET, LocatorHelper.getValueOfCSSSelectorAsAString(cssSelector));
        if (parseJavaScript(snippet) > 1) {
            throw new JavascriptException("Syntax error: \t" + snippet);
        }
        executor.executeScript(snippet);
    }

    /***
     * Returns the user selection from a radio button group by reading a window variable value.
     * @return the value of the selected redio button member.
     */
    public String getRadioButtonValueFromContext() {
        return (String) executor.executeScript("return " + NAME_OF_RADIO_BUTTON_VALUE_VARIABLE);
    }


    private int parseJavaScript(String snippet) {
        JSLintBuilder jsLintBuilder = new JSLintBuilder();
        JSLint lint = jsLintBuilder.fromDefault();

        List<Issue> issues = lint.lint("test.js", snippet).getIssues();

        for (Issue issue : issues) {
            System.out.println(issue.toString());
        }

        return lint.lint("test.js", snippet).getIssues().size();
    }

    private void parseHTMLBlock(String htmlBlock) throws IOException, SAXException {
        ByteArrayInputStream stream = null;
        DocumentBuilder dBuilder = null;
        try {
            stream = new ByteArrayInputStream(htmlBlock.getBytes("UTF-8"));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (UnsupportedEncodingException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc = dBuilder.parse(stream);
    }

}
