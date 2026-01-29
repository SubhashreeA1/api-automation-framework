package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    protected static ExtentReports extent;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
