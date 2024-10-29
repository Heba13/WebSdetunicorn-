package webApp.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.io.IOException;

public class WebDriverConfig {
    private static String driverType = "chrome" ;
    private static WebDriver webDriver;
    public WebDriverConfig() throws IOException {
        getDriverType(driverType);    }
    private void getDriverType(String driverType) throws IOException {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();

                break;

            case "edge":
                EdgeOptions edgeCapabilities = new EdgeOptions();
                webDriver = new EdgeDriver(edgeCapabilities);
                webDriver.manage().window().maximize();
                break;

            case "safari":
                SafariOptions safariCapabilities = new SafariOptions();
                webDriver = new SafariDriver(safariCapabilities);
                webDriver.manage().window().maximize();
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                webDriver = new FirefoxDriver(firefoxOptions);
                webDriver.manage().window().maximize();
                break;
        }

    }

    public static WebDriver getWebDriver() {

        return webDriver;
    }

    public void navigateTo(String link) {
        webDriver.navigate().to(link);
    }

    public static void close() {
        webDriver.quit();
    }
}