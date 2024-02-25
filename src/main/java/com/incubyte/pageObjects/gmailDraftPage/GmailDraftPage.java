package com.incubyte.pageObjects.gmailDraftPage;

import com.incubyte.baseClass.BaseClass;
import com.incubyte.manager.ReaderManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailDraftPage {
    private static WebDriver driver;

    public GmailDraftPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Use another account')]")
    private WebElement useAnotherAccount;
    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailTextBox;
    @FindBy(xpath = "//span[normalize-space()='Next']/../../button")
    private WebElement nextButton;
    @FindBy(xpath = "//input[@name='Passwd']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//span[normalize-space()='Forgot password?']")
    private WebElement forgotPassword;
    @FindBy(xpath = "//div[contains(text(),'Compose')]")
    private WebElement composeButton;
    @FindBy(xpath = "//input[@id=':tf']")
    private WebElement emailToTextBox;
    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement subjectTextBox;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement messageBody;
    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendButton;
    @FindBy(xpath = "//a[normalize-space()='Sent']")
    private WebElement sentTabOnLeftPane;
    @FindBy(xpath = "//table[@role='grid']/tbody/tr[1]/td[5]/div/div/div/span/span")
    private WebElement firstSendEmail;


    public void userLaunchAndValidateHomePage() {
        GmailDraftPage.driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
        String actualPageTitle = GmailDraftPage.driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals("validate user is on home page ", "Sign in - Google Accounts", actualPageTitle);
    }

    public void enterEmailAndClickOnNext() {
        BaseClass.waitForVisibility(emailTextBox, 30, GmailDraftPage.driver);
        emailTextBox.sendKeys(ReaderManager.getInstance().getConfigReader().getEmailId());
        BaseClass.javaScriptClick(GmailDraftPage.driver, nextButton);
    }

    public void enterPasswordAndClickOnNext() {
        BaseClass.waitForVisibility(passwordTextBox, 30, GmailDraftPage.driver);
        passwordTextBox.sendKeys(ReaderManager.getInstance().getConfigReader().getPassword());
        BaseClass.javaScriptClick(GmailDraftPage.driver, nextButton);
    }

    public void validateUserShouldAbleToLogin() {
        BaseClass.waitForVisibility(composeButton, 150, GmailDraftPage.driver);
        Assert.assertEquals("Validate successfull login", "Compose", composeButton.getText().trim());
    }

    public void clickOnComposeButton() {
        composeButton.click();

    }

    public void fillToField(String to) {
        BaseClass.waitForVisibility(emailToTextBox, 30, GmailDraftPage.driver);
        emailToTextBox.sendKeys(to);
    }

    public void enterDraftDetails(String subject, String body) {
        BaseClass.waitForVisibility(subjectTextBox, 30, GmailDraftPage.driver);
        subjectTextBox.sendKeys(subject);
        BaseClass.waitForVisibility(messageBody, 30, GmailDraftPage.driver);
        emailToTextBox.sendKeys(body);

    }

    public void clickOnSendButton() {
        BaseClass.waitForVisibility(sendButton, 30, GmailDraftPage.driver);
        sendButton.click();
        BaseClass.staticWaitForVisibility(3000);
    }

    public void validateEmailSendSuccessfully(String subject) {
        BaseClass.waitForVisibility(sentTabOnLeftPane, 30, GmailDraftPage.driver);
        sentTabOnLeftPane.click();
        BaseClass.waitForVisibility(firstSendEmail, 30, GmailDraftPage.driver);
        Assert.assertTrue("Validate sent email section", firstSendEmail.getText().contains(subject));
    }


}
