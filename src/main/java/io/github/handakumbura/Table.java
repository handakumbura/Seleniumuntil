/*
Copyright 2022 Dumidu Handakumbura

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package io.github.handakumbura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Table {
    private final String TABLE_HEADER_TAG_XPATH = "//th";
    private final String TABLE_ROW_XPATH_TEMPLATE = "//tr[%s]/descendant::td";
    private final String TABLE_COLUMN_XPATH_TEMPLATE = "//tr[%s]/descendant::td[%s]";
    private final String BY_XPATH_POST_FIX = "By.xpath: ";
    private final String TABLE_ROW_XPATH_POSTFIX_TEMPLATE = "//tr[position()>1]";
    private final String TABLE_COLUMN_XPATH_POSTFIX_TEMPLATE = "[%s]/child::td";
    private By locator;
    private WebDriver driver;

    /***
     * An abstraction for the HTML table element.
     * @param locator The Table as a WebElement.
     */
    public Table(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    /**
     * utility method written to strip the xpath post fix.
     */
    private String stripXpath(String value) {
        return value.split(BY_XPATH_POST_FIX)[1];
    }

    /***
     * Returns the column headers as a list of Strings.
     * @return Returns the column headers as a list of Strings.
     */
    public List<String> getColumnHeaders() {
        return driver.findElements(By.xpath(stripXpath(locator.toString()) + TABLE_HEADER_TAG_XPATH)).stream().map(t -> {
            return t.getText();
        }).collect(Collectors.toList());
    }

    /***
     * Returns the values for a given row as a list of Strings.
     * @param row The row number (starting at 1).
     * @return Returns the values for a given row as a list of Strings.
     */
    public List<String> getValuesForAGivenRow(int row) {
        return driver.findElements(By.xpath(stripXpath(locator.toString()) + String.format(TABLE_ROW_XPATH_TEMPLATE, row + 1))).stream().map(t -> {
            return t.getText();
        }).collect(Collectors.toList());
    }

    /***
     * Returns the value at a given row and column combination.
     * @param row The row
     * @param column The column
     * @return Returns the value at a given row and column combination.
     */
    public String getValuesForAGivenRowAndColumn(int row, int column) {
        return driver.findElement(By.xpath(stripXpath(locator.toString()) + String.format(TABLE_COLUMN_XPATH_TEMPLATE, row + 1, column))).getText();
    }

    /***
     * Returns all values (excluding the header values) as a Map consisting of lists of Strings, where the key refers to the table's row.
     * @return Returns all values (excluding the header values) as a Map consisting of lists of Strings, where the key refers to the table's row.
     */
    public Map<Integer, List<String>> getAllValues() {
        String row = stripXpath(locator.toString()) + TABLE_ROW_XPATH_POSTFIX_TEMPLATE;
        String columnTemplate = row + TABLE_COLUMN_XPATH_POSTFIX_TEMPLATE;

        List<WebElement> rows = driver.findElements(By.xpath(row));
        Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();

        for (int x = 1; x <= rows.size(); x++) {
            List<String> columns = driver.findElements(By.xpath(String.format(columnTemplate, x))).stream().map(t -> {
                return t.getText();
            }).collect(Collectors.toList());
            result.put(x, columns);
        }
        return result;
    }

}
