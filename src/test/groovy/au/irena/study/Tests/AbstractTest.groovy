package au.irena.study.Tests
import au.irena.study.Utils.Helpers
import au.irena.study.Utils.SeleniumSuiteListener
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.testng.annotations.Listeners
/**
*  Created by isierna on 3/17/2015.
*/
@Listeners([SeleniumSuiteListener])
abstract class AbstractTest {
    static WebDriver getDriver() {
        SeleniumSuiteListener.driver
    }

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        Helpers.waitUntil(expectedCondition, driver)
    }

    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition, long timeout) {
        Helpers.waitUntil(expectedCondition, timeout, driver)

    }
}
