package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",  // Path to feature files
        glue = "StepDefinitions",             // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"},  // Reporting
        monochrome = true                    // For better console output
)
public class TestRunner {
}
