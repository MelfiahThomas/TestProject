@bp

Feature: actiTime blog page scenario
@b1
   Scenario: Validate Blog menu
   
    Given Iam on the actiTime home page
    When I click on the Blog menu
    Then I verify blog page
  @b2  
    Scenario: Validate Blog index menu bar
    Given Iam on the actiTime home page
    When I verify blog index menu is displayed
    Then I collect menu list
 @b3   
    Scenario: Validate Read more link 
     Given Iam on the actiTime home page
     When I click on read more option
     Then I verify website navigate to next page
   @b4  
    Scenario: Validate Article count
    Given Iam on the actiTime home page
    When I verify article dispalyed
    Then I get the count of the article