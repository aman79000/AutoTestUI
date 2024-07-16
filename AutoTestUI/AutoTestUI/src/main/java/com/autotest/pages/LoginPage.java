package com.autotest.pages;

import com.autotest.basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseTest
{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By userNameField =By.xpath("//input[@id=\"user-name\"]");

    private final By passwordField= By.xpath("//input[@id=\"password\"]");

    private final By loginButton= By.xpath("//input[@id=\"login-button\"]");
    private final By errorMessage=By.xpath("//div[@class='error-message-container error']");


    public void enterUserName(String userName){
        fillValue(userNameField,userName);
    }

    public void enterPassword(String password){
        fillValue(passwordField,password);
    }

    public void login(){
        waitUntilElementIsClickable(loginButton);
        getFieldElement(loginButton).click();
    }

    public String getErrorMessage(){
   return getElementValue(errorMessage);
    }
    public void navigate(String url){
        driver.get(url);
    }



}
