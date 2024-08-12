package stepdefinitions;

import org.junit.After;
import org.junit.Assert;
import pages.CartPageElements;
import utils.AccessContext;
import utils.PlaceOrderContext;
import utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.CsvDataLoader;

import java.io.IOException;

public class PlaceOrderStepDefinitions {
    private WebDriver driver;
    private CartPageElements cartPageElements;
    public PlaceOrderContext placeOrderContext;
    public AccessContext accessContext;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
        this.placeOrderContext = new PlaceOrderContext();
        this.accessContext = AccessContext.getInstance();
    }

    @Given("the user is on the Cart Page")
    public void the_user_is_on_the_cart_page() {
        this.cartPageElements = new CartPageElements(this.driver);
    }

    @When("the user clicks the Place Order button")
    public void the_user_clicks_the_place_order_button() {
        this.cartPageElements.clickPlaceOrderButton();
    }

    @Then("the webpage returns the Place Order modal")
    public void the_webpage_returns_the_place_order_modal() {
        // Verificar si el modal se abrio, y que el Total coincida con el precio del articulo
        this.cartPageElements.getPlaceOrderModal();
    }

    @Then("the user fills in the input fields in the Place Order modal with the data from {string}")
    public void the_user_fills_in_the_input_fields_in_the_place_order_modal_with_the_data_from(String csvFilePath) throws IOException {
        CsvDataLoader getCsvData = new CsvDataLoader(csvFilePath);

        this.placeOrderContext.setName(getCsvData.getInputDataFromCsv().get(0));
        this.placeOrderContext.setCountry(getCsvData.getInputDataFromCsv().get(1));
        this.placeOrderContext.setCity(getCsvData.getInputDataFromCsv().get(2));
        this.placeOrderContext.setCreditCard(getCsvData.getInputDataFromCsv().get(3));
        this.placeOrderContext.setCreditCardMonth(getCsvData.getInputDataFromCsv().get(4));
        this.placeOrderContext.setCreditCardYear(getCsvData.getInputDataFromCsv().get(5));

        this.cartPageElements.accessToInputFields(this.placeOrderContext);
    }

    @Then("the user presses the Purchase button")
    public void the_user_presses_the_purchase_button() {
        this.cartPageElements.clickPurchaseButton();
    }

    @Then("the webpage returns a modal with the message {string} along with the Card Number, Amount, and Name of the article")
    public void the_webpage_returns_a_modal_with_the_message_along_with_the_card_number_amount_and_name_of_the_article(String expectedMessage) {
        // Validar mensaje esperado {string}
        Assert.assertEquals(expectedMessage, this.cartPageElements.checkOutMessagePurchase());
    }

    @After
    public void closeDriver() {
        DriverManager.quitDriver();
    }
}
