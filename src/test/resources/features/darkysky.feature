@regression @darksky

Feature: DarkSky Feature

  @darksky-1
Scenario: Verify timline is displayed in correct format

Given I am on Darksky home page
And I verify timeline is displayed with two hours incremented
     Then I expand todays timeline
      And I verify lowest and highest temp is displayed correctly
