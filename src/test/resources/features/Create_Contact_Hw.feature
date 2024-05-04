@End2End
Feature: Create Contact

  Scenario: Create Contact
    Given user goes to "https://documenter.getpostman.com/view/4012288/TzK2bEa8"
    When user goes to url and add contact
    And User reads the contact
    And user updates the contact
    And user delete the created contact
    Then negative assert the deleted contact