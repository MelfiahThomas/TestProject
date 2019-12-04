@cp
Feature: actiTime Client page scenario

@c1
  Scenario: Scenario: Validate Clients menu
    Given I am on actiTime home page
    When I click on the clients menu
    Then I verify clients page
@c2
  Scenario: Validate Architecture tool link
    Given I am on actiTime home page
    When I click on 'Architecture' tool link
    Then I verify that website navigates to 'Architecture' page
@c3
  Scenario: Validate Consulting tool link
    Given I am on actiTime home page
    When I click on 'Consulting' tool link
    Then I verify that website navigates to 'Consulting' page
@c4
  Scenario: Validate Design tool link
    Given I am on actiTime home page
    When I click on 'Design' tool link
    Then I verify that website navigates to 'Design' page
@c5
  Scenario: Validate Education tool link
    Given I am on actiTime home page
    When I click on 'Education' tool link
    Then I verify that website navigates to 'Education' page
@c6
  Scenario: Validate Engineering tool link
    Given I am on actiTime home page
    When I click on 'Engineering' tool link
    Then I verify that website navigates to 'Engineering' page
@c7
  Scenario: Validate HealthCare tool link
    Given I am on actiTime home page
    When I click on 'HealthCare' tool link
    Then I verify that website navigates to 'HealthCare' page
@c8
  Scenario: Validate IT tool link
    Given I am on actiTime home page
    When I click on 'IT' tool link
    Then I verify that website navigates to 'IT' page
@c9
  Scenario: Validate Small Business tool link
    Given I am on actiTime home page
    When I click on 'Small Business' tool link
    Then I verify that website navigates to 'Small Business' page
    
    @c10
    
    Scenario: validate customer review 
    Given I am on actiTime home page
     When I click on the clients menu
     Then I collect all the reviewers logo 
    
