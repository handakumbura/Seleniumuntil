
/*
Copyright 2022 Dumidu Handakumbura

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.github.handakumbura;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButton {
    private final List<WebElement> elements;
    private final String VALUE = "value";

    /***
     * An abstraction to handle a HTML radio button group.
     * @param element A list of WebElements that represent a radio button group.
     */
    public RadioButton(List<WebElement> element) {
        this.elements = element;
    }

    /***
     * Selects the radio button option based on the index (starting at zero).
     * @param index The index of the option.
     * @return The current instance of the WebElement.
     */
    public RadioButton clickByIndex(int index) {
        elements.get(index).click();
        return this;
    }

    /***
     * Selects the radio button option based on the value attribute.
     * @param value the expected value attribute as a String.
     * @return The current instance of the WebElement.
     */
    public RadioButton clickByValue(String value) {
        for (int x = 0; x < elements.size(); x++) {
            if (elements.get(x).getAttribute(VALUE).equals(value)) {
                elements.get(x).click();
                break;
            } else if (!(elements.get(x).getAttribute(VALUE).equals(value)) && x == elements.size() - 1) {
                throw new NoSuchElementException("An element was not found for the given value attribute");
            }
        }
        return this;
    }

    /***
     * A sugar method that can be used to improve readability of code.
     * @return The current instance of the WebElement.
     */
    public RadioButton and() {
        return this;
    }

    /***
     * Returns the WebElements list passed in at instantiation of the object.
     * @return The current WebElements list.
     */
    public List<WebElement> getWrappedElement() {
        return this.elements;
    }

}
