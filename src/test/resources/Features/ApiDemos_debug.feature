@ApiDemosDebug @Regression @SmokeTest
Feature: I want to test the ApiDemos app

  @Regression @AthenkosiTest
  Scenario: verify that I can open the ApiDemos app
    Given I have an ApiDemos app installed on my device
    And I click on Graphics
    When I click on AnimationDrawable
    Then I should see the picture of the AnimationDrawable
