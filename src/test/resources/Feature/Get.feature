Feature: Batch

  Scenario: To get a batch details
    Given list of batch is available
    When I send a request with programId
    Then the batch details shoulde be displayed

    
    Scenario: create program
    Given API url ""
    When Authorized  user create a program
    Then  Validate the Program is added
    