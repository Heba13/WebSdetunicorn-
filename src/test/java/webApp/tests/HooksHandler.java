package webApp.tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webApp.driver.WebDriverConfig;
import webApp.utilities.extentReport.ExtentReport;
import webApp.utilities.extentReport.ScreenShot;
import java.io.IOException;
import java.net.URISyntaxException;

public class HooksHandler  extends BaseTest{

    public HooksHandler() throws IOException {
        super();
    }

    @Before
    public void setWebConfiguration() throws IOException {
        webDriverConfig = new WebDriverConfig();
        webDriverConfig.navigateTo("https://practice-react.sdetunicorns.com/");
    }


    @Before(order= 1)
    public void startTC(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setScenario(scenario);
        ExtentReport.startTC();
        ExtentReport.setStepDefs();
    }


    @After(order=1)
    public void tearDown() {
        WebDriverConfig.close();
    }

    @After(order = 2)
    public void endTC() throws URISyntaxException, IOException {
        {
            ExtentReport.reportTearDown();
        }
    }


    @AfterStep
    public void AfterStep(Scenario scenario) {
        String stepName = ExtentReport.getCurrentStepName();
        Status logStatus;

        if (scenario.isFailed()) {
            logStatus = Status.FAIL;
            String base64Screenshot = ScreenShot.getScreenShot();
            ExtentReport.getTest().log(logStatus, stepName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
        else {
            logStatus = Status.PASS;
            ExtentReport.getTest().log(logStatus, stepName);
        }


    }


}
