package test;

import framework.ApplicationManager;
import framework.httpFactory.http.HttpClient;
import framework.helpers.HelperValue;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * базовый класс тестов, от которого наследуются все тесты
 */
@Listeners()
public class TestBase implements HelperValue {
    protected ApplicationManager app;
    protected static Logger log = Logger.getLogger("test");

    @BeforeSuite
    @Parameters({"configFile"})
    public void beforeAll(@Optional String configFile) throws FileNotFoundException, IOException {
        log.info("Начался набор сценариев");
    }

    @BeforeClass
    @Parameters({"configFile"})
    public void beforeClass(@Optional String configFile) throws FileNotFoundException, IOException {
        printDelimeter();
        printDelimeter();
        log.info("Начался сценарий: " + getClass().getSimpleName());
        configFile = getConfigFile(configFile);
        app = ApplicationManager.getInstance(configFile);
        HttpClient.getInstance();
    }

    private String getConfigFile(String configFile) {
        if (configFile == null)
            configFile = System.getProperty("configFile");
        if (configFile == null)
            configFile = System.getenv("configFile");
        String localProperties = "local.application.properties";
        if (configFile == null && new File(localProperties).exists())
            return localProperties;
        if (configFile == null)
            return "application.properties";
        return configFile;
    }

    @BeforeMethod
    public void beforeEach(Method method) {
        printDelimeter();
        log.info("Начался шаг: " + method.getName());
    }

    protected static void printDelimeter() {
        System.out.println("-------------------------------------------------------");
    }

    @AfterMethod
    public void afterEach(ITestResult result) {
        log.info("Закончился шаг: " + result.getMethod().getMethodName());
    }

    @AfterClass
    public void afterClass() {
        printDelimeter();
        log.info("Закончился сценарий: " + getClass().getSimpleName());
    }

    @AfterSuite
    public void afterAll() {
        HttpClient.shutdown();
        ApplicationManager.getInstance().stop();
        printDelimeter();
        log.info("Закончился набор сценариев");
        printDelimeter();
    }
}

