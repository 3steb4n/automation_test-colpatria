package utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;
    private static EnvironmentVariables env;

    public static WebDriver getBrowserDriver() {
        if (driver == null) {
            String driverSelected = EnvironmentSpecificConfiguration.from(env).getProperty("driver").toLowerCase();

            switch (driverSelected) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    System.setProperty("webdriver.firefox.driver", "src/test/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    throw new IllegalArgumentException("Navegador inválido: " + "'" + driverSelected + "'");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}