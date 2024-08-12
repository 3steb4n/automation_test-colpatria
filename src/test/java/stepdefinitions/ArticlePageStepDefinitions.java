package stepdefinitions;

import org.junit.Assert;
import pages.ArticlePageElements;
import utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ArticlePageStepDefinitions {
    private WebDriver driver;
    private ArticlePageElements articlePageElements;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
    }

    @Given("the user is on Product Page")
    public void the_user_is_on_product_page() {
        this.articlePageElements = new ArticlePageElements(this.driver);
    }

    @When("the user clicks the Add to Cart button")
    public void the_user_clicks_the_add_to_cart_button() throws Exception {
        this.articlePageElements.clickAddCartButton();
    }

    @Then("the webpage returns the alert message {string}")
    public void the_webpage_returns_the_alert_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, this.articlePageElements.getAlertText());
    }
}
