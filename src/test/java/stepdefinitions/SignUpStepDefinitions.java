package stepdefinitions;

import pages.SignUpElements;
import utils.AccessContext;
import utils.CsvDataLoader;
import utils.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SignUpStepDefinitions {

    private WebDriver driver;
    private SignUpElements signUpElements;
    private AccessContext accessContext;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
        this.signUpElements = new SignUpElements(this.driver);
        this.accessContext = AccessContext.getInstance();
    }

    @Given("the user is on the DemoBlaze website and navigates to the Sign Up modal")
    public void the_user_is_on_the_demo_blaze_website_and_navigate_to_the_sign_up_modal() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.demoblaze.com/index.html");

        this.signUpElements.signUpButtonIndex();
    }

    @When("the user fills in the input fields in the Sign Up modal with the data from {string} and presses the action button")
    public void the_user_fills_in_the_input_fields_in_the_sign_up_modal_with_the_data_from_and_presses_the_action_button(String csvFilePath) throws IOException {
        // Implementa la lógica para seleccionar fechas desde un archivo CSV aquí
        CsvDataLoader getCsvData = new CsvDataLoader(csvFilePath);
        String userName = getCsvData.getInputDataFromCsv().get(0);
        String password = getCsvData.getInputDataFromCsv().get(1);

        accessContext.setUsername(userName);
        accessContext.setPassword(password);

        this.signUpElements.accessToInputFields(userName, password);
        this.signUpElements.signUpButtonAccess();
    }

    @Then("the new user is created and the browser returns the following PopUp: {string}")
    public void the_new_user_is_created_and_the_browser_returns_the_following_pop_up(String m) throws InterruptedException {
        // El mensaje del Alert debe ser igual al esperado
        Assert.assertEquals(m, this.signUpElements.getAlertText());
    }
}