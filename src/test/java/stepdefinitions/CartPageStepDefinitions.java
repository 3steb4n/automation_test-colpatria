package stepdefinitions;

import org.junit.Assert;
import pages.CartPageElements;
import utils.AccessContext;
import utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CartPageStepDefinitions {
    private WebDriver driver;
    private AccessContext accessContext;
    private CartPageElements cartPageElements;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
        this.accessContext = AccessContext.getInstance();
    }

    @Given("the user is on the Product Page")
    public void the_user_is_on_the_product_page() {
        this.cartPageElements = new CartPageElements(this.driver);
    }

    @When("the user clicks the Cart navbar button")
    public void the_user_clicks_the_cart_navbar_button() {
        this.cartPageElements.clickCartHref();
    }

    @Then("the webpage returns the article added to the cart with its price and its name")
    public void the_webpage_returns_the_article_added_to_the_cart_with_its_price_and_its_name() {
        // Validar nombre y precio del articulo agregado en el escenario anterior con la informacion que retorna la tabla de productos agregados
        // .get(0) = nombre del articulo
        // .get(1) = precio del articulo
        Assert.assertEquals(this.accessContext.getArticleName(), this.cartPageElements.getInformationArticle().get(0));
        Assert.assertEquals(this.accessContext.getArticlePrice().replace("$", ""), this.cartPageElements.getInformationArticle().get(1));
    }
}
