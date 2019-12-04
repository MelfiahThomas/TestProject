@fp
Feature: actiTime feature page scenarios

  @fp @f1
  Scenario: Validate Features menu
    Given Iam on actiTime home page
    When I click on the Features menu
    Then I verify features page

  @fp @f2
  Scenario: Collect all the link from the features page
    Given Iam on the Features  Page
    When I collect the features list displayed in the features page
    Then I verify all the feature list  are collected

  @fp @f3
  Scenario: validtae Cookie alert gets displayed
    Given Iam on actiTime home page
    When I verify cookie alert is displayed
    And I click on Got it button
    Then I verify alert box get cancelled

  @fp @f4
  Scenario: Validate help symbol
    Given Iam on actiTime home page
    When I click on help symbol
    Then I verify help pop-up gets displayed
  @fp @f5
  Scenario Outline: Validate help symbol with wrong creds
    Given  Iam on actiTime home page
    When I click on help symbol
    And I enter '<Name>' and '<Eamil>' with invalid creds
    And I select Request a demo option and click submit
    Then I verify submit is not enabled

    Examples: 
      | Name | Eamil         |
      | 12sa | abc2gmail.com |
      | abc  | abc@com       |
