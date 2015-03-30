package au.irena.study.Pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 *  Created by isierna on 3/19/2015.
 */
class MailRuInboxPage extends AbstractPage {
    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector('span.b-nav__item__text')))
    }

    MailRuInboxPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @FindBy(css = 'a[data-name="compose"]')
    WebElement newLetterButton

    @FindBy(css = 'div.b-datalist__item:first-child span.b-datalist__item__value.b-datalist__item__date__value')
    WebElement inboxFirstMessage
}

