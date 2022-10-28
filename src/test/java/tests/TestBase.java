package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class TestBase {


    protected WebDriver driver;
    protected static ExtentReports extentReport; // report generation management
    protected static ExtentSparkReporter htmlReport;  // genrerate html file
    protected static ExtentTest logger;  // logging the test



    @BeforeSuite (alwaysRun = true)
    public void setupSuite(){
        extentReport = new ExtentReports();
        String path = System.getProperty("user.dir") + "/target/extentReports/htmlReport.html";
        htmlReport = new ExtentSparkReporter(path);
        extentReport.attachReporter(htmlReport);


        extentReport.setSystemInfo("Name", "Web Orders UI Tests");
        extentReport.setSystemInfo("SDETs", "John Doe, Jane Doe");
        extentReport.setSystemInfo("Env", "QA/TEST");
        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReport.setSystemInfo("URL", ConfigReader.getProperty("url"));

    }



    @BeforeMethod(alwaysRun = true)
    public void setupMethod(Method method){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
        driver.get(ConfigReader.getProperty("url"));

        logger = extentReport.createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult testResult){

        if(testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("TEST PASSED.");
        }else if(testResult.getStatus() == ITestResult.SKIP){
            logger.skip("TEST SKIPPED.");
        }else if(testResult.getStatus() == ITestResult.FAILURE){
            logger.fail("TEST FAILED.");
            logger.fail(testResult.getThrowable());
            logger.addScreenCaptureFromPath(SeleniumUtils.getScreenshot("failed"));
        }



        Driver.quitDriver();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDownSuite(){
         extentReport.flush();
    }

}
