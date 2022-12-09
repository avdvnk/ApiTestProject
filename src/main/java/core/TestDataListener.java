package core;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Listener class for logging and additional actions during test running
 */
@Slf4j
public class TestDataListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test finished successfully: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test failed: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test skipped: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Running test: " + result.getMethod().getDescription() + "\n");
    }
}