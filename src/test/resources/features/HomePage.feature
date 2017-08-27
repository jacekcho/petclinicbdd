Feature: Home Page

  Scenario: User validate bookmarks on main page
    When User is on home page
    Then Home bookmark is displayed
    And Find owner bookmark is displayed
    And Veterinarians bookmark is displayed
    And Error bookmark is displayed
    And Help bookmark is displayed

  Scenario: User validate welcome image on main page
    When User is on home page
    Then Welcome image is displayed