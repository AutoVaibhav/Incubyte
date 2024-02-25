Feature: Validate Gmail draft functionality

  Background: User login to gmail account
    Given User is on gmail login page
    When User enter valid email address and click on next
    And User enter valid password and click on next
    Then Verify user should able to login

  @GmailDraft
  Scenario Outline: Compose email with subject Incubyte and body Automation QA test
    When User click on compose button
    And User fill to field with "<To>"
    And User fills out the email subject as "<Email Subject>" and body as "<Email Body>"
    And User click on send email button
    Then Verify send email display in sent section with subject as "<Email Subject>"
    Examples:
      | To            | Email Subject | Email Body                      |
      | abc@gmail.com | Incubyte      | Automation QA Test for Incubyte |
