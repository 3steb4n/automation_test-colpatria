package stepdefinitions;

import org.junit.Assert;
import pages.CategoriesArticlesElements;
import pages.ArticlePageElements;
import utils.AccessContext;
import utils.DriverManager;
import utils.CsvDataLoader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CategoriesArticlesStepDefinitions {
    private WebDriver driver;
    private AccessContext accessContext;
    private CategoriesArticlesElements categoriesIndexElements;
    private ArticlePageElements articlePageElements;
    private List<String> categoriesGroup;

    @Before
    public void setup() {
        this.driver = DriverManager.getBrowserDriver();
        this.categoriesIndexElements = new CategoriesArticlesElements(driver);
        this.articlePageElements = new ArticlePageElements(driver);
        this.accessContext = AccessContext.getInstance();
    }

    @Given("the user is on the DemoBlaze website with the categories list")
    public void the_user_is_on_the_demo_blaze_website_with_the_categories_list() {
        this.categoriesGroup = categoriesIndexElements.getCategories();
    }

    @When("the user selects its category and article defined in the {string}")
    public void the_user_selects_its_category_and_article_defined_in_the(String csvFilePath) throws Exception {
        CsvDataLoader getCsvData = new CsvDataLoader(csvFilePath);
        String categoryUser = getCsvData.getInputDataFromCsv().get(2);
        String articleUser = getCsvData.getInputDataFromCsv().get(3);

        categoriesIndexElements.clickCategory(categoryUser, this.categoriesGroup);
        categoriesIndexElements.clickArticle(articleUser);

        accessContext.setArticleName(categoriesIndexElements.articleFullName);
        accessContext.setArticlePrice(categoriesIndexElements.articlePrice);
        accessContext.setArticleDescription(categoriesIndexElements.articleDescription);
    }

    @Then("the user is returned to the Article Page with its name, price and description, and the {string} button")
    public void the_user_is_returned_to_the_article_page_with_its_name_price_and_description_and_the_button(String addToCartButton) {
        // Comparar los datos del articulo elegido contra los que retorna la pagina de este mismo
        Assert.assertEquals(articlePageElements.getArticleName(), accessContext.getArticleName());
        Assert.assertEquals(articlePageElements.getArticlePrice(), accessContext.getArticlePrice() + " *includes tax");

        //Validar el retorno del boton Add To Cart
        Assert.assertEquals(articlePageElements.addCartButtonGetText(), addToCartButton);
    }
}
