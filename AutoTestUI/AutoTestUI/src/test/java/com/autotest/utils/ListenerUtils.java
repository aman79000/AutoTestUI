package com.autotest.utils;

//import org.apache.commons.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerUtils implements ITestListener, IReporter {

    Logger log = LogManager.getLogger(ListenerUtils.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {

        log.info("Executing Test: " + iTestResult.getName());
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = null;
        try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass()
                    .getDeclaredField("driver").get(iTestResult.getInstance());
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
                 | SecurityException e) {
            e.printStackTrace();
        }

        try {
            takeFailScreenShot(driver, iTestResult.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Test Fail: " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Skipped Test: " + iTestResult.getName());
    }



    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test Pass: " + iTestResult.getName());
    }


    public void takeFailScreenShot(WebDriver driver, String testName) throws IOException {
       File destFile = new File("/c/"+testName);
       File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      // FileUtils.copyFile(srcFile,destFile);

    }




}


