package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePageElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int LIMIT_WAIT_DRIVER = 5;

    public ArticlePageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(LIMIT_WAIT_DRIVER));
    }

    public String getArticleName() {
        try {
            WebElement articleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));

            return articleName.getText();
        } catch (TimeoutException e) {
            System.out.println("Error al obtener el nombre del articulo: " + e);

            return null;
        }
    }

    public String getArticlePrice() {
        try {
            WebElement articlePrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("price-container")));

            return articlePrice.getText();
        } catch (TimeoutException e) {
            System.out.println("Error al obtener el precio del articulo: " + e);

            return null;
        }
    }

    public String getArticleDescription() {
        try {
            WebElement articleDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("more-information")));

            return articleDescription.getText();
        } catch (TimeoutException e) {
            System.out.println("Error al obtener la descripcion del articulo: " + e);

            return null;
        }
    }

    public String addCartButtonGetText() {
        try {
            WebElement buttonAddCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tbodyid > div.row > div > a")));

            return buttonAddCart.getText();

        } catch (TimeoutException e) {
            System.out.println("Error de TimeOut al momento de hacer clic al boton 'Add to Cart': " + e);
            return null;
        }
    }

    public void clickAddCartButton() {
        try {
            WebElement buttonAddCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > div.row > div > a")));

            buttonAddCart.click();

        } catch (TimeoutException e) {
            System.out.println("Error de TimeOut al momento de encontrar al boton 'Add to Cart': " + e);
        }
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = this.driver.switchTo().alert();
        String ad = alert.getText();
        alert.accept();

        return ad;
    }
}
