package pages;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class CategoriesIndexElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int LIMIT_WAIT_DRIVER = 5;

    public CategoriesIndexElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(LIMIT_WAIT_DRIVER));
    }

    public void clickCategories(String categorie) throws Exception {
        Boolean matchText = false;

        for (String filterCategories : getCategories()) {
            if (filterCategories.toLowerCase() == categorie.toLowerCase()) {
                matchText = true;

                try {
                    WebElement categorieElement = wait.until(ExpectedConditions
                            .elementToBeClickable(By.xpath("//a[text()='" + filterCategories + "']")));
                    categorieElement.click();
                } catch (TimeoutException e) {
                    System.out.println("Error al encontrar la categoria: " + e);
                }
                break;
            }
        }

        if (!matchText) {
            throw new Exception("No se encontró ninguna categoría con el nombre: " + categorie);
        }
    }

    public void clickArticle(String article) throws Exception {
        List<WebElement> h4Elements = driver.findElements(By.xpath("//div[@id='tbodyid']//h4"));

        // Iterar sobre los elementos y extraer el texto
        for (WebElement h4 : h4Elements) {
            String h4Text = h4.getText();

            if (h4Text.toLowerCase().contains(article.toLowerCase())) {
                WebElement categorieElement = wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//a[text()='" + h4Text + "']")));

                categorieElement.click();

                break;
            } else {
                try {
                    WebElement buttonNext = wait.until(ExpectedConditions
                            .elementToBeClickable(By.id("next2")));

                    buttonNext.click();
                    clickArticle(article);
                } catch (TimeoutException e) {
                    System.out.println("No se encontró ningun alrticulo con el nombre: " + article);
                }
            }
        }
    }

    public ArrayList<String> getCategories() {
        ArrayList<String> itemsText = new ArrayList<>();

        try {
            WebElement categories = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("list-group")));
            List<WebElement> items = categories.findElements(By.tagName("a"));

            for (WebElement extractItems : items) {
                itemsText.add(extractItems.getText());
            }
        } catch (TimeoutException e) {
            System.out.println("Error de TimeOut al momento de acceder a los items de las categorias: " + e);
        }
        return itemsText;
    }
}
