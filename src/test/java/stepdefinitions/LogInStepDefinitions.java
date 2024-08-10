package stepdefinitions;

import org.junit.Assert;
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

    @Given("I am on the DemoBlaze website and navigate to the Log In modal")
    public void i_am_on_the_demo_blaze_website_and_navigate_to_the_log_in_modal() {
        this.logInElements.logInButtonIndex();
    }

    @When("I fill the input fields in the Log In modal with the data from {string} and press the action button")
    public void i_fill_the_input_fields_in_the_log_in_modal_with_the_data_from_and_press_the_action_button(String csvFilePath) {
        // Write code here that turns the phrase above into concrete actions
        this.getCsvData = new GetCsvData(csvFilePath);
        userName = this.getCsvData.getInputDataFromCsv().get(0).toString();
        password = this.getCsvData.getInputDataFromCsv().get(1).toString();
        logInElements.accessToInputFields(userName, password);
        logInElements.logInButtonAccess();
    }

    @Then("the user is logged in to the website and returned to the index page with the Username")
    public void the_user_is_logged_in_to_the_website_and_returned_to_the_index_page_with_the_username() {
        // Usuario igual a Usuario retornado en la pagina principal
        Assert.assertEquals("Welcome " + this.userName, this.logInElements.getUsernameIndex());
    }
}
