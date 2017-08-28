Feature: Pet Owner

  Background:
    Given User is on home page
    And click the Find Owners bookmark

  Scenario: User is checking owners list
    When click the Find Owner button
    Then User see list of owners

  Scenario: User create new owner
    When click Add Owner button
    And enter random values for new owner
    And click submit and add owner
    Then User see summary page after added new owner