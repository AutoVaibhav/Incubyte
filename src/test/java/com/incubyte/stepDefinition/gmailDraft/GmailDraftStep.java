package com.incubyte.stepDefinition.gmailDraft;

import com.incubyte.contextManager.TextContext;
import com.incubyte.pageObjects.gmailDraftPage.GmailDraftPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GmailDraftStep {
    TextContext textContext;
    GmailDraftPage gmailDraftPage;
    public GmailDraftStep(TextContext textContext) {
        this.textContext = textContext;
        gmailDraftPage = textContext.getPageManager().getGmailDraftPage();
    }

    @Given("User is on gmail login page")
    public void user_is_on_gmail_login_page() {
        gmailDraftPage.userLaunchAndValidateHomePage();
    }

    @When("User enter valid email address and click on next")
    public void user_enter_valid_email_address_and_click_on_next() {
        gmailDraftPage.enterEmailAndClickOnNext();
    }

    @And("User enter valid password and click on next")
    public void user_enter_valid_password_and_click_on_next() {
        gmailDraftPage.enterPasswordAndClickOnNext();
    }

    @Then("Verify user should able to login")
    public void verify_user_should_able_to_login() {
        gmailDraftPage.validateUserShouldAbleToLogin();
    }

    @When("User click on compose button")
    public void user_click_on_compose_button() {
        gmailDraftPage.clickOnComposeButton();
    }

    @And("User fill to field with {string}")
    public void user_fill_to_field_with(String to) {
        gmailDraftPage.fillToField(to);
    }

    @And("User fills out the email subject as {string} and body as {string}")
    public void user_fills_out_the_email_subject_as_and_body_as(String subject, String body) {
        gmailDraftPage.enterDraftDetails(subject, body);
    }

    @And("User click on send email button")
    public void user_click_on_send_email_button() {
        gmailDraftPage.clickOnSendButton();
    }

    @Then("Verify send email display in sent section with subject as {string}")
    public void verify_send_email_display_in_sent_section(String subject) {
        gmailDraftPage.validateEmailSendSuccessfully(subject);
    }


}
