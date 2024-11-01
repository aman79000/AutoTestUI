package com.autotest.basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AutoTestCore {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Actions action;

    public AutoTestCore(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        action = new Actions(this.driver);
    }


    void scrollIntoView(WebElement element) {
    }

    void waitForElementPresence(By element, Long timeout) {

    }

    void waitForElementPresence(By element) {

    }

    void waitForElementToAppear(By element) {

    }

    void waitForElementToAppear(By element, Long timeout) {
    }

    void waitForElementToDisappear(By element) {

    }

    void waitForElementToDisappear(By element, Long timeout) {

    }

    void hoverElement(WebElement element) {
    }

    void doubleClick(WebElement element) {
    }

    void rightClick(WebElement element) {

    }
}
