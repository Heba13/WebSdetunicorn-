package webApp.tests;

import org.openqa.selenium.WebDriver;
import webApp.driver.WebDriverConfig;

import java.io.IOException;

public class BaseTest {
   public static WebDriver driver ;
   public WebDriverConfig webDriverConfig ;

    public BaseTest() throws IOException {
        driver = webDriverConfig.getWebDriver();
    }


}
