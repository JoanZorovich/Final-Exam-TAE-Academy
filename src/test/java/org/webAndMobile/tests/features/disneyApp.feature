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

  @mobileNavigation
  Scenario: As a user, I can consult the options menu and access  the Privacy & Legal information
    Given User is on Disneyland dashboard screen
    When User taps on menu button
    And  Tap on Privacy & legal
    Then User can see a list of options

  @mobileNavigation
  Scenario: As a user, I can check the different plans that Disneyland offers me, among them Reserve Dining
    Given User is on Disneyland dashboard screen
    When User taps on  Add Plans Button
    Then User can see the Plan list
    And Check if the Reserve Dining Option is in the list