package webApp.utilities.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExtentReport {
    private static ExtentReports extentReport ;
    public static ExtentSparkReporter reporter;
    static int currentStepDefIndex;
    private static ExtentTest test;
    private static Scenario scenario;
    private static List<PickleStepTestStep> stepDefs;

    public static void setScenario(Scenario currentScenario) {
        ExtentReport.scenario = currentScenario;
    }

    public static void startTC() {
        String testCaseName = scenario.getName();
        test = extentReport.createTest(testCaseName);
        currentStepDefIndex = 0;
        test.assignCategory(getFeatureFileName());
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setStepDefs() throws NoSuchFieldException, IllegalAccessException {

        TestCase testCase = getTestCase();
        stepDefs = getTestStepDefs(testCase);
    }

    public static String getCurrentStepName() {
        String currentStepDescription;
        PickleStepTestStep currentStepDef = stepDefs.get(currentStepDefIndex);
        currentStepDescription = currentStepDef.getStep().getText();
        currentStepDefIndex += 1;
        return currentStepDescription;
    }

    private static List<PickleStepTestStep> getTestStepDefs(TestCase testCase) {
        return testCase.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());
    }

    private static TestCase getTestCase() throws NoSuchFieldException, IllegalAccessException {
        Field delegateField = scenario.getClass().getDeclaredField("delegate");
        delegateField.setAccessible(true);
        TestCaseState testCaseState = (TestCaseState) delegateField.get(scenario);
        Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
        testCaseField.setAccessible(true);
        TestCase testCase = (TestCase) testCaseField.get(testCaseState);
        return testCase;
    }


    @BeforeSuite
    public void startReport(org.testng.ITestContext context) throws IOException {
        String reportName = context.getName();
        System.out.println(reportName);
        initializeReportConfiguration(reportName);
    }

    public void initializeReportConfiguration(String reportName) throws IOException {
        reporter = new ExtentSparkReporter("./reports/" + reportName+".html");
        extentReport = new ExtentReports();
        extentReport.setSystemInfo("Report Name",reportName);
        extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
        reporter.loadXMLConfig("src/test/java/webApp/utilities/extentReport/extenc-config.xml");

        extentReport.attachReporter(reporter);
    }


    @AfterSuite
    public static void reportTearDown() {
        extentReport.flush();
    }

    public static String getFeatureFileName() {
        Path featureFilePath = Paths.get(scenario.getUri());
        String fileName = featureFilePath.getFileName().toString();
        String[] parts = fileName.split("\\.feature");
        return parts[0];
    }
}

