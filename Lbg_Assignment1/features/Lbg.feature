Feature: Testing Lloyds Bank Website

  @tag2
  Scenario Outline: Validating Current Account Page
    Given Bank page should open "<baseurl>"
    When i mouse hover on products and service and click on current accounts
    And checking the validatios
    Then it should be loaded with "<url>"

    Examples: 
      | baseurl                     | url                                              |
      | https://www.lloydsbank.com/ | https://www.lloydsbank.com/current-accounts.html?wt.ac=products/navigation/currentaccounts |
