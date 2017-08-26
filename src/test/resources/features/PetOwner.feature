Feature: Find Owner Page

  Scenario: User is checking owners list
    Given User is on home page
    And click the Find Owners bookmark
    When click the Find Owner button
    Then User see list of owners

  Scenario: Create new Owner
    Given User is on home page
    And click the Find Owners bookmark
    When click Add Owner button
    And enter random values for new owner
    And click submit and add owner
    Then User see summary page after added new owner