package tests;

import core.TestDataListener;
import io.restassured.RestAssured;
import org.testng.annotations.*;

/**
 * Class with customization test initialization
 * You can override methods for specify test cases
 */
@Listeners({TestDataListener.class})
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        RestAssured.reset();
    }

    @BeforeSuite(alwaysRun = true)
    public void init() {
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
    }
}