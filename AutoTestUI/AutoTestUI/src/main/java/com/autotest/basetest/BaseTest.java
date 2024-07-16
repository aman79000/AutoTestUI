package com.autotest.basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseTest extends AutoTestCore {
    public BaseTest(WebDriver driver) {
        super(driver);
    }

    protected WebElement getFieldElement(By element) {
        return driver.findElement(element);

    }

    protected void fillValue(By element, String value) {
        waitForElementPresence(element);
        getFieldElement(element).sendKeys(value);
    }

    protected List<WebElement> getElements(By element) {
        return driver.findElements(element);
    }


    protected void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    protected void waitForElementPresence(By element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected void waitForElementPresence(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected void waitForElementToAppear(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void waitForElementToAppear(By element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void waitForElementToDisappear(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    protected void waitForElementToDisappear(By element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    protected void hoverElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    protected void doubleClick(WebElement element) {
        action.moveToElement(element).doubleClick().perform();
    }

    protected void rightClick(WebElement element) {
        action.moveToElement(element).contextClick().perform();
    }

    protected void waitUntilElementIsClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected String getElementValue(By element) {
        return getFieldElement(element).getText();
    }


}
