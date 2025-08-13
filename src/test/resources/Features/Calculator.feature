Feature: Calculator
  Scenario: verify that one plus one is equal to two
    Given I have a Calculator app
    And I click on the number one button
    And I click on the plus sign button
    And I click on the number one button
    When I click on the equal sign button
    Then the result should be number two