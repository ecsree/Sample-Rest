Feature: Batch

  Scenario: To get a batch details
    Given list of batch is available
    When I send a request with programId
    Then the batch details shoulde be displayed
