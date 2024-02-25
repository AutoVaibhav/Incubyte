package com.incubyte.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFile",
        glue = {
                "com/incubyte/stepDefinition",
        },
        tags = "@GmailDraft",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true
)

public class TestRunner {
}
