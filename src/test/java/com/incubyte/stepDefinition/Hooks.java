package com.incubyte.stepDefinition;

import com.incubyte.contextManager.TextContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    TextContext textContext;

    public Hooks(TextContext textContext) {
        this.textContext = textContext;
    }

    @Before
    public void beforeScenario() {

    }
    @AfterStep
    public void captureScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) textContext.getDriverManager().getDriverForLaunch()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }
    @After
    public void afterScenario() {
        textContext.getDriverManager().closeDriver();
    }
}
