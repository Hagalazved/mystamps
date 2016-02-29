Feature: User registration

  Scenario: Email should not be too long
    Given As anonymous user
    When I open registration page
    And I enter email max length
    Then I see that field "email" has error "Value is greater than allowable maximum of 255 characters" in register user form