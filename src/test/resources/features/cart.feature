Feature: User can add the items in cart and buy

  Background:

    Given the user is on the home page
    When the user navigate to Women Page
@wip
  Scenario:Adding item to basket
    And The user hover over the item picture
    And The user should see the "Add to chart" pop up
    And The user click the Add to cart button 0
    And The user should see the "Product added" popup message
    And The user click "Continue Shopping" button
    And The user hover over other item picture
    And The user should see the "Add to chart" pop up
    And The user click the Add to cart button 1
    And The user should see the "Product added" popup message
    And The user click on the "Proceed to checkout" button
    And Verify that the page title is "Your shopping chart"
    Then Verify that two selected items is in the basket



  Scenario:Verifying the selected items prices
    When The user hover over the item picture
    And The user should see the "Add to chart" pop up
    And The user click the Add to cart button 0
    And The user should see the "Product added" popup message
    And The user click "Continue Shopping" button
    And The user hover over other item picture
    And The user should see the "Add to chart" pop up
    And The user click the Add to cart button 1
    And The user should see the "Product added" popup message
    And The user click on the "Proceed to checkout" button
    And Verify that the page title is "Your shopping chart"
    When Verify that two selected items is in the basket
    Then Verify that total price is sum of two prices and plus shipping