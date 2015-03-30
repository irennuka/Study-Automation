package au.irena.study.Pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 *  Created by isierna on 3/17/2015.
 */
class MailRuHomePage extends AbstractPage {
    @FindBy(css = MailRuHomePage.LOGIN_INPUT)
    WebElement login

    @FindBy(css = '#mailbox__password')
    WebElement password

    @FindBy(css = '#mailbox__auth__button')
    WebElement loginSubmitButton

    final static String LOGIN_INPUT = '#mailbox__login'

    @Override
    public void go() {
        driver.get("https://mail.ru/")
        at()
    }

    MailRuHomePage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector(LOGIN_INPUT)))
    }

}
