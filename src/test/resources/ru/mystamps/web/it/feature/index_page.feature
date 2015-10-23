Feature: User on index page

  Scenario: Anonymous user opens index page
      Given As anonymous user
       When I open index page
       Then I see welcome text
        And I see 2 navigation links
        And I see link for list of categories
        And I see link for list of countries
<<<<<<< 5a3f7f18c4f46b20c6341c1fd131c5710bfda333

  Scenario: Authenticated user opens index page
      Given As authenticated user
       When I open index page
       Then I see welcome text
        And I see 5 navigation links
        And I see link for list of categories
        And I see link for list of countries
        And I see link for adding series
        And I see link for adding categories
        And I see link for adding countries

  Scenario: Administrator opens index page
      Given As administrator
       When I open index page
       Then I see welcome text
        And I see 6 navigation links
        And I see link for list of categories
        And I see link for list of countries
        And I see link for adding series
        And I see link for adding categories
        And I see link for adding countries
        And I see link for viewing suspicious activities
=======
        But I don't see link for adding series
        But I don't see link for adding categories
        But I don't see link for adding countries

  Scenario: Authenticated user open index page
      Given As authenticated user
       When I open index page
       Then I see welcome text
        And I see 3 navigation links
        And I see link for list of categories
        And I see link for list of countries
        And I see link for adding series
        But I don't see link for adding categories
        But I don't see link for adding countries
<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
=======
>>>>>>> WhenUserAtIndexPage: port to Cucumber.

