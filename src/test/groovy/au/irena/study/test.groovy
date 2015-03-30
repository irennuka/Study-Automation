package au.irena.study

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.Test

/**
 * Created by isierna on 3/17/2015.
 */
class test {

    @Test
    public static void openGoogle() {
        WebDriver driver = new FirefoxDriver()
        driver.get("http://www.google.com")
    }
}