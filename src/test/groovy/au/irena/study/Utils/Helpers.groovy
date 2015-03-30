package au.irena.study.Utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

/**
 *  Created by isierna on 3/17/2015.
 */
class Helpers {
    public static final DEFAULT_WAIT = 10L

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition, WebDriver driver) {
        waitUntil(expectedCondition, DEFAULT_WAIT, driver)
    }

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition, long timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, timeout)
        wait.until(expectedCondition)
    }

}

