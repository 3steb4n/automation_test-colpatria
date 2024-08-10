Feature: DemoBlaze

  Scenario: Sign Up new user
    Given I am on the DemoBlaze website and navigate to the Sign Up modal
    When I fill the input fields in the Sign Up modal with the data from "src/test/resources/data/input_data.csv" and press the action button
    Then the new user is created and the browser returns the following PopUp: "Sign up successful."

  Scenario: Log In new user
    Given I am on the DemoBlaze website and navigate to the Log In modal
    When I fill the input fields in the Log In modal with the data from "src/test/resources/data/input_data.csv" and press the action button
    Then the user is logged in to the website and returned to the index page with the Username

  Scenario: Checkout article
    Given I am on the DemoBlaze website and navigate to the categories list
    When I select the category defined in the data from "src/test/resources/data/input_data.csv"
    Then the index webpage returns the article list defined in the data from "src/test/resources/data/input_data.csv"
    And I click the article name
    Then the webpage returns the article name and the "Add to cart" button
    And I click the "Add to cart" button
    Then the webpage returns the alert message "Product added"
    And I click the "OK" button and then go to the Cart page
    Then the webpage returns the article added to the cart with its price
    And I click the "Place Order" button
    Then the webpage returns the Place Order modal
    And I fill the input fields in the Place Order modal with the data from "src/test/resources/data/place_order_data.csv" and press the "Purchase" button
    Then the webpage returns a modal with the message "Thank you for your purchase!" along with the Card Number, Amount, and Name of the article