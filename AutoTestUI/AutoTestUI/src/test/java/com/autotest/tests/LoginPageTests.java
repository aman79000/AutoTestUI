package com.autotest.tests;


import com.autotest.assertions.Assertions;
import com.autotest.pages.LoginPage;
import com.autotest.utils.PropertiesUtils;
import com.autotest.utils.WebDriverConfig;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginPageTests
    extends Assertions
{
    WebDriverConfig webDriverConfig;
    WebDriver driver;
    LoginPage loginPage;
    PropertiesUtils properties;

    @BeforeMethod(alwaysRun=true)
    public void initilize() {
    	webDriverConfig= WebDriverConfig.getInstance("chrome");
    	driver= webDriverConfig.getDriver();
        loginPage = new LoginPage(driver);
        properties= new PropertiesUtils();
        loginPage.navigate(properties.getUrl());
    }

    @Test(priority=1)
    public void ValidLoginwithStandardUser(){
     loginPage.enterUserName("standard_user");
     loginPage.enterPassword("secret_sauce");
     loginPage.login();
     AssertEquals(driver.getTitle(),"Swag Labs","TitleValueDoesN't match");

    }

    @Test(priority=2)
    public void InvalidLoginWithIncorrectPassword(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("wrongPassword");
        loginPage.login();
        AssertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message doesn't displayed correctly");

    }

    @Test(priority=3)
    public void InvalidLoginWithIncorrectUserName(){
        loginPage.enterUserName("wrongPassword");
        loginPage.enterPassword("secret_sauce");
        loginPage.login();
        AssertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message doesn't displayed correctly");

    }
    @Test(priority=5)
    public void InvalidLoginWithEmptyFields(){
        loginPage.login();
        AssertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Error message doesn't displayed correctly");

    }

    @Test(priority=4)
    public void InvalidLoginWithLockedOutUser(){
        loginPage.enterUserName("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.login();
        AssertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Error message doesn't displayed correctly");

    }
//    @Test
//    public void VerifyLogoutFunctionality(){
//        loginPage.enterUserName("locked_out_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.login();
//        AssertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Error message doesn't displayed correctly");
//
//    }

    @AfterMethod
    public void terminate(){
       webDriverConfig.terminate();
    }
}
