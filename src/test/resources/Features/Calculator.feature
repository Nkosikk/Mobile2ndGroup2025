@calculator @Regression
Feature: Calculator

  @Regression @NkosiTest
  Scenario: verify that one plus one is equal to two
    Given I have a Calculator app
    And I click on the number one button
    And I click on the plus sign button
    And I click on the number one button
    When I click on the equal sign button
    Then the result should be number two

  @Regression @AthenkosiTest
  Scenario: verify that when adding five to two the result is seven
    Given On the same Calculator app
    And I click on the plus sign button to add five
    And I click on the number five button
    When I click on the equal sign button again
    Then the result should be number negative "7"