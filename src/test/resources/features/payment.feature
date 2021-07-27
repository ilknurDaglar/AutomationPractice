Feature:Payment page


  Scenario: the user wants to buy items and pay it
    Given the user is on the home page
    When the user navigate to Women Page
    When The user hover over the item picture
    And The user should see the "Add to chart" pop up
    And The user click the Add to cart button 0
    And The user should see the "Product added" popup message
    And The user click the Add to cart button 1
    And The user should see the "Product added" popup message
    And The user click on the "Proceed to checkout" button
    And Verify that the page title is "Your shopping chart"
    And the user clicks Proceed to checkout button on the payment page
    Then Verify that address page should display
    And the user clicks Proceed to checkout button on the payment page
    And the user clicks the I agree checkbox
    And the user clicks Proceed to checkout button on the payment page
    Then Verify that payment page should display



