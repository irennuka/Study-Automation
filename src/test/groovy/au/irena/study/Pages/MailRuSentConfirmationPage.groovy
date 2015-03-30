package au.irena.study.Pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader

import java.text.SimpleDateFormat

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement

/**
 *  Created by isierna on 3/25/2015.
 */
class MailRuSentConfirmationPage extends AbstractPage {
    String timeMessageSent

    @FindBy(css = 'a[title="выход"]')
    WebElement logoutButton

    @FindBy(css = "div.message-sent__title")
    WebElement sendEmailConfirmation

    MailRuSentConfirmationPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @Override
    public void at() {
        waitUntil(textToBePresentInElement(sendEmailConfirmation, ""))
    }

    public void saveTimeSent() {
        Calendar timeNow = Calendar.getInstance()
        SimpleDateFormat<String> simpleDateFormat = new SimpleDateFormat<String>("HH:mm")
        this.timeMessageSent = simpleDateFormat.format(timeNow.getTime())
    }
}
