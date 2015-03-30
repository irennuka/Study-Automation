package au.irena.study.Pages

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader

import static org.openqa.selenium.By.cssSelector
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

/**
 *  Created by isierna on 3/19/2015.
 */
class MailRuNewLetterPage extends AbstractPage {
    final static SEND_BUTTON = 'div[data-name = "send"]'


    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(cssSelector(SEND_BUTTON)))
    }

    MailRuNewLetterPage() {
        HtmlElementLoader.populatePageObject(this, driver)
    }

    @FindBy(css = 'textarea[data-original-name="To"]')
    WebElement emailMessageToAddress

    @FindBy(css = 'input[name="Subject"]')
    WebElement emailMessageSubject

    @FindBy(css = MailRuNewLetterPage.SEND_BUTTON)
    WebElement sendButton

    @FindBy(css = 'iframe[id^=compose_]')
    WebElement iFrame

    public void typeMessage(String greeting, String body) {
        driver.switchTo().frame(iFrame)
        WebElement emailBody = driver.findElement(By.tagName('body'))
        emailBody.sendKeys(greeting + "\n" + "\n" + body)
        driver.switchTo().defaultContent()
    }


}
