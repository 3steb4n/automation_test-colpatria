Feature: DemoBlaze

  Scenario: Sign Up new user
    Given the user is on the DemoBlaze website and navigates to the Sign Up modal
    When the user fills in the input fields in the Sign Up modal with the data from "src/test/resources/data/input_data.csv" and presses the action button
    Then the new user is created and the browser returns the following PopUp: "Sign up successful."

  Scenario: Log In new user
    Given the user is on the DemoBlaze website and navigates to the Log In modal
    When the user fills in the input fields in the Log In modal with the data from "src/test/resources/data/input_data.csv" and presses the action button
    Then the user is logged in to the website and returned to the index page with the Username

  Scenario: Select category and article
    Given the user is on the DemoBlaze website with the categories list
    When the user selects its category and article defined in the "src/test/resources/data/input_data.csv"
    Then the user is returned to the Article Page with its name, price and description, and the "Add to cart" button

  Scenario: Add an article to the cart
    Given the user is on Product Page
    When the user clicks the Add to Cart button
    Then the webpage returns the alert message "Product added."

  Scenario: Verify article in the cart
    Given the user is on the Product Page
    When the user clicks the Cart navbar button
    Then the webpage returns the article added to the cart with its price and its name

  Scenario: Place an order
    Given the user is on the Cart Page
    When the user clicks the Place Order button
    Then the webpage returns the Place Order modal
    Then the user fills in the input fields in the Place Order modal with the data from "src/test/resources/data/place_order_data.csv"
    Then the user presses the Purchase button
    Then the webpage returns a modal with the message "Thank you for your purchase!" along with the Card Number, Amount, and Name of the article