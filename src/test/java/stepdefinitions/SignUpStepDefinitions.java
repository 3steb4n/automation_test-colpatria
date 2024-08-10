package stepdefinitions;

import pages.SignUpElements;
import utils.DriverManager;
import utils.GetCsvData;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SignUpStepDefinitions {

    private WebDriver driver;
    private SignUpElements signUpElements;
    private GetCsvData getCsvData;
    private String userName;
    private String password;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
        this.signUpElements = new SignUpElements(this.driver);
    }

    @Given("I am on the DemoBlaze website and navigate to the Sign Up modal")
    public void i_am_on_the_demo_blaze_website_and_navigate_to_the_sign_up_modal() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.demoblaze.com/index.html");

        this.signUpElements.signUpButtonIndex();
    }

    @When("I fill the input fields in the Sign Up modal with the data from {string} and press the action button")
    public void i_fill_the_input_fields_in_the_sign_up_modal_with_the_data_from_and_press_the_action_button(String csvFilePath) throws InterruptedException {
        // Implementa la lógica para seleccionar fechas desde un archivo CSV aquí
        this.getCsvData = new GetCsvData(csvFilePath);
        this.userName = this.getCsvData.getInputDataFromCsv().get(0).toString();
        this.password = this.getCsvData.getInputDataFromCsv().get(1).toString();
        this.signUpElements.accessToInputFields(this.userName, this.password);
        this.signUpElements.signUpButtonAccess();

    }

    @Then("the new user is created and the browser returns the following PopUp: {string}")
    public void the_new_user_is_created_and_the_browser_returns_the_following_pop_up(String m) {
        // El mensaje del Alert debe ser igual al esperado
        Assert.assertEquals(m, this.signUpElements.getAlertText());
    }
}