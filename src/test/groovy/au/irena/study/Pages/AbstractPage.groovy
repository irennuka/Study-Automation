package au.irena.study.Pages

import au.irena.study.Utils.Helpers
import au.irena.study.Utils.SeleniumSuiteListener
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition

/**
 *  Created by isierna on 3/17/2015.
 */
abstract class AbstractPage {
    void go() {}

    void at() {}

    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        Helpers.waitUntil(expectedCondition, driver)
    }
}
