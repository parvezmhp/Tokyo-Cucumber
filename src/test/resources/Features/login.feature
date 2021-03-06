Feature: Test login functionality

#Positive Test - Data Parameterization
  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "Parvez" and password "12345"
    And user clicks on login button
    Then user is navigated to home page

  @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "<username>" and password "<password>"
    And user clicks on login button
    Then user is navigated to home page

    Examples:
      |username|password|
      |Rifat   |12345 |
      |Parvez  |12345 |
      |Arif    |12345 |

  Scenario: Check login is successful using data table
    Given a user is on the login page
    When user clicks on login button upon entering credentials
      |username|password|
      |Rifat    |12345   |
    Then user is navigated to home page


  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    Given a user is on the login page
    When user enters username "Parvez" and password "44444"
    And user clicks on login button
    Then user is failed to login