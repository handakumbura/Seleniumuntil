package io.github.handakumbura;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonTest {

    @Test
    public static void testObjectInstantiationWhenTheElementIsAButton(){
        WebElement buttonElement = Mockito.mock(WebElement.class);
        Mockito.when(buttonElement.getTagName()).thenReturn("button");
        Button button = new Button(buttonElement);
        
        Assert.assertEquals(button.getWrappedElement().getTagName(),"button");
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public static void testObjectInstantiationWhenTheElementIsNotAButton(){
        WebElement buttonElement = Mockito.mock(WebElement.class);
        Mockito.when(buttonElement.getTagName()).thenReturn("input");
        new Button(buttonElement);
    }



}
