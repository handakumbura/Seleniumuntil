/*
Copyright 2022 Dumidu Handakumbura

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package io.github.handakumbura;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class CheckBox implements WrapsElement {
    private final WebElement element;

    /***
     * An abstraction to handle a HTML checkbox element.
     * @param element WebElement instance for the checkbox.
     */
    public CheckBox(WebElement element) {
        this.element = element;
    }


    /***
     * Toggles the checkbox.
     * @return The current instance of the WebElement.
     */
    public CheckBox toggle() {
        element.click();
        return this;
    }

    /***
     * Un-Toggles the checkbox.
     * @return The current instance of the WebElement.
     */
    public CheckBox unToggle() {
        if (element.isSelected()) {
            element.click();
        }

        return this;
    }

    /***
     * A sugar method that can be used to improve readability of code.
     * @return The current instance of the WebElement.
     */
    public CheckBox and() {
        return this;
    }

    /***
     * Checks if the element is displayed.
     * @return The current instance of the WebElement.
     */
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    /***
     * Returns the WebElement passed in at instantiation of the object.
     * @return The current WebElement.
     * @return The current WebElement object.
     */
    @Override
    public WebElement getWrappedElement() {
        return this.element;
    }
}
