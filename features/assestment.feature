Feature: Verify the some values
  I want to verify the some values in web page

  Background: 
    Given Navigate to page "page_URL"

  Scenario: Verify the right count of values appear on the screen
    When verify value table as below
      | Value 1 | $122,365.24   |
      | Value 2 | $599.00       |
      | Value 3 | $850,139.99   |
      | Value 4 | $23,329.50    |
      | Value 5 | $566.27       |
     

  Scenario: Verify the values on the screen are greater than 0
    When verify the values on the screen are greater than 0
    
  Scenario: Verify the total balance is correct based on the values listed on the screen
    When verify the total balance is correct based on the values listed on the screen
     | Total   | $1,000,000.00 |

  Scenario: Verify the values are formatted as currencies
    When verify the values are formatted as currencies

  Scenario: Verify the total balance matches the sum of the values
    When verify the total balance matches the sum of the values
