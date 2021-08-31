Feature: Order T-shirt and Change name in MyAccount

  @tag1
  Scenario Outline: Order a t-shirt and verify
    Given user open browser and enter url
    When user enters username> and password
    And Clicks login
    And Orders a t-shirt proceed to Checkout
    And Selects payment method
    And Selects Order History
    Then Verifies the order placed

  @tag2
  Scenario Outline: Change First name from Myaccount
    Given user open MyAccount page
    When user changes the first Name
    And user saves the data
    Then Verifies the change is made properly

