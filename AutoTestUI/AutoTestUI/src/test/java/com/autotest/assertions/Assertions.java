package com.autotest.assertions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions {
    private SoftAssert softAssert;

    protected Assertions() {
        softAssert = new SoftAssert();
    }

    protected void AssertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    protected void AssertEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    protected void AssertTrue(boolean actual) {
        Assert.assertTrue(actual);
    }

    protected void AssertTrue(boolean actual, String message) {
        Assert.assertTrue(actual, message);
    }

    protected void AssertNotEquals(String actual, String expected) {
        Assert.assertNotEquals(actual, expected);
    }

    protected void AssertNotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    protected void AssertFalse(boolean actual) {
        Assert.assertFalse(actual);
    }

    protected void AssertFalse(boolean actual, String message) {
        Assert.assertFalse(actual, message);
    }

    protected void AssertFail() {
        Assert.fail();
    }

    protected void softAssertEquals(String actual, String expected) {
        softAssert.assertEquals(actual, expected);
    }

    protected void softAssertEquals(String actual, String expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    protected void softAssertTrue(boolean actual) {
        softAssert.assertTrue(actual);
    }

    protected void softAssertTrue(boolean actual, String message) {
        softAssert.assertTrue(actual, message);
    }


    protected void softAssertFalse(boolean actual) {
        softAssert.assertFalse(actual);
    }


    protected void softAssertFalse(boolean actual, String message) {
        softAssert.assertFalse(actual, message);
    }

    protected void softAssertNotEquals(String actual, String expected) {
        softAssert.assertNotEquals(actual, expected);
    }

    protected void softAssertNotEquals(String actual, String expected, String message) {
        softAssert.assertNotEquals(actual, expected, message);
    }

    protected void softAssertAll() {
        softAssert.assertAll();
    }
}
