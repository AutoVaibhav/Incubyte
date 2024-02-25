package com.incubyte.manager;

import com.incubyte.enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
    private WebDriver driver;
    private static DriverType driverType;

    public DriverManager() {
        driverType = ReaderManager.getInstance().getConfigReader().getBrowserType();
    }

    public WebDriver getDriverForLaunch() {
        if (driver == null) {
            driver = createLocalDriverForLaunch();
        }
        return driver;
    }


    private WebDriver createLocalDriverForLaunch() {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
        return driver;
    }


    public void closeDriver() {
        driver.quit();
    }
}
