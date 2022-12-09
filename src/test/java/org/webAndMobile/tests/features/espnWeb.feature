Feature: ESPN web navigation

  In order to be a registered user and access the content of the website
  As a user of the ESPN website
  I want to be able to log in and navigate through the website

  @webNavigation
  Scenario Outline: As a user, I can navigate from the home page to the watch page
    Given User is on the ESPN home page
    When User sign up successfully <firstname> <lastname> <email> <password>
    Then Watch page should displays different carousels
    And User returns to home page
    And User logs out from session

    Examples:
      | firstname | lastname   | email                      | password   |
      | "Joan"   | "Zorovich"  | "prueba1234@prueba123.com" | "P12345678#" |