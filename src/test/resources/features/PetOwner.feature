Feature: Pet Owner

  Background:
    Given User is on home page
    And user goes to find owner page

  Scenario: User is checking owners list
    When user clicks the Find Owner button
    Then user see list of owners

  Scenario: User creates new owner
    When click Add Owner button
    And enter random first name
    And enter random last name
    And enter random address
    And enter random city
    And enter random telephone
    And click submit and add owner
    Then user see summary page after added new owner
    And user see created owner data

  Scenario: User finds created owner
    When create new owner with random values
    And enter created owner name in the search owner form
    And user clicks the Find Owner button
    Then user see created owner data