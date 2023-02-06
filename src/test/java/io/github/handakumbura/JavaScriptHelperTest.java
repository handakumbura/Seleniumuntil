package io.github.handakumbura;

import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class JavaScriptHelperTest {

    @Test
    public static void testObjectInstantiation() throws IllegalAccessException {
        new JavaScriptHelper(mockAChromeDriverObject());
    }

    @Test
    public static void testPauseTheDOMForAGivenDuration() {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.pauseTheDOMForAGivenDuration(5000);
    }

    @Test
    public static void testAppendAnHTMLBlockAsAChildWhenTheCSSLocatorAndTheHTMLAreValid() throws IOException, SAXException {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.appendAnHTMLBlockAsAChild("<div>test</div>", "#test");
    }

    @Test(enabled = false)
    public static void testAppendAnHTMLBlockAsAChildWhenTheCSSLocatorIsInvalidAndTheHTMLisValid() throws IOException, SAXException {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.appendAnHTMLBlockAsAChild("<div>test</div>", "//*[@id='test' and @class='test']");
    }

    @Test(expectedExceptions = SAXException.class)
    public static void testAppendAnHTMLBlockAsAChildWhenTheCSSLocatorIsValidAndTheHTMLisInValid() throws IOException, SAXException {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.appendAnHTMLBlockAsAChild("<div>test<div>", "#test");
    }

    @Test(expectedExceptions = SAXException.class)
    public static void testAppendAnHTMLBlockAsAChildWhenTheCSSLocatorAndTheHTMLAreInValid() throws IOException, SAXException {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.appendAnHTMLBlockAsAChild("<div>test<div>", "//*[@id='test' and @class='test']");
    }

    @Test
    public static void testAttachASnippetAsAEventCallBackWhenBothTheCSSLocatorAndTheCallbackAreValid() {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.attachASnippetAsAEventCallBack("#test", EventListener.CLICK, "function(e) { console.log(e) }");
    }

    @Test(enabled = false)
    public static void testAttachASnippetAsAEventCallBackWhenTheCSSLocatorIsValidAndTheCallbackIsInValid() {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.attachASnippetAsAEventCallBack("#test", EventListener.CLICK, "function(e) { console.log e) }");
    }

    @Test(enabled = false)
    public static void testAttachASnippetAsAEventCallBackWhenTheCSSLocatorAndTheCallbackareInValid() {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.attachASnippetAsAEventCallBack("//*[@id='test' and @class='test']", EventListener.CLICK, "function(e) { console.log e) }");
    }

    @Test
    public static void testGetRadioButtonValueFromContext() {
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(mockAChromeDriverObject());
        javaScriptHelper.getRadioButtonValueFromContext();
    }


    private static ChromeDriver mockAChromeDriverObject() {
        ChromeDriver driver = Mockito.mock(ChromeDriver.class);
        WebDriver.Options options = Mockito.mock(WebDriver.Options.class);
        WebDriver.Timeouts timeouts = Mockito.mock(WebDriver.Timeouts.class);

        Mockito.when(driver.manage()).thenReturn(options);
        Mockito.when(driver.manage().timeouts()).thenReturn(timeouts);

        return driver;
    }
}
