package pages;

import java.util.ArrayList;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class LogInElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int LIMIT_WAIT_DRIVER = 5;

    public LogInElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(LIMIT_WAIT_DRIVER));
    }

    public void accessToInputFields(ArrayList<String> userDate) {
        try {
            WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
            WebElement userPwField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
    
            userNameField.sendKeys(userDate.get(0).toString());
            userPwField.sendKeys(userDate.get(1).toString());
        } catch (TimeoutException e) {
            System.out.println("Error de TimeOut al momento de acceder a los campos de texto del modal 'Login'" + e);
        }
    }

    public void logInButtonAccess() {
        try {
            WebElement buttonLogInModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='logIn()']")));

            buttonLogInModal.click();
        } catch (TimeoutException e) {
            System.out.println("Error de TimeOut al momento de acceder al boton 'Log in' del modal: " + e);
        }
    }

    public void logInButtonIndex() {
        try {
            WebElement buttonLogInIndex = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));

            buttonLogInIndex.click();
        } catch (TimeoutException e) {
            System.out.println("Error de TimeOut al momento de acceder al boton 'Log in' de la pagina principal" + e);
        }
    }
}
