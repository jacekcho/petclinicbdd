Feature: Pet Owner

  Background:
    Given User is on home page
    And click the Find Owners bookmark

  Scenario: User is checking owners list
    When click the Find Owner button
    Then User see list of owners

  Scenario: User create new owner
    When click Add Owner button
    And enter random first name
    And enter random last name
    And enter random address
    And enter random city
    And enter random telephone
    And click submit and add owner
    Then User see summary page after added new owner

  Scenario: User find created owner
    And create new owner
    And click the Find Owners bookmark
    And enter created owner name in the search owner form
    When click the Find Owner button
    Then User see created owner data