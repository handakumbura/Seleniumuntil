package io.github.handakumbura;

import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTest {

    @Test
    public static void testObjectInstantiationWhenTheElementIsATable(){
        ChromeDriver driver = Mockito.mock(ChromeDriver.class);
        WebElement element = Mockito.mock(WebElement.class);
        Mockito.when(element.getTagName()).thenReturn("table");
        By locator = Mockito.mock(By.class);

        Mockito.when(driver.findElement(locator)).thenReturn(element);
        new Table(driver,locator);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public static void testObjectInstantiationWhenTheElementIsNotATable(){
        ChromeDriver driver = Mockito.mock(ChromeDriver.class);
        WebElement element = Mockito.mock(WebElement.class);
        Mockito.when(element.getTagName()).thenReturn("input");
        By locator = Mockito.mock(By.class);

        Mockito.when(driver.findElement(locator)).thenReturn(element);
        new Table(driver,locator);
    }



}
