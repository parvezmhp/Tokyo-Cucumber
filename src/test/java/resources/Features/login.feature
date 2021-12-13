@Login_test
Feature: Test login functionality

  Background:
  Given a user is on the login page

  @Positive_Test @Data_Parameterization
  Scenario: Check login is successful with valid credentials
    When user enters username "Parvez" and password "12345"
    And click on login button
    Then user is navigated to home page

  @dataDriven_test @positive_test
  Scenario Outline: Check login is successful with valid credentials
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
      |username|password|
      |Rifat   |12345 |
      |Parvez  |12345 |
      |Arif    |12345 |

  @dataDriven_test @positive_test
  Scenario: Check login is successful using data table
    When user click on login button upon entering credentials
      |username|password|
      |Rifat    |12345   |
    Then user is navigated to home page

  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    When user enters username "Parvez" and password "44444"
    And click on login button
    Then user is failed to login