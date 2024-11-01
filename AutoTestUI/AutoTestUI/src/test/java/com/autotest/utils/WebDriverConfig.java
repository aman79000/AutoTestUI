package com.autotest.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverConfig {
    private static volatile WebDriverConfig instance;
    private  static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverConfig()  {
       try {
           if (instance != null) {
               throw new IllegalAccessException("Object of WebDriverConfig already exists");
           }
       }
       catch(IllegalAccessException e){
           e.printStackTrace();
       }

    }

    public static WebDriverConfig getInstance(String browser) {
        if (instance == null) {
            synchronized (WebDriverConfig.class) {
                if (instance == null) {
                    instance = new WebDriverConfig();
                }
            }
        }
        if (driver.get() == null) {
            initilize(browser);
        }
        return instance;
    }

    private static void initilize(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        else {
            System.out.print("The brower is not supported");
        }

    }

    public WebDriver getDriver() {
        return driver.get();

    }

    public void terminate() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }


}
