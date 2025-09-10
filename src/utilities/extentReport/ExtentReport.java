package webApp.utilities.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExtentReport {
    public static ExtentSparkReporter reporter ;                            ///  *** (1) *** /// *** Load configuration & create Report///
    private final  static ExtentReports extentReport = new ExtentReports(); ///  *** (2) *** /// ** Log test case Status ///
    private static ExtentTest test ;
    private static Scenario scenario ;
    private  static List<PickleStepTestStep> stepDefs;
    static int currentStepDefIndex;
    public static int tcNumber = 1;


    @BeforeTest
    public void startReport() throws IOException {
        initializeReportConfiguration("SampleReport");
    }

    public void  initializeReportConfiguration(String reportName) throws IOException {
        // start reporters
         reporter = new ExtentSparkReporter("./reports/SampleReport.html");    ///*** (3) *** /// ***define Reporter & Set for Path to create report///
        // create ExtentReports and attach reporter(s)
        extentReport.attachReporter(reporter);
        ///*** (4) *** /// *** attach function  & pass reporter with pasth and configration///
        /// Load configuration and initial System Data ///

        extentReport.setSystemInfo("User Name",System.getProperty("user.name"));

        reporter.loadXMLConfig("src/test/java/Sample/utilities/extentReport/extentc-onfig.xml");
    }

    public static void setScenario(Scenario currentScenario) {
        ExtentReport.scenario = currentScenario;
    }

    public static void startTC() {
      // String testCaseName = "TesetCase" + tcNumber ++ ;
        String testCaseName = scenario.getName();
        test = extentReport.createTest(testCaseName);   //***(5) ***Create Extend Test case & initiate ***//
        System.out.print(test.toString());
        currentStepDefIndex= 0 ;
        test.assignCategory(getFeatureFileName());
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setStepDefs() throws NoSuchFieldException, IllegalAccessException {

        TestCase testCase = getTestCase();
         stepDefs = getTestStepsDefs(testCase); //get List of Steps for current scenario
    }

    public static String getCurrentStepName(){
        String currentStepDescription;
        PickleStepTestStep currentStepDef = stepDefs.get(currentStepDefIndex);
        currentStepDescription = currentStepDef.getStep().getText();
        currentStepDefIndex += 1;
        return currentStepDescription ;
    }

    private static List<PickleStepTestStep> getTestStepsDefs(TestCase testCase) {
        return testCase.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());
    }

    private static TestCase getTestCase() throws NoSuchFieldException, IllegalAccessException {
        Field delegateField = scenario.getClass().getDeclaredField("delegate");
        delegateField.setAccessible(true);  // to access delegate  object for current scenario
        TestCaseState testCaseState = (TestCaseState) delegateField.get(scenario); //TCState
        Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
        testCaseField.setAccessible(true);
        TestCase testCase = (TestCase) testCaseField.get(testCaseState);
        return testCase;
    }

    @AfterTest
    public static void reportTearDown() {
      //calling flush write everything to the log file
        extentReport.flush();
    }


    public static String getFeatureFileName() {

        Path featureFilePath = Paths.get(scenario.getUri());
        String fileName = featureFilePath.getFileName().toString();
        String[] parts = fileName.split("\\.feature");
        return parts[0];
    }



}
