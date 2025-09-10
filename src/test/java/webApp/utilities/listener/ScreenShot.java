package webApp.utilities.listener;

import webApp.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;


public class ScreenShot  extends BaseTest {
     private static final String imageEncode = "data:image/png;base64,";

    public ScreenShot() throws IOException {
    }


    public static String getScreenShot() {

            String base64Screenshot =  imageEncode + takeScreenShot();
            return base64Screenshot;
        }

        private static String takeScreenShot() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        }


}
