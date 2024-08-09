package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInElements;
import utils.GetCsvData;
import utils.DriverManager;

public class LogInStepDefinitions {
    private WebDriver driver;
    private LogInElements logInElements;
    private GetCsvData getCsvData;
    private String userName;
    private String password;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
        this.logInElements = new LogInElements(this.driver);
    }

    @Given("I am on the DemoBlaze website and navigate to the LogIn model")
    public void i_am_on_the_demo_blaze_website_and_navigate_to_the_log_in_model() {
        this.logInElements.logInButtonIndex();
    }

    @When("I fill the input fields with the data from {string}")
    public void i_fill_the_input_fields_with_the_data_from(String csvFilePath) {
        // Write code here that turns the phrase above into concrete actions
        this.getCsvData = new GetCsvData(csvFilePath);
        userName = this.getCsvData.getInputDataFromCsv().get(0).toString();
        password = this.getCsvData.getInputDataFromCsv().get(1).toString();
        logInElements.accessToInputFields(userName, password);
        logInElements.logInButtonAccess();
    }

    @Then("The user is logged to the website and returns to the index page")
    public void the_user_is_logged_to_the_website_and_returns_to_the_index_page() {
        System.out.println("dddd");

    }
}
