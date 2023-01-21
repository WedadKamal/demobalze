@smoke


Feature: F02_Login | user could login and assert on Welcome and Logout Words

  Scenario: S02_Login | user could login and assert on Welcome and Logout Words

    When Click On login Button
    And enter "wedad55" and "password"
    And click on Signin on Login Page
    Then Assert on welcome word and logout word
