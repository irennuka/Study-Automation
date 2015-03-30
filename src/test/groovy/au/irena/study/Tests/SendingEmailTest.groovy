package au.irena.study.Tests
import au.irena.study.Pages.*
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement
/**
*  Created by isierna on 3/17/2015.
*/
class SendingEmailTest extends AbstractTest {
    MailRuHomePage homePage
    MailRuInboxPage inboxPage
    MailRuNewLetterPage newLetterPage
    MailRuSentConfirmationPage confirmationPage
    MailRuReceivedLetterPage receivedLetterPage

    @BeforeMethod
    public void openHomePage() {
        homePage = new MailRuHomePage()
        homePage.go()
    }

    @AfterMethod
    public void openBlankPage() {
        driver.get("about:blank")
    }

    @Test
    void emailSending() {
        homePage.login.sendKeys("siernai")
        homePage.password.sendKeys("123456zz")
        homePage.loginSubmitButton.click()

        inboxPage = new MailRuInboxPage()
        inboxPage.at()
        inboxPage.newLetterButton.click()
        newLetterPage = new MailRuNewLetterPage()
        newLetterPage.at()
        newLetterPage.emailMessageToAddress.sendKeys("receive11@mail.ru")
        newLetterPage.emailMessageSubject.sendKeys("Test Subject")
        newLetterPage.typeMessage("Hello Sandy,", "Default message")
        newLetterPage.sendButton.click()

        confirmationPage = new MailRuSentConfirmationPage()
        confirmationPage.saveTimeSent()
        confirmationPage.at()
        confirmationPage.logoutButton.click()

        homePage.at()
        homePage.login.clear()
        homePage.login.sendKeys("receive11")
        homePage.password.sendKeys("123456zz")
        homePage.loginSubmitButton.click()

        inboxPage = new MailRuInboxPage()
        inboxPage.at()
        waitUntil((textToBePresentInElement(inboxPage.inboxFirstMessage, confirmationPage.timeMessageSent)), 30L)
        inboxPage.inboxFirstMessage.click()

        receivedLetterPage = new MailRuReceivedLetterPage()
        receivedLetterPage.at()
        waitUntil(textToBePresentInElement(receivedLetterPage.letterBody,"Sandy"))
        Thread.sleep(1000)
    }
}


