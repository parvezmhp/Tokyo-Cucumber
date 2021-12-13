Feature: Mortgage Calculator

  @CalculateAPR
  Scenario: Calculate Real APR
    Given user is in mortgage calculator home page
    And user navigates to the Real APR page
    When user clicks on the Calculate button upon entering data
    |HomePrice|DownPayment|InterestRate|
    |200000   |15000      |3           |
    Then the Real APR is "3.130%"
