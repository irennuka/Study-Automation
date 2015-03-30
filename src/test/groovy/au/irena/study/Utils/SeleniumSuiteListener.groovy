package au.irena.study.Utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.ISuite
import org.testng.ISuiteListener

/**
 *  Created by isierna on 3/17/2015.
 */
class SeleniumSuiteListener implements ISuiteListener {
    private static WebDriver fireFox

    @Override
    void onStart(ISuite suite) {
        fireFox = new FirefoxDriver()
    }

    @Override
    void onFinish(ISuite suite) {
        fireFox.quit()
    }

    static WebDriver getDriver() {
        fireFox
    }
}
