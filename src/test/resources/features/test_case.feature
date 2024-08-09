Feature: DemoBlaze

  Scenario: Sign Up new user
    Given I am on the DemoBlaze website and navigate to the SignUp model
    When  I fill the input fields with the data from "src/test/resources/data/input_data.csv"
    Then  The new user is created and the browser return the next PopUp "Sign up successful."

  Scenario: Log In new User
    Given I am on the DemoBlaze website and navigate to the LogIn model
    When  I fill the input fields with the data from "src/test/resources/data/input_data.csv"
    Then  The user is logged to the website and returns to the index page

  Scenario: Select category
    Given I am on the DemoBlaze index page
    When  I click the Category from "src/test/resources/data/input_data.csv"
    Then  It returns the articles from the category selected

  Scenario: Select article and Add to Cart
    Given I am on the DemoBlaze index page with the articles
    When  I click the article from "src/test/resources/data/input_data.csv"
    Then  It returns the product web page selected
    And   I click to Add to cart button
    And   The browser returns the next Popup "Product added."
