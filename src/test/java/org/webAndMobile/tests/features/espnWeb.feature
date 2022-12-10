Feature: ESPN web navigation

  In order to be a registered user and access the content of the website
  As a user of the ESPN website
  I want to be able to log in and navigate through the website

  @webNavigation @espnNavigation @signUp @logOut
  Scenario Outline: As a user, I can navigate from the home page to the watch page
    Given User is on the ESPN home page
    When User goes to the login form to access to sign-up button
    And Fill the sign up form successfully <firstname> <lastname> <password>
    Then Watch page should displays different carousels
    And User returns to home page
    And User logs out from session

    Examples:
      | firstname | lastname   | password     |
      | "Joan"   | "Zorovich"  | "P12345678#" |