package io.github.handakumbura;

import com.googlecode.jslint4java.JSLint;
import com.googlecode.jslint4java.JSLintBuilder;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

public class JavaScriptHelperTest {

    @Test
    public static void testObjectInstantiation() throws IllegalAccessException {
        new JavaScriptHelper(mockAChromeDriverObject());
    }

    @Test
    public static void testPauseTheDOMForAGivenDurationJavaScriptSnippet() throws IllegalAccessException {
        Field field = JavaScriptHelper.class.getDeclaredFields()[1];
        field.setAccessible(true);
        String snippet = (String) field.get((Object) new JavaScriptHelper(mockAChromeDriverObject()));

        //parameterizing.
        snippet = String.format(snippet, 5000);
        Assert.assertEquals(getNumberOfLintIssuesInJavaScriptSnippet(snippet),1, "An unexpected syntax error was found in the valid javascript snippet for \t"+field.getName()); ;
    }

    @Test
    public static void TestAppendAnHTMLBlockAsAChildJavaScriptSnippetWhen() throws IllegalAccessException {
        Field field = JavaScriptHelper.class.getDeclaredFields()[2];
        field.setAccessible(true);
        String snippet = (String) field.get((Object) new JavaScriptHelper(mockAChromeDriverObject()));

        //parameterizing.
        snippet = String.format(snippet, 5000);
        Assert.assertEquals(getNumberOfLintIssuesInJavaScriptSnippet(snippet),1, "An unexpected syntax error was found in the valid javascript snippet for \t"+field.getName()); ;
    }

    private static ChromeDriver mockAChromeDriverObject() {
        ChromeDriver driver = Mockito.mock(ChromeDriver.class);
        WebDriver.Options options = Mockito.mock(WebDriver.Options.class);
        WebDriver.Timeouts timeouts = Mockito.mock(WebDriver.Timeouts.class);

        Mockito.when(driver.manage()).thenReturn(options);
        Mockito.when(driver.manage().timeouts()).thenReturn(timeouts);

        return driver;
    }

    private static int getNumberOfLintIssuesInJavaScriptSnippet(String snippet) {
        JSLintBuilder jsLintBuilder = new JSLintBuilder();
        JSLint lint = jsLintBuilder.fromDefault();

        return lint.lint("test.js", snippet).getIssues().size();
    }

}
