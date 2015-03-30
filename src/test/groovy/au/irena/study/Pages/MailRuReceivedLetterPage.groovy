package au.irena.study.Pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 *  Created by isierna on 3/26/2015.
 */
class MailRuReceivedLetterPage extends AbstractPage {
    final static LETTER_BODY = 'div.b-letter__body'

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector(LETTER_BODY)))
    }

    MailRuReceivedLetterPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @FindBy(css = MailRuReceivedLetterPage.LETTER_BODY)
    WebElement letterBody
}
