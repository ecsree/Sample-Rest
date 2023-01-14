 Feature: Program

  Background: 
    Given API url

  Scenario: Authorized User is able to add program
    When Authorized User add program
    Then program is added

  Scenario: User able to see all the programs
    When user submit get request
    Then All programs is displayed
 
    