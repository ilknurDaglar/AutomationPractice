Feature:Search result page

  Background:
    Given the user is on the home page
    And searches an item with the search box "Printed Dress"

  Scenario:Verify that the searched item name matches with the page title
    Then searched item name should be on the page

#BUG 9
  Scenario: Verify that user can sort the results according to "Price:Lowest first"
    When The user select "Price: Lowest first" from sort by
    Then Items should be sorted from cheapest to expensive
  @wip
 #BUG 10
  Scenario:Verify that user can sort the results according to "Highest first"
    When  selected "Price: Highest first" from sortby
    Then Items should be sorted from most expensive to cheapest

  Scenario:Verify that user can sort the results according to "A-Z"
    When The user select "Product Name: A to Z" from dropdown
    Then item should be sorted alphabetically

  Scenario:Verify that user sort the results according to "Z-A"
    When  selected "Product Name: Z to A" from dropdown
    Then item should be sorted Z_A