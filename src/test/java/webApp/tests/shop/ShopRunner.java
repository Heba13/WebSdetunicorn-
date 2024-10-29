package webApp.tests.shop;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/webApp/tests",
        glue = { "webApp.tests"}
)
public class ShopRunner extends AbstractTestNGCucumberTests {
}