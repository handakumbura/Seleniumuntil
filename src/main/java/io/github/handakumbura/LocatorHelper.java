package io.github.handakumbura;

import org.openqa.selenium.By;

public class LocatorHelper {

    /***
     * Strips the value from the CSS Locator and returns it as a String.
     * @param selector the CSS Selector.
     * @return the css locator value.
     */
    public static String getValueOfCSSSelectorAsAString(By selector) {
        return selector.toString().split("By.cssSelector: ")[1];
    }
}
