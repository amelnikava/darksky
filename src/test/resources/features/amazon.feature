@regression @amazon
  Feature: Amazon Feature
    Background:
      Given I am on amazon create account page

      @amazon-1
      Scenario: Verify invalid password

      When I enter Anna Melnikava into name text fields on create account screen
      And I enter test@gmail.com into email text fields on create account screen
      And I enter 12345 into password text fields on create account screen
      And I enter 12345 into checkPassword text fields on create account screen
      And I click on create button on create account screen
      Then I verify that I can't create an account

        @amazon-2
        Scenario: Verify that password do not match

          When I enter Anna Melnikava into name text fields on create account screen
          And I enter anna.melnikava@gmail.com into email text fields on create account screen
          And I enter Belarus2015 into password text fields on create account screen
          And I enter Belarus@2015 into password text fields on create account screen
          Then I verify that I can't create an account

          @amazon-3

          Scenario: Verify invalid e-mail
            When I enter Anna Melnikava  into name text field
            And I enter annamel into email text field
            And I enter 12345 into password text field
            And I enter 12345 into checkPassword text field
            And I click on create button on create account screen
            Then I verify that I can't create an account with invalid e-mail

            @amazon-4

            Scenario: Verify that password field is not empty
              When I enter Anna Melnikava  into name text field
              And I enter annamel into email text field
              And I do not enter password
              And I click on create button on create account screen
              Then I verify that I can't create an account without password





