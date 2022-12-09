Feature: Disneyland mobile navigation

  In order to access the content of the different options on the bottom bar
  As a user of the Disneyland App
  I want to be able to navigate through the mobile app

  @mobileNavigation
  Scenario: As a user, I can navigate from Dashboard screen to Map screen
    Given User is on Disneyland dashboard screen
    When User taps the Map Button available e in the bottom bar
    And User taps Attractions List
    Then User can see different categories to select, including hotels