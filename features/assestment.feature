Feature: MassMutual Problem1
  I want to verify the some values in web page

  Background: 
    Given Navigate to page "page_URL"
  
  Scenario: Verify the right count of values appear on the screen
    Given right count values table as below
      | Value 1       | $122,365.24 |
      | Value 2       | $599.00     |
      | Value 3       | $850,139.99 |
      | Value 4       | $23,329.50  |
      | Value 5       | $566.27     |
      | Total Balance | $1,000,000.00     |
    Then values shouldbe same appear on the screen
 
  Scenario: Verify the values on the screen greater than 0
    Then verify the values on the screen are greater than 0

  Scenario: Verify the total balance is correct based on the values listed on the screen
    Then verify the total balance is correct based on the values listed on the screen

  Scenario: Verify the values are formatted as currencies
    Then verify the values are formatted as currencies

  Scenario: Need to verify the total balance matches the sum of the values
    Given values table as below
      | Value 1 | $122,365.24 |
      | Value 2 | $599.00     |
      | Value 3 | $850,139.99 |
      | Value 4 | $23,329.50  |
      | Value 5 | $566.27     |
    Then values sum shouldbe same Total Balance that appear on the screen
   
