[![Maven Central](https://img.shields.io/maven-central/v/io.github.handakumbura/Seleniumutil.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.handakumbura%22%20AND%20a:%22Seleniumutil%22)  [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![CI](https://github.com/handakumbura/Seleniumuntil/actions/workflows/maven.yml/badge.svg)](https://github.com/handakumbura/Seleniumuntil/actions/workflows/maven.yml)

# Why should I use Selenium Util?
Selenium Util library provides element level abstractions so that you don’t have to. The library can help improve readability and reduce redundancy of your page layer code. 

# How can I use Selenium Util?
1. The library is compatible with Selenium Webdriver 3.141.o and up. Just Include the library as a dependency[1] (e.g. maven),

`<dependency>
  <groupId>io.github.handakumbura</groupId>
  <artifactId>Seleniumutil</artifactId>
  <version>0.5.0</version>
</dependency>`

2. Then, instantiate an object of the element wrapper passing in the required parameter. Then use the built in methods to manipulate the element.

`RadioButton radioButton = new RadioButton(driver.findElements(RADIO_BUTTON_GROUP_XPATH));
radioButton.clickByValue("Dinner");`

`Table table = new Table(driver,LOCATOR);
 table.getColumnHeaders();
 table.getValuesForAGivenRow(1);
 table.getValuesForAGivenRowAndColumn(1,2);
 table.getAllValues();`

# How can I contribute to the project?
The idea is to create abstractions for all common HTML5 elements as well as provide other useful utilities such as ExpectedConditions that are not available OOTB and custome locators. Please follow the link[2] below if you would like to collaborate with me on this project.

[1] - https://search.maven.org/artifact/io.github.handakumbura/Seleniumutil

[2] - https://docs.google.com/document/d/1Diudxs53eL8QkfYwHpExkusEtpJxF0mDHVrr6XymXYE/edit?usp=sharing
