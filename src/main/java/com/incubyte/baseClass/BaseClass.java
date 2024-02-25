package com.incubyte.baseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseClass {
    static WebDriver driver;

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver, null);
    }

    public static void waitForVisibility(WebElement element, int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void javaScriptClick(WebDriver driverClass, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driverClass;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void staticWaitForVisibility(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Throwable e) {
        }
    }


}
