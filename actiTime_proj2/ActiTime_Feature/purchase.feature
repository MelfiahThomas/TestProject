@pp
Feature: Validate Purchase page

  @p1
  Scenario: Validate Purcahse Menu
    Given Iam on the actiTime homepage
    When I click on the purchase menu
    Then I verify purchase page gets displayed

  @p2
  Scenario: Validate Configure your package
  
    Given Iam on the actiTime homepage
    When I set the number of users
    And I set the payment period
    Then I verify total cost gets displayed

  @p3
  Scenario: Validate continue button
    Given Iam on the actiTime homepage
    When I click on the  continue button
    Then I verify billing information page gets displayed

  @p4
  Scenario: Validate limited functionality
    Given Iam on the actiTime homepage
    When I click number of users to 3
    Then I verify limited fuctionality option get display
    And I click on limited functionalty option

  @p5
  Scenario: Validate support link
    Given Iam on the actiTime homepage
    When I verify actiTime support link
    Then I verify link is clickable
