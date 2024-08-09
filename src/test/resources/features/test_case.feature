Feature: DemoBlaze

  Scenario: Sign Up new user
    Given I am on the DemoBlaze website and navigate to the SignUp model
    When I fill the input fields with the data from "src/test/resources/data/input_data.csv"
    Then The new user is created and the browser return the next PopUp "Sign up successful."

  Scenario: Log In new User
    Given I am on the DemoBlaze website and navigate to the LogIn model
    When I fill the input fields with the data from "src/test/resources/data/input_data.csv"
    Then The user is logged to the website and returns to the index page
